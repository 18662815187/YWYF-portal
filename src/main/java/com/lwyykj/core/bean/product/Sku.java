package com.lwyykj.core.bean.product;

import java.io.Serializable;

public class Sku implements Serializable {
    private Integer id;

    private Integer proId;

    /**
     * 规格
     */
    private String spec;

    /**
     * 市场价预留
     */
    private Double marketPrice;

    /**
     * 店家价格
     */
    private Double price;

    /**
     * 运费
     */
    private Double deliveFee;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 购买限制
     */
    private Integer upperLimit;

    /**
     * 进货价
     */
    private Double superPrice;

    /**
     * 是否赠品
     */
    private Boolean isFree;

    private Integer createTime;

    /**
     * 满多少包邮
     */
    private Double mailFree;
    
    /**
     * 临时字段，产品基本信息
     */
    private Product product;
    
    /**
     * 临时字段购买数量
     */
    private Integer num;
    
    /**
     * 临时字段 是否有货
     */
    private Boolean isHave;
    
    private static final long serialVersionUID = 1L;
    
    
    
    public Boolean getIsHave() {
		return isHave;
	}

	public void setIsHave(Boolean isHave) {
		this.isHave = isHave;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDeliveFee() {
        return deliveFee;
    }

    public void setDeliveFee(Double deliveFee) {
        this.deliveFee = deliveFee;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Double getSuperPrice() {
        return superPrice;
    }

    public void setSuperPrice(Double superPrice) {
        this.superPrice = superPrice;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Double getMailFree() {
        return mailFree;
    }

    public void setMailFree(Double mailFree) {
        this.mailFree = mailFree;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", proId=").append(proId);
        sb.append(", spec=").append(spec);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", price=").append(price);
        sb.append(", deliveFee=").append(deliveFee);
        sb.append(", stock=").append(stock);
        sb.append(", upperLimit=").append(upperLimit);
        sb.append(", superPrice=").append(superPrice);
        sb.append(", isFree=").append(isFree);
        sb.append(", createTime=").append(createTime);
        sb.append(", mailFree=").append(mailFree);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}