package com.lwyykj.core.bean.type;

import java.io.Serializable;
import java.util.List;

public class ProType implements Serializable {
    private Integer id;

    /**
     * 类型名称
     */
    private String typeName;

    private Integer addTime;

    /**
     * 父级ID
     */
    private Integer parentId;

    private Boolean isDel;
    /**
     * 分类图片
     */
    private String typeLogo;
    /**
     * 父级名字
     */
    private String pTypeName;
    /**
     * 临时字段二级分类，取三个
     */
    private List<FunType> funTypes;
    
    private static final long serialVersionUID = 1L;
    
    
    public String getTypeLogo() {
		return typeLogo;
	}

	public void setTypeLogo(String typeLogo) {
		this.typeLogo = typeLogo;
	}

	public List<FunType> getFunTypes() {
		return funTypes;
	}

	public void setFunTypes(List<FunType> funTypes) {
		this.funTypes = funTypes;
	}

	public String getpTypeName() {
		return pTypeName;
	}

	public void setpTypeName(String pTypeName) {
		this.pTypeName = pTypeName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
        sb.append(", typeName=").append(typeName);
        sb.append(", addTime=").append(addTime);
        sb.append(", parentId=").append(parentId);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}