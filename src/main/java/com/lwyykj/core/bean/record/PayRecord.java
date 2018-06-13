package com.lwyykj.core.bean.record;

import java.io.Serializable;

public class PayRecord implements Serializable {
    private Integer id;

    /**
     * 金额支持负数
     */
    private Double money;

    /**
     * 第三方支付返回的订单号
     */
    private String transactionId;

    /**
     * 商户内部批次号
     */
    private String outTradeNo;

    /**
     * true/false  进账0，支出1
     */
    private Boolean style;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 是否删除
     */
    private Boolean isDel;

    private Integer addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public Boolean getStyle() {
        return style;
    }

    public void setStyle(Boolean style) {
        this.style = style;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", money=").append(money);
        sb.append(", transactionId=").append(transactionId);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", style=").append(style);
        sb.append(", uid=").append(uid);
        sb.append(", isDel=").append(isDel);
        sb.append(", addtime=").append(addtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}