package com.lwyykj.core.bean.product;

import java.io.Serializable;

public class FacPro implements Serializable {
    private Integer proId;

    private String facName;

    private String brandName;

    /**
     * 封面图片
     */
    private String pic;

    private String proName;

    /**
     * 图片集
     */
    private String imgs;

    /**
     * 规格，多个规格用逗号隔开
     */
    private String specs;

    private Boolean isDel;

    private Boolean isShow;

    private Boolean isNew;

    private Boolean isHot;

    /**
     * 是否推荐
     */
    private Boolean isCommend;

    private Integer createTime;

    /**
     * 点击次数
     */
    private Integer clickNum;

    /**
     * 星级
     */
    private Double grade;

    /**
     * 药房名称
     */
    private String phName;

    /**
     * 医院名
     */
    private String hosName;
    
    /**
     * 人体系统ID
     */
    private Integer funId;

    /**
     * 归属店铺ID
     */
    private Integer phId;

    /**
     * 病症ID
     */
    private Integer diseaseId;

    /**
     * 产品类型ID
     */
    private Integer proTypeid;

    
    /**
     * 产品批号
     */
    private String batchNum;

    /**
     * 剂型
     */
    private String dosage;
    
    /**
     * 运费
     */
    private Double freigth;
    
    /**
     * 受否处方，0否1是
     */
    private Boolean isCounter;


    private static final long serialVersionUID = 1L;
    
    
    
    public Boolean getIsCounter() {
		return isCounter;
	}

	public void setIsCounter(Boolean isCounter) {
		this.isCounter = isCounter;
	}

	public Double getFreigth() {
		return freigth;
	}

	public void setFreigth(Double freigth) {
		this.freigth = freigth;
	}

	public Integer getFunId() {
		return funId;
	}

	public void setFunId(Integer funId) {
		this.funId = funId;
	}

	public Integer getPhId() {
		return phId;
	}

	public void setPhId(Integer phId) {
		this.phId = phId;
	}

	public Integer getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}

	public Integer getProTypeid() {
		return proTypeid;
	}

	public void setProTypeid(Integer proTypeid) {
		this.proTypeid = proTypeid;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName == null ? null : facName.trim();
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

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs == null ? null : specs.trim();
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Boolean getIsCommend() {
        return isCommend;
    }

    public void setIsCommend(Boolean isCommend) {
        this.isCommend = isCommend;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getPhName() {
        return phName;
    }

    public void setPhName(String phName) {
        this.phName = phName == null ? null : phName.trim();
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
        sb.append(", proId=").append(proId);
        sb.append(", facName=").append(facName);
        sb.append(", brandName=").append(brandName);
        sb.append(", pic=").append(pic);
        sb.append(", proName=").append(proName);
        sb.append(", imgs=").append(imgs);
        sb.append(", specs=").append(specs);
        sb.append(", isDel=").append(isDel);
        sb.append(", isShow=").append(isShow);
        sb.append(", isNew=").append(isNew);
        sb.append(", isHot=").append(isHot);
        sb.append(", isCommend=").append(isCommend);
        sb.append(", createTime=").append(createTime);
        sb.append(", clickNum=").append(clickNum);
        sb.append(", grade=").append(grade);
        sb.append(", phName=").append(phName);
        sb.append(", hosName=").append(hosName);
        sb.append(", funId=").append(funId);
        sb.append(", phId=").append(phId);
        sb.append(", diseaseId=").append(diseaseId);
        sb.append(", proTypeid=").append(proTypeid);
        sb.append(", batchNum=").append(batchNum);
        sb.append(", dosage=").append(dosage);
        sb.append(", freigth=").append(freigth);
        sb.append(", isCounter=").append(isCounter);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}