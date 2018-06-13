package com.lwyykj.core.bean.order;

import java.io.Serializable;
import java.util.List;

import com.lwyykj.core.bean.user.MailList;

public class Order implements Serializable {
	private Integer id;
	/**
	 * 订单号
	 */
	private String orderNum;

	/**
	 * 支付批次号
	 */
	private String payNum;

	private Integer uid;

	/**
	 * 处方医生ID
	 */
	private Integer docId;

	/**
	 * 商家ID
	 */
	private Integer storeId;

	/**
	 * 收货地址ID
	 */
	private Integer sendId;

	/**
	 * 创建时间
	 */
	private Integer addtime;

	/**
	 * 总价
	 */
	private Double totalfee;

	/**
	 * 支付时间
	 */
	private Integer paytime;

	/**
	 * 支付方式，1支付宝 2微信支付3货到付款
	 */
	private Integer paymentWay;

	/**
	 * 快递单号
	 */
	private String expiressNum;

	private Integer sendtime;

	/**
	 * 0未付款，1已付款，2已发货，3已完成，4交易关闭，5待评价
	 */
	private Integer orderStatus;

	private String note;

	/**
	 * 处方ID
	 */
	private Integer prescriptionId;

	private Integer payRecordId;

	private Boolean isDel;

	private Boolean flag;

	/**
	 * 临时字段店铺名称
	 */
	private String phName;

	/**
	 * 临时字段小单集合
	 */
	private List<OrderProduct> orderProducts;
	
	/**
	 * 临时字段个人中心首页取下标0的orderproduct
	 */
	private OrderProduct orderProduct;
	
	
	/**
	 * 临时字段运费
	 */
	private Double mailFee;
	
	/**
	 * 临时字段用于订单详情，发货地址
	 */
	private MailList mailList;
	
	private static final long serialVersionUID = 1L;

	
	
	public MailList getMailList() {
		return mailList;
	}

	public void setMailList(MailList mailList) {
		this.mailList = mailList;
	}

	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}

	public Double getMailFee() {
		return mailFee;
	}

	public void setMailFee(Double mailFee) {
		this.mailFee = mailFee;
	}

	public String getPhName() {
		return phName;
	}

	public void setPhName(String phName) {
		this.phName = phName;
	}

	

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum == null ? null : orderNum.trim();
	}

	public String getPayNum() {
		return payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum == null ? null : payNum.trim();
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getSendId() {
		return sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	public Integer getAddtime() {
		return addtime;
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}

	public Double getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}

	public Integer getPaytime() {
		return paytime;
	}

	public void setPaytime(Integer paytime) {
		this.paytime = paytime;
	}

	public Integer getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(Integer paymentWay) {
		this.paymentWay = paymentWay;
	}

	public String getExpiressNum() {
		return expiressNum;
	}

	public void setExpiressNum(String expiressNum) {
		this.expiressNum = expiressNum == null ? null : expiressNum.trim();
	}

	public Integer getSendtime() {
		return sendtime;
	}

	public void setSendtime(Integer sendtime) {
		this.sendtime = sendtime;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public Integer getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Integer getPayRecordId() {
		return payRecordId;
	}

	public void setPayRecordId(Integer payRecordId) {
		this.payRecordId = payRecordId;
	}

	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", orderNum=").append(orderNum);
		sb.append(", payNum=").append(payNum);
		sb.append(", uid=").append(uid);
		sb.append(", docId=").append(docId);
		sb.append(", storeId=").append(storeId);
		sb.append(", sendId=").append(sendId);
		sb.append(", addtime=").append(addtime);
		sb.append(", totalfee=").append(totalfee);
		sb.append(", paytime=").append(paytime);
		sb.append(", paymentWay=").append(paymentWay);
		sb.append(", expiressNum=").append(expiressNum);
		sb.append(", sendtime=").append(sendtime);
		sb.append(", orderStatus=").append(orderStatus);
		sb.append(", note=").append(note);
		sb.append(", prescriptionId=").append(prescriptionId);
		sb.append(", payRecordId=").append(payRecordId);
		sb.append(", isDel=").append(isDel);
		sb.append(", flag=").append(flag);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}