package com.lwyykj.core.pay.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.config.AlipayConfig;
import com.lwyykj.common.Constants;
import com.lwyykj.core.bean.order.Order;
import com.lwyykj.core.bean.order.OrderProduct;
import com.lwyykj.core.bean.product.Product;
import com.lwyykj.core.bean.product.Sku;
import com.lwyykj.core.bean.record.PayRecord;
import com.lwyykj.core.bean.shop.PayUtil;
import com.lwyykj.core.dao.order.OrderDao;
import com.lwyykj.core.dao.order.OrderProductDao;
import com.lwyykj.core.dao.product.ProductDao;
import com.lwyykj.core.dao.product.SkuDao;
import com.lwyykj.core.dao.record.PayRecordDao;
import com.lwyykj.core.pay.service.AlipayService;
import com.lwyykj.core.wxpay.util.DateFormat;

/**
 * 
 * @author yl 2018.5.11 支付宝支付服务
 *
 */
@Service("aliPayService")
public class AlipayServiceImpl implements AlipayService {
	@Resource
	private OrderDao orderDao;
	@Resource
	private SkuDao skuDao;
	@Resource
	private ProductDao ProductDao;
	@Resource
	private OrderProductDao orderProductDao;
	@Resource
	private PayRecordDao payRecordDao;

	// 调起PC网页支付
	@Override
	public void pcPagePay(HttpServletRequest req, HttpServletResponse res, String oids)
			throws UnsupportedEncodingException {
		Integer uid = (Integer) req.getSession().getAttribute("uid");
		Double totalFee = 0.00;
		// 支付流水号，前面带uid保证高并发时不会重复
		String payNum = uid + Constants.getOrderNum();
		List<String> orderNums = new ArrayList<>();
		List<String> proNames = new ArrayList<>();
		String[] a = oids.split(",");
		for (int i = 0; i < a.length; i++) {
			Order order = orderDao.selectByPrimaryKey(Integer.valueOf(a[i]));
			order.setPayNum(payNum);
			orderDao.updateByPrimaryKeySelective(order);
			totalFee = totalFee + order.getTotalfee();
			List<OrderProduct> orderProducts = orderProductDao.selectByOid(Integer.valueOf(a[i]));
			for (OrderProduct orderProduct : orderProducts) {
				Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
				proNames.add(ProductDao.findByPrimary(sku.getProId()).getName());
			}
			orderNums.add(order.getOrderNum());
		}
		String totalAmountX = String.valueOf(totalFee);
		String ordersX = StringUtils.join(orderNums.toArray(), ",");
		String disProName = StringUtils.join(proNames.toArray(), ",");
		// 实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
		AlipayTradePagePayModel model = new AlipayTradePagePayModel();
		ExtendParams extendParams = new ExtendParams();
		extendParams.setSysServiceProviderId(AlipayConfig.partner);
		model.setOutTradeNo(payNum);
		model.setProductCode("FAST_INSTANT_TRADE_PAY");
		model.setTotalAmount(totalAmountX);
		model.setSubject("处方外配订单号：" + ordersX);
		model.setBody(disProName);
		model.setPassbackParams(new String(URLEncoder.encode(oids, "GBK")));
		model.setExtendParams(extendParams);
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)
		request.setBizModel(model);
		request.setReturnUrl(AlipayConfig.return_url);
		request.setNotifyUrl(AlipayConfig.notify_url);
		String form = "";
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
			res.setContentType("text/html;charset=" + AlipayConfig.charset);
			res.getWriter().write(form);// 直接将完整的表单html输出到页面
			res.getWriter().flush();
			res.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// returnUrl
	@Override
	public PayUtil returnUrl(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, AlipayApiException {
		PayUtil payUtil1 = new PayUtil();
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		System.out.println(params);
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名
		System.out.println(signVerified);
		// ——请在这里编写您的程序（以下代码仅作参考）——
		if (signVerified) {
			// 商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
			// 原样回传参数
			// String passback_params = new
			// String(request.getParameter("passback_params").getBytes("ISO-8859-1"),
			// "UTF-8");
			// String[] oids = passback_params.split(",");
			System.out.println(
					"trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);
			PayUtil payUtil = this.queryPay(request, response, out_trade_no, trade_no);
			if (payUtil.getStatus() == 1) {
				switch (payUtil.getTradeStatus()) {
				case "TRADE_SUCCESS":
					// for (String id : oids) {
					// orderDao.modifyOrder(Integer.valueOf(id), 1);
					// }
					payUtil1.setPayNum(out_trade_no);
					payUtil1.setTotalFee(total_amount);
					payUtil1.setStatus(1);
					System.out.println("同步回调跳转成功");
					break;
				case "TRADE_FINISHED":
					payUtil1.setPayNum(out_trade_no);
					payUtil1.setTotalFee(total_amount);
					payUtil1.setStatus(2);
					break;
				case "WAIT_BUYER_PAY":
					payUtil1.setPayNum(out_trade_no);
					payUtil1.setTotalFee(total_amount);
					payUtil1.setStatus(3);
					break;
				case "TRADE_CLOSED":
					payUtil1.setPayNum(out_trade_no);
					payUtil1.setTotalFee(total_amount);
					payUtil1.setStatus(4);
					break;
				default:
					break;
				}

			} else {
				System.out.println("调取查询失败");
			}

		} else {
			System.out.println("验签失败");

		}
		return payUtil1;
	}

	// 查询交易状态
	@Override
	public PayUtil queryPay(HttpServletRequest request, HttpServletResponse response, String out_trade_no,
			String trade_no) throws AlipayApiException {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		AlipayTradeQueryRequest arequest = new AlipayTradeQueryRequest();
		AlipayTradeQueryModel model = new AlipayTradeQueryModel();
		PayUtil payUtil = new PayUtil();
		// ExtendParams params = new ExtendParams();
		model.setOutTradeNo(out_trade_no);
		model.setTradeNo(trade_no);
		arequest.setBizModel(model);
		// arequest.setBizContent("{" +
		// "\"out_trade_no\":\"20150320010101001\"," +
		// "\"trade_no\":\"2014112611001004680 073956707\"" +
		// " }");
		AlipayTradeQueryResponse aresponse = alipayClient.execute(arequest);
		if (aresponse.isSuccess()) {
			payUtil.setTradeStatus(aresponse.getTradeStatus());
			payUtil.setStatus(1);
			System.out.println("调用成功");
		} else {
			payUtil.setStatus(-1);
			System.out.println("调用失败");
		}
		return payUtil;
	}

	// 异步回调
	@Override
	public PayUtil notify(HttpServletRequest request)
			throws UnsupportedEncodingException, AlipayApiException, ParseException {
		PayUtil payUtil = new PayUtil();
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		System.out.println(params);
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名
		if (signVerified) {// 验证成功
			// 商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 原样回传参数
			@SuppressWarnings("unused")
			String passback_params = new String(request.getParameter("passback_params").getBytes("ISO-8859-1"),
					"UTF-8");
			// 付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

			// 交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
			// 交易时间
			int gmt_create = DateFormat.formatDateToInt(new String(request.getParameter("gmt_create").getBytes("ISO-8859-1"), "UTF-8"));
			
			// boolean flg = false;
			System.out.println(gmt_create);
			if (trade_status.equals("TRADE_FINISHED")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序
				List<Order> orders = orderDao.selectByPayNum(out_trade_no);
				List<PayRecord> payRecords = payRecordDao.selectByTradeNo(trade_no);
				PayRecord payRecord = new PayRecord();

				payRecord.setIsDel(false);
				payRecord.setMoney(Double.valueOf(total_amount));
				payRecord.setOutTradeNo(out_trade_no);
				payRecord.setStyle(false);
				payRecord.setTransactionId(trade_no);
				if (null != orders && orders.size() > 0) {
					// 这里销量更新
					for (Order order : orders) {
						List<OrderProduct> orderProducts = orderProductDao.selectByOid(order.getId());
						if (null != orderProducts && orderProducts.size() > 0) {
							for (OrderProduct orderProduct : orderProducts) {
								Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
								Product product = ProductDao.selectByPrimaryKey(sku.getProId());
								product.setSales(product.getSales() + orderProduct.getNum());
								ProductDao.updateByPrimaryKeySelective(product);
							}
						}
						if (order.getOrderStatus() != 3) {
							order.setOrderStatus(3);
							order.setPaymentWay(1);
							order.setPaytime(gmt_create);
							int b = orderDao.updateByPrimaryKeySelective(order);
							if (b > 0) {
								payUtil.setStatus(3);
							} else {
								// 订单完成状态更新失败
								payUtil.setStatus(4);
							}
						}
					}
					payRecord.setUid(orders.get(0).getUid());
					System.out.println("订单结束，业务逻辑完成");
				} else {
					System.out.println("订单结束但是订单查询失败");
				}
				if (null != payRecords && payRecords.size() > 0) {
					System.out.println("支付记录已经存在！");
				} else {
					int a = payRecordDao.insertSelective(payRecord);
					if (a > 0) {
						System.out.println("支付记录生成成功!");
					} else {
						System.out.println("支付记录生成失败");
					}
				}
				// 注意：
				// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序
				List<Order> orders = orderDao.selectByPayNum(out_trade_no);
				List<PayRecord> payRecords = payRecordDao.selectByTradeNo(trade_no);
				PayRecord payRecord = new PayRecord();
				payRecord.setIsDel(false);
				payRecord.setMoney(Double.valueOf(total_amount));
				payRecord.setOutTradeNo(out_trade_no);
				payRecord.setStyle(false);
				payRecord.setTransactionId(trade_no);
				payRecord.setAddtime(gmt_create);
				if (null != orders && orders.size() > 0) {
					for (Order order : orders) {
						// 销量更新
						List<OrderProduct> orderProducts = orderProductDao.selectByOid(order.getId());
						if (null != orderProducts && orderProducts.size() > 0) {
							for (OrderProduct orderProduct : orderProducts) {
								Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
								Product product = ProductDao.selectByPrimaryKey(sku.getProId());
								product.setSales(product.getSales() + orderProduct.getNum());
								ProductDao.updateByPrimaryKeySelective(product);
							}
						}
						if (order.getOrderStatus() == 0) {
							order.setOrderStatus(1);
							order.setPaymentWay(1);
							order.setAddtime(gmt_create);
							int a = orderDao.updateByPrimaryKeySelective(order);
							if (a > 0) {
								payUtil.setStatus(1);
							} else {
								// 订单状态修改异常
								payUtil.setStatus(2);
							}
						}
					}
					payRecord.setUid(orders.get(0).getUid());
					System.out.println("订单支付成功,还能退款");
				} else {
					System.out.println("订单支付成功但是订单查询失败");
				}
				if (null != payRecords && payRecords.size() > 0) {
					System.out.println("支付记录已经存在！");
				} else {
					int a = payRecordDao.insertSelective(payRecord);
					if (a > 0) {
						System.out.println("支付记录生成成功!");
					} else {
						System.out.println("支付记录生成失败");
					}
				}
				// 注意：
				// 付款完成后，支付宝系统发送该交易状态通知
			}
			System.out.println("success" + "回调成功");

		} else {// 验证失败
			System.out.println("fail"+"回调验签失败");
			payUtil.setStatus(-1);
			// 调试用，写文本函数记录程序运行情况是否正常
			// String sWord = AlipaySignature.getSignCheckContentV1(params);
			// AlipayConfig.logResult(sWord);

		}

		return payUtil;
	}

}
