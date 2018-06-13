package com.lwyykj.core.user.service;

import com.lwyykj.core.dao.user.UserLoginInfo;

public interface RegisterService {
	UserLoginInfo apply(String returnUrl,String tel,String pwd,String pwd1, String code, String token,Integer addType);
}
