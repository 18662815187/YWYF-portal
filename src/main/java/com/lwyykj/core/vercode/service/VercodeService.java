package com.lwyykj.core.vercode.service;

import javax.servlet.http.HttpServletRequest;

import com.lwyykj.core.bean.utils.SmsUtils;
import com.lwyykj.core.bean.utils.Vercode;

public interface VercodeService {


	//根据手机号搜索记录
	Vercode selectByTel(String tel,HttpServletRequest request) throws Exception;

	//发送验证码短信
	SmsUtils sendSms(String tel,HttpServletRequest request)throws Exception;
	
	//重置密码短信验证
	SmsUtils czPwd(String tel,HttpServletRequest request) throws Exception;
}
