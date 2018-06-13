package com.lwyykj.core.bean.order;

import java.io.Serializable;

import com.lwyykj.core.bean.product.Sku;

public class OrderProduct implements Serializable {
    private Integer id;

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

    private Integer oid;

    /**
     * 是否线上1是0否
     */
    private Boolean isOnline;

    /**
     * 0正常状态，1申请退款2已退款3拒绝4申请换货5换货完成6拒绝
     */
    private Integer refundStatus;

    /**
     * 退款记录ID
     */
    private Integer refundId;

    /**
     * 换货ID
     */
    private Integer switchId;

    /**
     * 生成时间
     */
    private Integer addtime;

    /**
     * 是否删除
     */
    private Boolean isDel;

    /**
     * 处方ID
     */
    private Integer preId;

    /**
     * 处方医生ID
     */
    private Integer docId;
    
    /**
     * 临时字段sku
     */
    private Sku sku;
    
    /**
     * 临时字段售后记录数量
     */
    private Integer reNum;
    

    private static final long serialVersionUID = 1L;
    
    
    
    

    public Integer getReNum() {
		return reNum;
	}

	public void setReNum(Integer reNum) {
		this.reNum = reNum;
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public Integer getSwitchId() {
        return switchId;
    }

    public void setSwitchId(Integer switchId) {
        this.switchId = switchId;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", skuid=").append(skuid);
        sb.append(", num=").append(num);
        sb.append(", price=").append(price);
        sb.append(", oid=").append(oid);
        sb.append(", isOnline=").append(isOnline);
        sb.append(", refundStatus=").append(refundStatus);
        sb.append(", refundId=").append(refundId);
        sb.append(", switchId=").append(switchId);
        sb.append(", addtime=").append(addtime);
        sb.append(", isDel=").append(isDel);
        sb.append(", preId=").append(preId);
        sb.append(", docId=").append(docId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}