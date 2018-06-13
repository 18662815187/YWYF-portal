package com.lwyykj.core.pay.service;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.lwyykj.core.bean.shop.PayUtil;

public interface AlipayService {
	//调起支付
	void pcPagePay(HttpServletRequest req,HttpServletResponse res,String oids)throws UnsupportedEncodingException;
	
	//returnUrl
	PayUtil returnUrl(HttpServletRequest request,HttpServletResponse response)throws UnsupportedEncodingException, AlipayApiException;
	
	//查询支付状态
	PayUtil queryPay(HttpServletRequest request,HttpServletResponse response,String out_trade_no,String trade_no)throws AlipayApiException;
	
	//异步回调服务
	PayUtil notify(HttpServletRequest request)throws UnsupportedEncodingException, AlipayApiException, ParseException;

}
