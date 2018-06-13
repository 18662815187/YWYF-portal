package com.lwyykj.core.bean.utils;

/**
 * 临时短信返回值对象
 * 
 * @author yl 2018.4.23
 *
 */
public class SmsUtils {
	// 结果编码
	private int result;
	// 短信接口返回的code
	private Object res_code;
	// 提示信息
	private String msg;
	//token
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Object getRes_code() {
		return res_code;
	}

	public void setRes_code(Object res_code) {
		this.res_code = res_code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
