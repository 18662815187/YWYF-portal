package com.lwyykj.core.bean.shop;

import java.util.List;

public class ProShop {
	private Integer phId;
	private String phName;
	private String msg;
	private Double mailFee;
	private Boolean isHave;
	private List<BuyerItem> buyerItems;

	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Double getMailFee() {
		return mailFee;
	}

	public void setMailFee(Double mailFee) {
		this.mailFee = mailFee;
	}

	public Boolean getIsHave() {
		return isHave;
	}

	public void setIsHave(Boolean isHave) {
		this.isHave = isHave;
	}

	public List<BuyerItem> getBuyerItems() {
		return buyerItems;
	}

	public void setBuyerItems(List<BuyerItem> buyerItems) {
		this.buyerItems = buyerItems;
	}

	public Integer getPhId() {
		return phId;
	}

	public void setPhId(Integer phId) {
		this.phId = phId;
	}

	public String getPhName() {
		return phName;
	}

	public void setPhName(String phName) {
		this.phName = phName;
	}

}
