package com.lwyykj.core.pay.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwyykj.core.bean.order.Order;
import com.lwyykj.core.order.service.CartInfoService;
import com.lwyykj.core.order.service.OrderService;
import com.lwyykj.core.pay.service.WeiXinPayService;
import com.lwyykj.core.wxpay.util.GetWeixinUrlUtil;
import com.lwyykj.core.wxpay.util.WeiXinUtil;

@Controller
@RequestMapping("/weixinpay")
public class WeiXinPayController {
	@Resource
	private WeiXinPayService weiXinPayService;
	@Resource
	private OrderService orderService;
	@Resource
	private CartInfoService cartInfoService;

	@RequestMapping("/payWX")
	public String startPay(HttpServletRequest request, Model model) throws Exception {
		WeiXinUtil wxPagePay = weiXinPayService.wxPagePay(request);
		int a = cartInfoService.countCart(request);
		model.addAttribute("a", a);
		Map<String, String> map = wxPagePay.getMap();
		if (map.get("return_code").toString().equals("SUCCESS")
				&& map.get("result_code").toString().equals("SUCCESS")) {
			String urlCode = (String) map.get("code_url");// 微信二维码短链接
			model.addAttribute("urlCode", urlCode);
			model.addAttribute("orders", wxPagePay.getOrderNums());
			model.addAttribute("total", wxPagePay.getTotalFee());
			model.addAttribute("payNum", wxPagePay.getPayNum());
		} else {
			if (null != map.get("err_code_des")) {
				model.addAttribute("msg", map.get("err_code_des"));
			} else {
				model.addAttribute("msg", map.get("return_msg"));
			}
		}
		return "/other/wechat_pay";
	}

	// IP测试
	@RequestMapping("/xsssssss")
	public void sssss() throws Exception {
		GetWeixinUrlUtil.weixin_pay("127.0.0.1", 1);
	}

	// 回调
	@RequestMapping("/notify_url")
	public void notify_url(HttpServletRequest request, HttpServletResponse response) throws Exception {
		WeiXinUtil wxnotify = weiXinPayService.wxnotify(request, response);
		if (wxnotify.getStatus() == 1) {
			System.out.println("回调成功!");
		} else {
			System.out.println("回调失败!");
		}
	}

	// 查询测试
	@RequestMapping("/queryWx")
	public void queryWX() throws Exception {
		weiXinPayService.quertOrder("11000000608785140");
	}

	// 微信跳转支付成功页面或者失败页面
	@RequestMapping("/pagesf")
	public String pageSf(Integer type, String payNum, Model model) {
		Double total = 0d;
		List<Order> selectByPayNum = orderService.selectByPayNum(payNum);
		List<Order> orders = selectByPayNum;
		if (null != orders && orders.size() > 0) {
			for (Order order : orders) {
				total += order.getTotalfee();
			}
			if (type == 1) {
				model.addAttribute("payNum", payNum);
				model.addAttribute("total", total);
				System.out.println("已支付");
				return "/other/success";
			} else {
				model.addAttribute("payNum", payNum);
				model.addAttribute("total", total);
				return "/other/fail";
			}
		} else {
			model.addAttribute("msg", "订单信息获取失败，支付异常，如您已支付请联系客服。");
			return "/other/fail";
		}

	}
}
