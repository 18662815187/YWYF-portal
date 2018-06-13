package com.lwyykj.core.bean.shop;

import java.io.Serializable;

public class OrderListInfo implements Serializable {
    private Integer oid;

    /**
     * 订单号
     */
    private String orderNum;

    private Integer uid;

    /**
     * 商家ID
     */
    private Integer storeId;

    /**
     * 药房名称
     */
    private String phName;

    /**
     * sku ID
     */
    private Integer skuid;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 单价
     */
    private Double price;

    /**
     * 总价
     */
    private Double totalfee;

    /**
     * 创建时间
     */
    private Integer addtime;

    /**
     * 0未付款，1已付款，2已发货，3已完成，4交易关闭，5待评价
     */
    private Integer status;

    private Boolean isDel;

    private String proName;

    /**
     * 封面图片
     */
    private String pic;

    private static final long serialVersionUID = 1L;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName == null ? null : phName.trim();
    }

    public Integer getSkuid() {
        return skuid;
    }

    public void setSkuid(Integer skuid) {
        this.skuid = skuid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(Double totalfee) {
        this.totalfee = totalfee;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", uid=").append(uid);
        sb.append(", storeId=").append(storeId);
        sb.append(", phName=").append(phName);
        sb.append(", skuid=").append(skuid);
        sb.append(", num=").append(num);
        sb.append(", price=").append(price);
        sb.append(", totalfee=").append(totalfee);
        sb.append(", addtime=").append(addtime);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
        sb.append(", proName=").append(proName);
        sb.append(", pic=").append(pic);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}