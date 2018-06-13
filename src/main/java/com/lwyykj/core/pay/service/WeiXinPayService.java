package com.lwyykj.core.pay.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwyykj.core.wxpay.util.WeiXinUtil;

public interface WeiXinPayService {
	//调起支付
	public WeiXinUtil wxPagePay(HttpServletRequest request)throws Exception;
	//回调
	WeiXinUtil wxnotify(HttpServletRequest request,HttpServletResponse response)throws Exception;
	//订单查询
	Boolean quertOrder(String out_trade_no)throws Exception;
}
