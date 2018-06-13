package com.lwyykj.core.CenterController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lwyykj.core.bean.utils.SmsUtils;
import com.lwyykj.core.vercode.service.VercodeService;

/**
 * 短信验证码
 * 
 * @author yl
 *
 */
@Controller
public class RandomSmsCode {
	@Resource
	private VercodeService vercodeService;

	// 注册短信验证码
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/sendSms")
	@ResponseBody
	public Object sendSms(String tel, HttpServletRequest request) throws Exception {
		SmsUtils sendSms = vercodeService.sendSms(tel, request);
		return sendSms;
	}

	// 重置密码
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/czPwdSms")
	@ResponseBody
	public Object czPwdSms(String tel, HttpServletRequest request) throws Exception {
		SmsUtils sendSms = vercodeService.czPwd(tel, request);
		return sendSms;
	}
}
