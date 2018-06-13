package com.lwyykj.core.user.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lwyykj.common.EncodePassword;
import com.lwyykj.core.bean.user.MailList;
import com.lwyykj.core.bean.user.MailListQuery;
import com.lwyykj.core.bean.user.User;
import com.lwyykj.core.bean.user.UserQuery;
import com.lwyykj.core.bean.user.UserQuery.Criteria;
import com.lwyykj.core.bean.utils.Vercode;
import com.lwyykj.core.bean.user.UserUtil;
import com.lwyykj.core.dao.user.MailListDao;
import com.lwyykj.core.dao.user.MsgDao;
import com.lwyykj.core.dao.user.UserDao;
import com.lwyykj.core.dao.utils.VercodeDao;
import com.lwyykj.core.user.service.UserService;

/**
 * 
 * @author yl 2018.5.4 用户服务包含用户中心和登录所需所有服务
 *
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private MailListDao mailListDao;
	@Resource
	private VercodeDao vercodeDao;
	@Resource
	private MsgDao msgDao;

	// 根据手机号查询用户
	@Override
	public User selectByTel(String tel) {
		return userDao.selectByTel(tel);
	}

	// 主键查询
	@Override
	public User selectByPrimary(Integer id) {
		UserQuery userQuery = new UserQuery();
		userQuery.setFields(
				"id, tel,sex, age, nickname, adreess, qrcode, signature, pic, user_url,more, money, param1, addtime,status");
		Criteria createCriteria = userQuery.createCriteria();
		createCriteria.andIdEqualTo(id);
		List<User> users = userDao.selectByExample(userQuery);
		if (null != users && users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	// 更新用户资料
	@Override
	public User updateByPrimary(String nickname, Integer sex, String pic, HttpServletRequest request) {
		int result = 0;
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (uid != null && uid > 0) {
			User user = userDao.selectById(uid);
			user.setNickname(nickname);
			user.setSex(sex);
			user.setPic(pic);
			result = userDao.updateByPrimaryKeySelective(user);
			if (result > 0) {
				User user2 = userDao.selectById(uid);
				return user2;
			}
		}
		return null;
	}

	// 邮寄地址列表
	@Override
	public List<MailList> selectAllMail(HttpServletRequest request, Integer type) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (uid != null && uid > 0) {
			MailListQuery mailListQuery = new MailListQuery();
			if (type == 1) {
				mailListQuery.setOrderByClause("id desc");
			} else {
				mailListQuery.setOrderByClause("is_default desc");
			}
			com.lwyykj.core.bean.user.MailListQuery.Criteria createCriteria = mailListQuery.createCriteria();
			createCriteria.andUidEqualTo(uid);
			List<MailList> mailLists = mailListDao.selectByExample(mailListQuery);
			return mailLists;
		} else {
			return null;
		}

	}

	// 更新或保存
	@Override
	public int saveOrUpdateMail(MailList mailList, HttpServletRequest request) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int result = 0;
		if (uid != null && uid > 0) {
			if (mailList.getId() != null && mailList.getId() > 0) {
				// System.out.println("----");
				int c = mailListDao.updateByPrimaryKeySelective(mailList);
				// 更新成功
				if (c > 0) {
					result = 999;
				}
			} else {
				int a = mailListDao.countByUid(uid);
				if (a >= 6) {
					// 超过最大限制6条不允许录入
					result = 1001;
				} else {
					mailList.setUid(uid);
					mailList.setAddtime((int)(new Date().getTime()/1000));
					// 插入成功
					int b = mailListDao.insertSelective(mailList);
					if (b > 0) {
						result = 1000;
					}
				}
			}
			return result;
		} else {
			// 1005 uid为空
			result = 1005;
			return result;
		}

	}

	// 设置默认收货地址 2018.5.5
	@Override
	public int setDefault(Integer mailId, HttpServletRequest request) {
		Integer result = 0;
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			// 清空该用户所有默认地址状态
			int a = mailListDao.upDefaultByUid(uid);
			if (a > 0) {
				int b = mailListDao.upDefaultById(mailId);
				if (b > 0) {
					// 更新成功
					result = 10000;
				} else {
					// 设置默认状态失败
					result = 10003;
				}
			} else {
				// 清除default更新失败
				result = 10002;
			}
		} else {
			// 10001用户id为空
			result = 10001;
		}
		return result;
	}

	// 提交密码修改
	@Override
	public UserUtil czPwd(String tel, String pwd, String pwd1, String code, String token) {
		int now = (int) (new Date().getTime() / 1000);
		UserUtil userUtil = new UserUtil();
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
										if (null == user1 && "".equals(user1)) {
											userUtil.setMsg("<img src='../images/stop.png'/>" + "手机号不存在，请查验后重新修改!");
											// 10008用户不存在
											userUtil.setStatus(10008);
										} else {
											user1.setPwd(EncodePassword.encodePassword(pwd));
											int result = userDao.updateByPrimaryKeySelective(user1);
											if (result > 0) {
												// 清除验证码记录
												vercodeDao.deleteByPrimaryKey(vercode.getId());
												userUtil.setStatus(10000);
												userUtil.setMsg("修改成功!");
											} else {
												userUtil.setMsg("<img src='../images/stop.png'/>" + "修改失败，请重试!");
												// 10007注册失败
												userUtil.setStatus(10007);
											}
										}
									} else {
										userUtil.setMsg("<img src='../images/stop.png'/>" + "验证码超时失效,请重新获取!");
										// 10010验证码超时失效
										userUtil.setStatus(10010);
									}

								} else {
									userUtil.setMsg("<img src='../images/stop.png'/>" + "验证码错误!");
									// 10005无验证码记录
									userUtil.setStatus(10005);
								}
							} else {
								userUtil.setMsg("<img src='../images/stop.png'/>" + "验证失败!");
								// 10004无验证码记录
								userUtil.setStatus(10004);
							}
						} else {
							userUtil.setMsg("<img src='../images/stop.png'/>" + "请点击验证码按钮获取验证码!");
							// 10003无验证码记录
							userUtil.setStatus(10003);
						}
					} else {
						userUtil.setMsg("<img src='../images/stop.png'/>" + "两次输入的密码不一致!");
						// 10006无验证码记录
						userUtil.setStatus(10006);
					}

				} else {
					userUtil.setMsg("<img src='../images/stop.png'/>" + "验证码不能为空!");
					// 编码10002验证码为空
					userUtil.setStatus(10002);
				}
			} else {
				userUtil.setMsg("<img src='../images/stop.png'/>" + "验证令牌失败，请重试!");
				// 编码10001密令为空
				userUtil.setStatus(10001);
			}
		} else {
			userUtil.setMsg("<img src='../images/stop.png'/>" + "手机号或密码不能为空!");
			// 编码10001手机号为空
			userUtil.setStatus(10003);
		}

		return userUtil;
	}

	// 根据邮件主键查询收货地址数据
	@Override
	public MailList selectByMailId(Integer mailId) {
		return mailListDao.selectByPrimaryKey(mailId);
	}

	// 删除收货地址
	@Override
	public int delMailAddr(Integer mid) {
		return mailListDao.deleteByPrimaryKey(mid);
	}
	//根据信息ID删除
	@Override
	public int delMsgById(Integer msgId) {
		return msgDao.deleteByPrimaryKey(msgId);
	}
	//修改密码
	@Override
	public int upByUid(Integer uid,String pwd) {
		User user = userDao.selectByPrimaryKey(uid);
		user.setPwd(EncodePassword.encodePassword(pwd));
		return userDao.updateByPrimaryKeySelective(user);
	}
	//查询完整用户信息
	@Override
	public User selectByUid(Integer uid) {
		return userDao.selectByPrimaryKey(uid);
	}

}
