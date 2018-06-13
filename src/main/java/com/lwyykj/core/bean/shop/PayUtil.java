package com.lwyykj.core.bean.shop;


public class PayUtil {
	private String tradeStatus;
	
	private Integer status;
	
	private String payNum;
	
	private String msg;
	
	private String totalFee;
	
	

	public String getPayNum() {
		return payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	
	
}
