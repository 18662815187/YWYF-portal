package com.lwyykj.core.pay.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alipay.api.AlipayApiException;
import com.lwyykj.core.bean.shop.PayUtil;
import com.lwyykj.core.pay.service.AlipayService;

@RequestMapping("/alipay")
@Controller
public class AlipayController {
	@Resource
	private AlipayService alipayService;

	// 电脑网页支付，调起支付
	@RequestMapping("/pagePay")
	public void pagePay(String oids, HttpServletResponse res, HttpServletRequest req) {
		try {
			alipayService.pcPagePay(req, res, oids);
		} catch (UnsupportedEncodingException e) {
			System.out.println("支付调起失败!");
			e.printStackTrace();
		}
	}

	// returnUrl
	@RequestMapping("/returnURL")
	public String returnURL(HttpServletRequest request, HttpServletResponse response,Model model)
			throws UnsupportedEncodingException, AlipayApiException {
		PayUtil payUtil = alipayService.returnUrl(request, response);
		if(null!=payUtil){
			model.addAttribute("payNum",payUtil.getPayNum());
			model.addAttribute("total", payUtil.getTotalFee());
			if (payUtil.getStatus() == 1) {
				return "/other/success";
			} else {
				return "/other/fail";
			}
		}else{
			model.addAttribute("msg", "页面跳转时数据丢失，请查看订单状态!");
			return "/other/fail";
		}
	
		
	}

	// notify_url
	@RequestMapping("/notify_url")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public void notify_url(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, AlipayApiException, IOException, ParseException {
		PrintWriter out = response.getWriter();
		PayUtil payUtil = alipayService.notify(request);
		if (payUtil.getStatus() == -1) {
			out.print("fail");
			// return "fail";
		} else {
			out.print("success");
			// return "success";
		}
		out.flush();
		out.close();
	}

	@RequestMapping("/ttst")
	@ResponseBody
	public void ttst(HttpServletResponse response) throws IOException {
		// String a ="success";
		PrintWriter out = response.getWriter();
		out.print("success");
		out.flush();
		out.close();
		// return a;
	}
	@RequestMapping("/aatest")
	public String aatest(Integer type){
		if (type == 1) {
			return "/other/success";
		} else {
			return "/other/fail";
		}
	}
	

}
