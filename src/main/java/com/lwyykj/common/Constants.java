package com.lwyykj.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 业务常量
 * 
 * @author john
 *
 */
public class Constants {
	private static long fileNewName = 0;
	// 公网前台服务器域名
//	 public static final String DOMAIN ="http://www.51ywyf.com";
//	public static final String DOMAIN = "http://127.0.0.1";
	public static final String DOMAIN = "http://localhost";
	public static final String DOMAIN1 = "http://www.51ywyf.com";
	public static final String DOMAIN2 = "http://www.91ywyf.com";
	public static final String DOMAIN3 = "http://www.处方外配.com";
	public static final String DOMAIN4 = "http://www.医院处方药外配平台.com";
	public static final String DOMAIN5 = "http://www.58ywyf.com";
	public static final String DOMAIN6 = "http://www.chufangwaipei.com";
	// 图片服务器
	// public static final String IMG_URL = "http://localhost/ywyf/";
	public static final String IMG_URL = "http://localhost/photo/";
//	 public static final String IMG_URL = "http://www.51ywyf.com/photo/";
	// 用户名
	public static final String USER_NAME = "USER_NAME";
	// 购物车 保存在cookie中的名称
	public static final String BUYER_CART = "BUYER_CART";
	// 登录中转页面
	public static final String LOGIN_URL = "../../sessionrun.jsp";
	// 登录状态码
	public static final String LOGIN_STATUS = "LOGIN_STATUS";
	// 登录时间
	public static final String LOGIN_TIME = "LONGIN_TIME";

	// 图片新名字
	public synchronized static String getNewFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = sdf.format(new Date());
		fileNewName++;
		return now + fileNewName;
	}

	// 订单号orderNum
	public synchronized static String getOrderNum() {
		int machineId = 1;// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return machineId + String.format("%015d", hashCodeV);
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
}
