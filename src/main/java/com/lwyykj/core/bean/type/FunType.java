package com.lwyykj.core.bean.type;

import java.io.Serializable;
import java.util.List;

public class FunType implements Serializable {
    private Integer id;

    /**
     * 人体系统名称
     */
    private String name;

    /**
     * 对应上级产品类型ID
     */
    private Integer typeId;

    private Integer addTime;

    private Boolean isDel;
    
    /**
     * 商家名字
     */
    private String parName;
    
    /**
     * 临时字段存储下级
     */
    private List<Disease> diseases;

    private static final long serialVersionUID = 1L;
    
    
    public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public String getParName() {
		return parName;
	}

	public void setParName(String parName) {
		this.parName = parName;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
        sb.append(", typeId=").append(typeId);
        sb.append(", addTime=").append(addTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}