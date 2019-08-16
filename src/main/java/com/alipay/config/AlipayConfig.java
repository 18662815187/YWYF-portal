package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

import com.lwyykj.common.Constants;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "xxxxx";
	//商户PID
	public static String partner="xxxxx";
	// 商户私钥，您的PKCS8格式RSA2私钥
//    public static String merchant_private_key = "MIICdwIBAxxxxxxEwggJdAgEAAoGBAMa6NxxxxTeKzsiDYgEkohdqMRkjEgm2dpbk6T36MYAGwjy8xUJdveMkQGioiobL9/FtJuFHgip3e92PNPoDuvWBzCR8p+9GUONOIjT4YS5dQ4V2DooicICWDoJ6dURnbrDldYQPcL8WeSFoyUVdrLcdwhB1AgMBAAECgYBlIUi6dnZbC9oM7FHPL2/R0R3WNQ5MHggWutS+A61etGkuhitNWMqVXqgoFchs7keYIWpLmBwq5nIwbMYNl1Vr88AVzz4G5HlC4rLISY1MGv/pJ/TIvjBRl9PM01qJ2NFdqFdpAlH4O2Zn1wcHS2wZgMWGeAL6HC3PkxvZP2GOFQJBAOaGU2NtQeteUggeMn0i6MvqvbVhoOjvHWb6drog/f9RgGvrHNzLwPAWF1aEXma5Wfth+lH+D7Vc5eYszef8o0MCQQDcsFPk57KYSPiYhrtiwX3ipdec6NY/0zLFNfRt8BjEN7f9VLye5tsDm7Tja8wh0JkoYiKUIGpbT9neKXg1/NXnAkAWu8J3eKvaiUevs0KpYorwqSqiO4mBzyroH+Ubf+tshV4TxnDnOVTCmHsethkVKkw8ZTIpadOkwA+P/nUj3p8/AkEA1qCiJrfzqEknhGdcLJJTlK6HgDGt1IrZEJUFsDnWTFaIGNdlTgDktaCkDp2S/Lv7iBvQ11CjP0TsdTTNlWvctwJBAJilbOODQXQBDdFFky31mF5f8BDoUnRNEvD0uJrP0CPHX1hoGx/efx6AR02hPJQO0h24L3Lc2KXUFNBimc3B7oo=";
	public static String merchant_private_key="xxxxsxxxxxT46FeKdIob1QbBgARrSVMzsK3macMfyKYEUOCJcoiY/irHMogpWLRCgeY4LkFjXB1/K9QOqAdCOBENQzTWZmEq+jYXW8yEv+v2FA1nDvLw4v4g3C95OI8HzBhGW/i5OX0/iKMQ5wbigjCgLK0bIuhxJTn4dCJjB2at4AI4y48O1PPdOV8jSzk/jZReI1a6vFMt3PvWeLO2eTFoIPrpvyezs5+eXTQzyNHFjmyuEJuHs7n42QXGce1xUl9Qouqmlegc+vjRk5phpCGNghmwn1owBZAgMBAAECggEAPqw6jsTYbzyZUoFCp4v4B6AVOxg3aNy1goZFP9T+NlDUg/0JMpc4kZFb8JSiGQSP0igHJbhM03ss2qLKGqPM3rZd0bWFQiCHhxpNG/VEkbt/5jda2fLsyXzbjVxrPo94sT4mNMrFQPPZJASVuUTPmhz55jz11dKsoanW7RRwEvk07ETcdpvphotAq5Xa19I8nKQTr4upqnpa93VCb35mbAxjSnf6orZHek0k4ZP+IQv62xl2KWjhqmNnUzq+FYQrGtSNHL3GnnaDK/CixK2HJO7ng6BXXPwLIt7crylquczygb+tgOFHJK3CcoG7ciAOADcyylZugDW68K3og+0BIQKBgQD/jOuDKLe+8I8EqqD9+h1lHsll/yekAnBBGtCj0aYEu5X7lQOmp7QtN1YjmvcdSYrtF/iMoR1mKi8K7b7i+hWms2Lrfjt/me+/wFVIIJACubhsYTq4mqv0MFuq/kXZhkNqta8TIQsk9zsf3rrgswMGwUgFB9oP3m3cc8p+L+HgVQKBgQCMSWiGWgnsAJK4xqd12RdDh+NRMrMRVPzK1hwY4ezsnVZF17w3SNBnAg3rbHzYBpaRuzFHjCBGplEUE1b04ue5Gc7MRQt3y6ZaG6T124RwLuzkw3gfszd3c/XAocPbnlrk4KDNAzx68eHhgweFAVnPlE5N+sxdbKfvhpCgkI0T9QKBgGpjrJjKFtUzKRd0Qdn6ispSat4/v60UJs+z7jCFU2yc++/lNcPoBabdZssj9MUInQHf/OXvHWIvJa6TE+lC3EiuXfxUbUjOOXXHCLoidFHuJ81XHS9FlVjv2PnzKflJYD/Iq752/0DAfKjj/UEWxafGR8lwX2RD4dDpk9+853iRAoGAeTquovuH+3P7VsYEzKhPnEH/xJlleSLSWY5xNWd3UHoepbhqo/O+dGWoFbvont4Cm+kCCuwisCrlgc28pV64FJMizA8We+120gN1qCiM6E0E1iO82NgMpKOGyXKBSHYt4f/jtYaIa04/fpu2kc+7BtEIYgbLOCi/bxQAQ2DnKUkCgYB7X19KA6aj0udzsRYqlWVeWjk5hqnmQkmPLdxVUSWfajMqFkPqTXug43vKlDadTnvBXGSb/Aoxo4kkWkDRhNLgXwxXF3k9hv+nIDXqGZnWCGLGhnNotG6OnQtl0c40fQiIDEm0MHgjM1dGuH8RlXm6jiXcpldN9TzMcYmvA71bCw==";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
//    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
    public static String alipay_public_key="MIIBIjANBgkqhkixxxxxxEAuBVyjRJjQ1DHtiFAC6s4YH0xxxxxwTHYkl1cRBj2oje4/+7oRJT9SWfjy5qRSya7sWWKPkvNpkZiB7F7JCyM339Mi/8jseGv0Q1r0WcHHPEKj9y7sELDZ/zUyT/sE56wsv2DT6u/SOKKu0Uu5JySCnywGTU6VuKPyZR7Wn8ejj3MlQI6Lq8mYi0fctjVBbM/azIYe0nTGQoWJsog/Q6gjzXWhdu2mFo/dOGiZgS8zKJm0A69WTdL6pMoKQpRzfqq+5rBNNWiu+lXDGpBxAUSuJZcH13Ifw7s/ZfPCM5ORhCMkrM3Xn3/LAsfx/q5CQIDAQAB";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String notify_url = "http://localhost/notify_url.jsp";
//	public static String notify_url =Constants.DOMAIN1+"/payOrder/notify";
	public static String notify_url =Constants.DOMAIN+"/alipay/notify_url";
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://localhost/return_url.jsp";
//	public static String return_url =Constants.DOMAIN1+ "/payOrder/returnURL";
	public static String return_url =Constants.DOMAIN+"/alipay/returnURL";
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关https://openapi.alipaydev.com/gateway.do
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
//	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	 /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

