package com.lwyykj.core.bean.text;

import java.io.Serializable;

public class MailFee implements Serializable {
    private Integer id;

    /**
     * 药房ID
     */
    private Integer phId;

    /**
     * 江浙沪运费
     */
    private Double money;

    private Boolean isUse;

    private Integer addtime;

    /**
     * 运费描述
     */
    private String title;

    /**
     * 满多少包邮
     */
    private Double topUp;

    /**
     * 非江浙沪运费
     */
    private Double money1;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhId() {
        return phId;
    }

    public void setPhId(Integer phId) {
        this.phId = phId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Boolean getIsUse() {
        return isUse;
    }

    public void setIsUse(Boolean isUse) {
        this.isUse = isUse;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getTopUp() {
        return topUp;
    }

    public void setTopUp(Double topUp) {
        this.topUp = topUp;
    }

    public Double getMoney1() {
        return money1;
    }

    public void setMoney1(Double money1) {
        this.money1 = money1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phId=").append(phId);
        sb.append(", money=").append(money);
        sb.append(", isUse=").append(isUse);
        sb.append(", addtime=").append(addtime);
        sb.append(", title=").append(title);
        sb.append(", topUp=").append(topUp);
        sb.append(", money1=").append(money1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}