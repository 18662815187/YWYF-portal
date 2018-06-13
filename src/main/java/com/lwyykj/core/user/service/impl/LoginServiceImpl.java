package com.lwyykj.core.user.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.lwyykj.common.Constants;
import com.lwyykj.common.EncodePassword;
import com.lwyykj.common.UserAgentUtil;
import com.lwyykj.core.bean.record.LoginRecord;
import com.lwyykj.core.bean.user.LoginUtil;
import com.lwyykj.core.bean.user.User;
import com.lwyykj.core.dao.record.LoginRecordDao;
import com.lwyykj.core.dao.user.UserDao;
import com.lwyykj.core.user.service.LoginService;

/**
 * 
 * @author yl 2018.4.29 登录验证服务
 *
 */
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	@Resource
	private LoginRecordDao loginRecordDao;
	@Resource
	private UserDao userDao;

	// 插入登录记录
	@Override
	public int insertLoginRecord(LoginRecord loginRecord) {
		return loginRecordDao.insertSelective(loginRecord);
	}

	// 登录验证
	@Override
	public LoginUtil login(HttpServletRequest request, String tel, String password, String verifyCode,String returnUrl) {
		LoginUtil loginUtil = new LoginUtil();
		User user2 = new User();
		String code = null;
		HttpSession session = request.getSession();
		// 如有验证码优先级在最前面
		if (null != verifyCode) {
			// 1.用户名不能为空
			if (null != tel) {
				// 2.密码不能为空
				if (null != password) {
					// 验证码是否正确
					// 1:获取cookie里面的验证码信息
					Cookie[] cookies = request.getCookies();
					if (cookies != null && cookies.length > 0) {
						for (Cookie cookie : cookies) {
							if ("imagecode".equals(cookie.getName())) {
								code = cookie.getValue();
								// System.out.println("***************这是COOKIE的："
								// + code);
								break;
							}
						}
					} else {
						// 1:获取session验证码的信息
						String key = (String) request.getSession().getAttribute("sessionkey");
						code = (String) request.getSession().getAttribute(key);
						// System.out.println("***************这是session的：" +
						// code);
					}
					if (!StringUtils.isEmpty(verifyCode) && verifyCode.equals(code)) {
						// 3.用户名必须正确
						User user = userDao.selectByTel(tel);
						if (null != user) {
							// 4.密码必须正确
							if (user.getPwd().equals(EncodePassword.encodePassword(password))) {
								// 5.保存用户名到session，原名JSESSIONID，自定义为CSESSIONID，
								// 避免被request使用造成在集群中其他机器重新生成而取不到数据，生成
								// 规则为UUID（36位带“-”连接），把4个“-”去掉剩余32位
								// 首次使用session需要创建后保存到cookie，非首次直接在cookie取
								session.setAttribute(Constants.USER_NAME, user.getNickname());
								session.setMaxInactiveInterval(60 * 30);
								session.setAttribute("isShow", user.getStatus());
								session.setAttribute("uid", user.getId());
								int id = user.getId();
								session.setAttribute(Constants.LOGIN_STATUS, false);
								String uagent = UserAgentUtil.GETAGENT(request);
								LoginRecord loginRecord = new LoginRecord();
								if (null != uagent && uagent != "") {
									loginRecord.setLoginDevice(uagent.split(",")[0]);
									loginRecord.setBrowerVer(uagent.split(",")[1]);
								}
								loginRecord.setUid(id);
								loginRecord.setLoginTime((int) (new Date().getTime() / 1000));
								loginRecordDao.insertSelective(loginRecord);
								loginUtil.setMsg("登录成功!");
								loginUtil.setUser(user);
								loginUtil.setReturnUrl(returnUrl);
								// 状态码1，登录成功
								loginUtil.setResult(1);
								return loginUtil;

							} else {
								user2.setTel(tel);
								user2.setPwd(password);
								loginUtil.setMsg("密码不正确，请重新输入");
								loginUtil.setUser(user2);
								loginUtil.setReturnUrl(returnUrl);
								// 2密码错误
								loginUtil.setResult(2);
								return loginUtil;
							}
						} else {
							user2.setTel(tel);
							user2.setPwd(password);
							loginUtil.setReturnUrl(returnUrl);
							loginUtil.setMsg("该账号还未注册!");
							loginUtil.setUser(user2);
							// 3用户名不存在
							loginUtil.setResult(3);
							return loginUtil;
						}
					} else {
						user2.setTel(tel);
						user2.setPwd(password);
						loginUtil.setReturnUrl(returnUrl);
						loginUtil.setMsg("验证码错误,请核对后重新输入!");
						loginUtil.setUser(user2);
						// 4验证码有误
						loginUtil.setResult(4);
						return loginUtil;
					}
				} else {
					user2.setTel(tel);
					user2.setPwd(password);
					loginUtil.setReturnUrl(returnUrl);
					loginUtil.setMsg("密码不能为空!");
					loginUtil.setUser(user2);
					// 5密码为空
					loginUtil.setResult(5);
					return loginUtil;
				}
			} else {
				user2.setTel(tel);
				user2.setPwd(password);
				loginUtil.setReturnUrl(returnUrl);
				loginUtil.setMsg("用户名不能为空!");
				loginUtil.setUser(user2);
				// 6用户名空
				loginUtil.setResult(6);
				return loginUtil;
			}
		} else {
			user2.setTel(tel);
			user2.setPwd(password);
			loginUtil.setReturnUrl(returnUrl);
			loginUtil.setMsg("验证码错误,请核对后重新输入!");
			loginUtil.setUser(user2);
			// 7验证码为空
			loginUtil.setResult(7);
			return loginUtil;
		}
	}

}
