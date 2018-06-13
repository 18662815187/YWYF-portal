package com.lwyykj.core.bean.product;

import java.util.List;

/**
 * 
 * @author yl 订单确认临时返回对象
 *
 */
public class OrderVerfiy {
	private Integer phId;

	private List<Sku> skus;

	private String phName;
	
	private double mailFee;
	
	private String msg;
	
	private Boolean isHave;
	
	
	public Boolean getIsHave() {
		return isHave;
	}

	public void setIsHave(Boolean isHave) {
		this.isHave = isHave;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public double getMailFee() {
		return mailFee;
	}

	public void setMailFee(double mailFee) {
		this.mailFee = mailFee;
	}

	public Integer getPhId() {
		return phId;
	}

	public void setPhId(Integer phId) {
		this.phId = phId;
	}

	public List<Sku> getSkus() {
		return skus;
	}

	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}

	public String getPhName() {
		return phName;
	}

	public void setPhName(String phName) {
		this.phName = phName;
	}

}
