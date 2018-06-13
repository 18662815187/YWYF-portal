package com.lwyykj.core.wxpay.util;

import java.util.Map;

public class WeiXinUtil {
	private Integer status;
	private String msg;
	private Map<String,String> map;
	private String orderNums;
	private Double totalFee;
	private String payNum;
	
	
	
	public String getPayNum() {
		return payNum;
	}
	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	public String getOrderNums() {
		return orderNums;
	}
	public void setOrderNums(String orderNums) {
		this.orderNums = orderNums;
	}
	public Double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
	
}
