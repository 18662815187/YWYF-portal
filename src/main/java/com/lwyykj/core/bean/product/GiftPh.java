package com.lwyykj.core.bean.product;

import java.io.Serializable;

public class GiftPh implements Serializable {
    /**
     * 药房名称
     */
    private String pharmacyName;

    private String spec;

    private Integer id;

    private String pic;

    private String giftName;

    /**
     * 原价
     */
    private Double pirce;

    private Integer addtime;

    private Boolean isDel;

    /**
     * 图集
     */
    private String imgs;

    /**
     * 生成厂家
     */
    private String facName;

    /**
     * 医院名
     */
    private String hosName;

    private static final long serialVersionUID = 1L;

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName == null ? null : pharmacyName.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName == null ? null : giftName.trim();
    }

    public Double getPirce() {
        return pirce;
    }

    public void setPirce(Double pirce) {
        this.pirce = pirce;
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

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName == null ? null : facName.trim();
    }

    public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName == null ? null : hosName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pharmacyName=").append(pharmacyName);
        sb.append(", spec=").append(spec);
        sb.append(", id=").append(id);
        sb.append(", pic=").append(pic);
        sb.append(", giftName=").append(giftName);
        sb.append(", pirce=").append(pirce);
        sb.append(", addtime=").append(addtime);
        sb.append(", isDel=").append(isDel);
        sb.append(", imgs=").append(imgs);
        sb.append(", facName=").append(facName);
        sb.append(", hosName=").append(hosName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}