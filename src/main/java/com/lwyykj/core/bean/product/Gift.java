package com.lwyykj.core.bean.product;

import java.io.Serializable;

public class Gift implements Serializable {
    private Integer id;

    private String spec;

    private String pic;

    private String giftName;

    /**
     * 原价
     */
    private Double pirce;

    /**
     * 店家ID
     */
    private Integer phId;

    private Integer addtime;

    private String content;

    private Boolean isDel;

    /**
     * 图集
     */
    private String imgs;

    /**
     * 生成厂家
     */
    private String facName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
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

    public Integer getPhId() {
        return phId;
    }

    public void setPhId(Integer phId) {
        this.phId = phId;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", spec=").append(spec);
        sb.append(", pic=").append(pic);
        sb.append(", giftName=").append(giftName);
        sb.append(", pirce=").append(pirce);
        sb.append(", phId=").append(phId);
        sb.append(", addtime=").append(addtime);
        sb.append(", content=").append(content);
        sb.append(", isDel=").append(isDel);
        sb.append(", imgs=").append(imgs);
        sb.append(", facName=").append(facName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}