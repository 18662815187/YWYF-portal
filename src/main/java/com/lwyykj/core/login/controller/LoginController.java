package com.lwyykj.core.login.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lwyykj.common.Constants;
import com.lwyykj.core.bean.user.LoginUtil;
import com.lwyykj.core.user.service.LoginService;
import com.lwyykj.core.user.service.UserService;

/**
 * 
 * @author yl 2018.4.20 登录控制器
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
	private UserService userService;
	@Resource
	private LoginService loginService;

	/**
	 * 
	 * 去登录页，携带returnUrl
	 */
	@RequestMapping("/toLogin")
	public String toLogin(String returnUrl, Model model) {
		// System.out.println(returnUrl);
		model.addAttribute("returnUrl", returnUrl);
		return "/other/login";
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/isLogin.do")
	@ResponseBody
	public Map<String, Object> isLogin(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute(Constants.USER_NAME);
		Integer result = 0;
		Map<String, Object> map = new HashMap<>();
		if (null != username && "" != username) {
			result = 1;
			map.put("us", username);
			map.put("status", result);
		} else {
			map.put("status", result);
		}
		return map;
	}

	// 提交登录POST,使用springmvc的Converter转换器可以大大简化判断空值的操作,转换器工厂在mvc配置文件，工具类在common项目中
	@RequestMapping("/apply")
	@ResponseBody
	public Object login(String tel, String password, String verifyCode, String returnUrl, HttpServletRequest request,
			Model model) {
		LoginUtil loginUtil = loginService.login(request, tel, password, verifyCode, returnUrl);
		return loginUtil;

	}

	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
