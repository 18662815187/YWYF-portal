package com.lwyykj.core.login.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lwyykj.core.dao.user.UserLoginInfo;
import com.lwyykj.core.user.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Resource
	private RegisterService registerService;

	// 去注册页
	@RequestMapping("/toRegister")
	public String toRegister(String returnUrl, Model model) {
//		System.out.println(returnUrl + "注册");
		return "other/register";
	}

	// 提交注册
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/apply")
	@ResponseBody
	public Object apply(String returnUrl, String tel, String pwd, String pwd1, String code, String token,
			Integer addType) {
		UserLoginInfo userLoginInfo = registerService.apply(returnUrl, tel, pwd, pwd1, code, token, addType);
		return userLoginInfo;
	}
}
