package com.lwyykj.core.user.service;

import javax.servlet.http.HttpServletRequest;

import com.lwyykj.core.bean.record.LoginRecord;
import com.lwyykj.core.bean.user.LoginUtil;

public interface LoginService {
	int insertLoginRecord(LoginRecord loginRecord);
	
	LoginUtil login(HttpServletRequest request,String tel,String password,String verifyCode,String returnUrl);
}
