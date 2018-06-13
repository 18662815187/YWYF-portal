package com.lwyykj.core.bean.type;

import java.io.Serializable;

public class Disease implements Serializable {
    private Integer id;

    /**
     * 病症名称
     */
    private String name;

    /**
     * 对用作用范围ID
     */
    private Integer funcId;

    private Integer addTime;

    private Boolean isDel;
    
    /**
     * 父类名称
     */
    private String par_name;
    private static final long serialVersionUID = 1L;
    
    
    

    public String getPar_name() {
		return par_name;
	}

	public void setPar_name(String par_name) {
		this.par_name = par_name;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", funcId=").append(funcId);
        sb.append(", addTime=").append(addTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}