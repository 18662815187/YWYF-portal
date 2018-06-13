package com.lwyykj.core.user.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwyykj.common.EncodePassword;
import com.lwyykj.core.bean.user.User;
import com.lwyykj.core.bean.utils.Vercode;
import com.lwyykj.core.dao.user.UserDao;
import com.lwyykj.core.dao.user.UserLoginInfo;
import com.lwyykj.core.dao.utils.VercodeDao;
import com.lwyykj.core.user.service.RegisterService;

/**
 * 
 * @author yl 2018.4.24 注册服务
 *
 */

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
	@Resource
	private VercodeDao vercodeDao;
	@Resource
	private UserDao userDao;

	@Override
	public UserLoginInfo apply(String returnUrl, String tel, String pwd, String pwd1, String code, String token,
			Integer addType) {
		int now = (int) (new Date().getTime() / 1000);
		UserLoginInfo userLoginInfo = new UserLoginInfo();
		if (null != tel && !"".equals(tel) && null != pwd && !"".equals(pwd) && null != pwd1 && !"".equals(pwd1)) {
			if (null != token && !"".equals(token)) {
				if (null != code && !"".equals(code)) {
					if (pwd.equals(pwd1)) {
						Vercode vercode = vercodeDao.selectByTel(tel);
						if (null != vercode) {
							if (vercode.getToken().equals(token)) {
								if (vercode.getCode().equals(code)) {
									if (vercode.getExpireTime() > now) {
										User user1 = userDao.selectByTel(tel);
										if (null != user1) {
											userLoginInfo.setReturnUrl(returnUrl);
											userLoginInfo.setMsg("手机号已存在，请更换后重新注册!");
											// 10008用户存在
											userLoginInfo.setStatus(10008);
										} else {
											User user = new User();
											user.setTel(tel);
											user.setNickname(tel);
											user.setAddtime((int) (new Date().getTime() / 1000));
											user.setPwd(EncodePassword.encodePassword(pwd));
											user.setAddType(addType);
											int result = userDao.insertSelective(user);
											if (result > 0) {
												// 清除验证码记录
												vercodeDao.deleteByPrimaryKey(vercode.getId());
												userLoginInfo.setReturnUrl(returnUrl);
												userLoginInfo.setStatus(10000);
												userLoginInfo.setMsg("注册成功!");
											} else {
												userLoginInfo.setReturnUrl(returnUrl);
												userLoginInfo.setMsg("注册失败，请重试!");
												// 10007注册失败
												userLoginInfo.setStatus(10007);
											}
										}
									} else {
										userLoginInfo.setMsg("验证码超时失效,请重新获取!");
										userLoginInfo.setReturnUrl(returnUrl);
										userLoginInfo.setStatus(10008);
									}

								} else {
									userLoginInfo.setReturnUrl(returnUrl);
									userLoginInfo.setMsg("验证码错误!");
									// 10005无验证码记录
									userLoginInfo.setStatus(10005);
								}
							} else {
								userLoginInfo.setReturnUrl(returnUrl);
								userLoginInfo.setMsg("验证失败!");
								// 10004无验证码记录
								userLoginInfo.setStatus(10004);
							}
						} else {
							userLoginInfo.setReturnUrl(returnUrl);
							userLoginInfo.setMsg("请点击验证码按钮获取验证码!");
							// 10003无验证码记录
							userLoginInfo.setStatus(10003);
						}
					} else {
						userLoginInfo.setReturnUrl(returnUrl);
						userLoginInfo.setMsg("两次输入的密码不一致!");
						// 10006无验证码记录
						userLoginInfo.setStatus(10006);
					}

				} else {
					userLoginInfo.setReturnUrl(returnUrl);
					userLoginInfo.setMsg("验证码不能为空!");
					// 编码10002验证码为空
					userLoginInfo.setStatus(10002);
				}
			} else {
				userLoginInfo.setReturnUrl(returnUrl);
				userLoginInfo.setMsg("验证令牌失败，请重试!");
				// 编码10001密令为空
				userLoginInfo.setStatus(10001);
			}
		} else {
			userLoginInfo.setReturnUrl(returnUrl);
			userLoginInfo.setMsg("手机号或密码不能为空!");
			// 编码10001手机号为空
			userLoginInfo.setStatus(10003);
		}

		return userLoginInfo;
	}

}
