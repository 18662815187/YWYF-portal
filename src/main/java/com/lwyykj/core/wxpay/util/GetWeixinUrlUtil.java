package com.lwyykj.core.wxpay.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;

public class GetWeixinUrlUtil {
	// 获取二维码url
	public static String weixin_pay(String ip, Integer uid) throws Exception {
		MyConfig config = new MyConfig();
		WXPay wxpay = new WXPay(config);
		// 账号信息
		String appid = PayConfigUtil.APP_ID; // appid
		String mch_id = PayConfigUtil.MCH_ID; // 商户号
		String key = PayConfigUtil.API_KEY; // key
		String currTime = String.valueOf(new Date().getTime() / 1000);
		String strTime = currTime.substring(8, currTime.length());
		String strRandom = 123456 + "";
		String nonce_str = strTime + strRandom;
		int order_price = 1; // 商品价格 注意：价格的单位是分
		String body = "商品名称"; // 商品名称
		String out_trade_no = "156451545322254563223032"; // 商户订单号
		// 获取发起电脑 ip
		String spbill_create_ip = ip;
		// 回调接口
		String notify_url = PayConfigUtil.NOTIFY_URL;
		String trade_type = "NATIVE"; // 交易类型
		//红黑树?太老了!
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

		// Map<String,String> map = WXPayUtil.xmlToMap(resXml);
		String a = WXPayUtil.mapToXml(map);
		System.out.println(a);
		String urlCode = (String) map.get("code_url");
		System.out.println(urlCode);
		return urlCode;
	}

	// 特殊字符处理
	public static String UrlEncode(String src) throws UnsupportedEncodingException {
		return URLEncoder.encode(src, "UTF-8").replace("+", "%20");
	}
}
