package com.lwyykj.core.bean.pca;

import java.io.Serializable;
import java.util.List;

public class Provinces implements Serializable {
    private Integer id;

    private String provinceid;

    private String province;
    
    private List<Cities> cities;

    private static final long serialVersionUID = 1L;
    
    

    public List<Cities> getCities() {
		return cities;
	}

	public void setCities(List<Cities> cities) {
		this.cities = cities;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid == null ? null : provinceid.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", provinceid=").append(provinceid);
        sb.append(", province=").append(province);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}