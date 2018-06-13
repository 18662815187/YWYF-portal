package com.lwyykj.core.bean.shop;

import java.io.Serializable;

public class ShopCart implements Serializable {
    private Integer id;

    private Integer uid;

    /**
     * 购物车详情
     */
    private String carInfo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo == null ? null : carInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", carInfo=").append(carInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}