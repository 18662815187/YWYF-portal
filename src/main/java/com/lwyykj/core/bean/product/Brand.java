package com.lwyykj.core.bean.product;

import java.io.Serializable;

public class Brand implements Serializable {
    private Integer id;

    private String brandName;

    /**
     * 品牌LOGO
     */
    private String pic;

    /**
     * 厂家ID
     */
    private Integer facId;

    private Boolean isShow;

    private Boolean isDel;

    private Integer addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getFacId() {
        return facId;
    }

    public void setFacId(Integer facId) {
        this.facId = facId;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
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
        sb.append(", brandName=").append(brandName);
        sb.append(", pic=").append(pic);
        sb.append(", facId=").append(facId);
        sb.append(", isShow=").append(isShow);
        sb.append(", isDel=").append(isDel);
        sb.append(", addtime=").append(addtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}