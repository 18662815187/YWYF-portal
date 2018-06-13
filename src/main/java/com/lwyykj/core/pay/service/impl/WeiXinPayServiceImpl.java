package com.lwyykj.core.pay.service.impl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.lwyykj.common.Constants;
import com.lwyykj.common.GetRealIp;
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
import com.lwyykj.core.pay.service.WeiXinPayService;
import com.lwyykj.core.wxpay.util.DateFormat;
import com.lwyykj.core.wxpay.util.MyConfig;
import com.lwyykj.core.wxpay.util.PayConfigUtil;
import com.lwyykj.core.wxpay.util.WeiXinUtil;

@Service("/wxPayService")
@Transactional
public class WeiXinPayServiceImpl implements WeiXinPayService {
	@Resource
	private OrderDao orderDao;
	@Resource
	private SkuDao skuDao;
	@Resource
	private OrderProductDao orderProductDao;
	@Resource
	private ProductDao productDao;
	@Resource
	private PayRecordDao payRecordDao;

	// 扫码支付获取二维码链接
	@Override
	public WeiXinUtil wxPagePay(HttpServletRequest request) throws Exception {
		WeiXinUtil weiXinUtil = new WeiXinUtil();
		String ipAdrress = GetRealIp.getIpAdrress(request);
		System.out.println(ipAdrress);
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		String oids = (String) session.getAttribute("oids");
		List<String> orderNums = new ArrayList<>();
		List<String> proNames = new ArrayList<>();
		Double totalFee = 0d;
		String out_trade_no = uid + Constants.getOrderNum();
		String[] a = oids.split(",");
		for (int i = 0; i < a.length; i++) {
			Order order = orderDao.selectByPrimaryKey(Integer.valueOf(a[i]));
			order.setPayNum(out_trade_no);
			orderDao.updateByPrimaryKeySelective(order);
			totalFee = totalFee + order.getTotalfee();
			List<OrderProduct> orderProducts = orderProductDao.selectByOid(Integer.valueOf(a[i]));
			for (OrderProduct orderProduct : orderProducts) {
				Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
				proNames.add(productDao.findByPrimary(sku.getProId()).getName());
			}
			orderNums.add(order.getOrderNum());
		}
		// String totalAmountX = String.valueOf(totalFee);
		String ordersX = StringUtils.join(orderNums.toArray(), ",");
		String disProName = StringUtils.join(proNames.toArray(), ",");
		MyConfig config = new MyConfig();
		WXPay wxpay = new WXPay(config);
		// 账号信息
		String appid = PayConfigUtil.APP_ID; // appid
		String mch_id = PayConfigUtil.MCH_ID; // 商户号
		String key = PayConfigUtil.API_KEY; // key
		String currTime = String.valueOf(new Date().getTime() / 1000);
		String strTime = currTime.substring(8, currTime.length());
		String strRandom = Constants.buildRandom(4) + "";
		String nonce_str = strTime + strRandom;
		int order_price = (int) (totalFee * 100); // 商品价格 注意：价格的单位是分
		String body = "处方外配订单：" + disProName; // 商品名称
		// 商户订单号
		// 获取发起电脑 ip
		String spbill_create_ip = ipAdrress;
		// 回调接口
		String notify_url = PayConfigUtil.NOTIFY_URL;
		String trade_type = "NATIVE"; // 交易类型
		// 红黑树?太老了!
		// SortedMap<Object,Object> packageParams = new
		// TreeMap<Object,Object>();
		Map<String, String> data = new HashMap<String, String>();
		data.put("appid", appid);
		data.put("mch_id", mch_id);
		data.put("nonce_str", nonce_str);
		data.put("body", body);
		data.put("out_trade_no", out_trade_no);
		data.put("total_fee", String.valueOf(order_price));
		data.put("spbill_create_ip", spbill_create_ip);
		data.put("notify_url", notify_url);
		data.put("trade_type", trade_type);
		// 生成签名
		// String sign = PayCommonUtil.createSign("UTF-8", packageParams,key);
		String sign = WXPayUtil.generateSignedXml(data, key);
		data.put("sign", sign);

		// String requestXML = PayCommonUtil.getRequestXml(packageParams);
		String requestXML = WXPayUtil.mapToXml(data);
		System.out.println(requestXML);

		// String resXml = HttpUtil.postData(PayConfigUtil.UFDODER_URL,
		// requestXML);
		Map<String, String> map = wxpay.unifiedOrder(data);
		weiXinUtil.setMap(map);
		weiXinUtil.setOrderNums(ordersX);
		weiXinUtil.setTotalFee(totalFee);
		weiXinUtil.setPayNum(out_trade_no);
		// Map<String,String> map = WXPayUtil.xmlToMap(resXml);
		String XX = WXPayUtil.mapToXml(map);
		System.out.println(XX);
		String urlCode = (String) map.get("code_url");
		System.out.println(urlCode);
		return weiXinUtil;
	}
	//回调
	@Override
	public WeiXinUtil wxnotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		WeiXinUtil weiXinUtil = new WeiXinUtil();
		PayUtil payUtil = new PayUtil();
		MyConfig config = new MyConfig();
		WXPay wxpay = new WXPay(config);
		Logger logger = Logger.getLogger("wxLog");
		System.out.println("调用回调方法");
		// 读取参数
		InputStream inputStream;
		StringBuffer sb = new StringBuffer();
		inputStream = request.getInputStream();
		String s;
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		while ((s = in.readLine()) != null) {
			sb.append(s);
		}
		in.close();
		inputStream.close();

		// 解析xml成map
		Map<String, String> m = new HashMap<String, String>();
		m = WXPayUtil.xmlToMap(sb.toString());

		// 过滤空 设置 TreeMap
		// SortedMap<Object,Object> packageParams = new
		// TreeMap<Object,Object>();
		Map<String, String> packageParams = new HashMap<>();
		Iterator<String> it = m.keySet().iterator();
		while (it.hasNext()) {
			String parameter = (String) it.next();
			String parameterValue = m.get(parameter);

			String v = "";
			if (null != parameterValue) {
				v = parameterValue.trim();
			}
			packageParams.put(parameter, v);
		}

		// 账号信息
//		String key = PayConfigUtil.API_KEY; // key

		logger.info(packageParams.toString());
		// 判断签名是否正确
		if (wxpay.isPayResultNotifySignatureValid(packageParams)) {
			// ------------------------------
			// 处理业务开始
			// ------------------------------
			String resXml = "";
			if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
				// 这里是支付成功
				////////// 执行自己的业务逻辑////////////////
//				String mch_id = (String) packageParams.get("mch_id");
//				String openid = (String) packageParams.get("openid");
//				String is_subscribe = (String) packageParams.get("is_subscribe");
				String out_trade_no = (String) packageParams.get("out_trade_no");
				String total_fee = (String) packageParams.get("total_fee");
//				String cash_fee_s = (String) packageParams.get("cash_fee");
//				String cash_fee = String.valueOf(Integer.parseInt(cash_fee_s) / 100);
				// String time_end = MctsUtils.numberDateToDate((String)
				// packageParams.get("time_end"));
				int time_end = DateFormat.formatDateToInt((String) packageParams.get("time_end"));
				String transaction_id = (String) packageParams.get("transaction_id");
				Boolean flag = this.quertOrder(out_trade_no);
				if (flag) {
					List<Order> orders = orderDao.selectByPayNum(out_trade_no);
					List<PayRecord> payRecords = payRecordDao.selectByTradeNo(transaction_id);
					PayRecord payRecord = new PayRecord();
					payRecord.setIsDel(false);
					payRecord.setMoney(Double.valueOf(total_fee)/100);
					payRecord.setOutTradeNo(out_trade_no);
					payRecord.setStyle(false);
					payRecord.setTransactionId(transaction_id);
					payRecord.setAddtime(time_end);
					if (null != orders && orders.size() > 0) {
						// 这里销量更新
						for (Order order : orders) {
							List<OrderProduct> orderProducts = orderProductDao.selectByOid(order.getId());
							if (null != orderProducts && orderProducts.size() > 0) {
								for (OrderProduct orderProduct : orderProducts) {
									Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
									Product product = productDao.selectByPrimaryKey(sku.getProId());
									product.setSales(product.getSales() + orderProduct.getNum());
									productDao.updateByPrimaryKeySelective(product);
								}
							}
							if (order.getOrderStatus() == 0) {
								order.setOrderStatus(1);
								order.setPaymentWay(2);
								order.setPaytime(time_end);
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
					////////// 执行自己的业务逻辑（保存订单信息到数据库）////////////////
					System.out.println("支付成功 ,处理业务成功");
					logger.info("支付成功");
					// 通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
					resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
							+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
					// ------------------------------
					// 处理业务完毕
					// ------------------------------
					// 向微信服务器发送确认信息，若不发送，微信服务器会间隔不同的时间调用回调方法
					BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
					out.write(resXml.getBytes());
					out.flush();
					out.close();
					System.out.println("通知微信.异步确认成功");
					weiXinUtil.setMsg("异步通知成功!");
					weiXinUtil.setStatus(1);
				} else {
					logger.info("支付失败,错误信息：" + packageParams.get("err_code"));
					resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
							+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";

					BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
					out.write(resXml.getBytes());
					out.flush();
					out.close();
					System.out.println("支付查询未查到有效记录");
					weiXinUtil.setMsg("支付未查询到有效记录，回调未执行!");
					weiXinUtil.setStatus(2);
				}

			} else {
				logger.info("支付失败,错误信息：" + packageParams.get("err_code"));
				resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
						+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";

				BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
				out.write(resXml.getBytes());
				out.flush();
				out.close();
				System.out.println("执行回调函数失败");
				weiXinUtil.setMsg("支付失败!");
				weiXinUtil.setStatus(3);
			}
		} else {
			logger.info("通知签名验证失败");
			weiXinUtil.setMsg("通知签名验证失败!");
			weiXinUtil.setStatus(4);
		}
		return weiXinUtil;
	}

	// 查询订单
	@Override
	public Boolean quertOrder(String out_trade_no) throws Exception {
		MyConfig config = new MyConfig();
		WXPay wxpay = new WXPay(config);
		Boolean flag = false;
		Map<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", out_trade_no);
		try {
			Map<String, String> resp = wxpay.orderQuery(data);
			System.out.println(resp);
			if ("SUCCESS".equals((String) resp.get("result_code")) && "SUCCESS".equals((String) resp.get("return_code"))
					&& "SUCCESS".equals((String) resp.get("trade_state"))) {
				flag = true;
			} else {
				if (null != (String) resp.get("return_msg") && !"".equals((String) resp.get("return_msg"))) {
					System.out.println((String) resp.get("return_msg"));
				} else {
					System.out.println((String) resp.get("err_code") + (String) resp.get("err_code_des"));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
