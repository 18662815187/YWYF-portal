package com.lwyykj.core.bean.shop;

import java.util.List;

import com.lwyykj.core.bean.user.MailList;
/**
 * 
 * @author yl 2018.5.10 生成订单返回对象工具类
 *
 */
public class OrderUtil {
	private String msg;
	private String orderNum;
	private Double totalFee;
	private String proName;
	private MailList mailList;
	private Integer status;
	private Integer oid;
	private List<ProShop> proShops;
	private String oids;
	private String ons;
	
	
	public String getOids() {
		return oids;
	}
	public void setOids(String oids) {
		this.oids = oids;
	}
	public String getOns() {
		return ons;
	}
	public void setOns(String ons) {
		this.ons = ons;
	}
	public List<ProShop> getProShops() {
		return proShops;
	}
	public void setProShops(List<ProShop> proShops) {
		this.proShops = proShops;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public MailList getMailList() {
		return mailList;
	}
	public void setMailList(MailList mailList) {
		this.mailList = mailList;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
