package com.lwyykj.core.bean.type;

import java.io.Serializable;

public class ProDisease implements Serializable {
    private Integer id;

    /**
     * 产品ID
     */
    private Integer proId;

    /**
     * 产品类型 中西药、器械
     */
    private Integer proTypeid;

    /**
     * 治疗人体系统ID
     */
    private Integer funId;

    /**
     * 病症ID
     */
    private Integer diseaseId;

    private static final long serialVersionUID = 1L;

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

    public Integer getProTypeid() {
        return proTypeid;
    }

    public void setProTypeid(Integer proTypeid) {
        this.proTypeid = proTypeid;
    }

    public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", proId=").append(proId);
        sb.append(", proTypeid=").append(proTypeid);
        sb.append(", funId=").append(funId);
        sb.append(", diseaseId=").append(diseaseId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}