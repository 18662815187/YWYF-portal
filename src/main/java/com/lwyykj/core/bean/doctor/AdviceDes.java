package com.lwyykj.core.bean.doctor;

import java.io.Serializable;

public class AdviceDes implements Serializable {
    private Integer id;

    /**
     * 医生处方ID
     */
    private Integer adId;

    /**
     * 产品ID
     */
    private Integer pid;

    /**
     * 数量
     */
    private Integer num;

    private Byte isOnlie;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Byte getIsOnlie() {
        return isOnlie;
    }

    public void setIsOnlie(Byte isOnlie) {
        this.isOnlie = isOnlie;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adId=").append(adId);
        sb.append(", pid=").append(pid);
        sb.append(", num=").append(num);
        sb.append(", isOnlie=").append(isOnlie);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}