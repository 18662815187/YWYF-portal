package com.lwyykj.core.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lwyykj.core.bean.user.MailList;
import com.lwyykj.core.bean.user.User;
import com.lwyykj.core.bean.user.UserUtil;

public interface UserService {
	//根据手机号查询
	User selectByTel(String tel);
	//主键查询
	User selectByPrimary(Integer id);
	//提交更新用户信息
	User updateByPrimary(String nickname,Integer sex,String pic,HttpServletRequest request);
	//收货地址列表
	List<MailList> selectAllMail(HttpServletRequest request,Integer type);
	//收件地址更新和新增
	int saveOrUpdateMail(MailList mailList,HttpServletRequest request);
	//设置默认地址
	int setDefault(Integer mailId,HttpServletRequest request);
	//重置密码提交
	UserUtil czPwd(String tel,String pwd,String pwd1,String code,String token);
	//根据mailID查询
	MailList selectByMailId(Integer mailId);
	//删除收货地址
	int delMailAddr(Integer mid);
	//删除信息
	int delMsgById(Integer msgId);
	//修改密码
	int upByUid(Integer uid,String pwd);
	//查询用户密码
	User selectByUid(Integer uid);
}
