package com.lwyykj.core.bean.pharmacy;

import java.io.Serializable;

public class Pharmacy implements Serializable {
    private Integer id;

    /**
     * 药房名称
     */
    private String pharmacyName;

    /**
     * 固定电话
     */
    private String tel;

    private String pwd;

    /**
     * 手机
     */
    private String cellPhone;

    /**
     * 介绍
     */
    private String content;

    /**
     * 是否审核通过，0未通过，1已通过，2正在审核，3审核被驳回请重新审核
     */
    private Boolean isShow;

    /**
     * 是否删除，0删除，1未删除，在java中对应true/false
     */
    private Boolean isDel;

    /**
     * 头像
     */
    private String pic;

    /**
     * 店内图集
     */
    private String imgs;

    /**
     * 地址
     */
    private String address;

    /**
     * 省份编码
     */
    private String provincesId;

    /**
     * 城市编码
     */
    private String cityId;

    /**
     * 所在区域编号
     */
    private String area;

    /**
     * 认证图片，以逗号隔开
     */
    private String authImg;

    /**
     * 负责人
     */
    private String manager;

    /**
     * 店家二维码
     */
    private String qrCode;

    /**
     * 所属医院ID
     */
    private Integer hosId;

    /**
     * 药房类型，0医院内部，1医院外部合作药房
     */
    private Byte type;

    /**
     * 结算费率
     */
    private Double commission;

    /**
     * 结算周期以天为单位
     */
    private Integer settlement;

    /**
     * 上级药房
     */
    private Integer parentId;

    /**
     * 注册时预留的所属医院名称
     */
    private String hosName;

    /**
     * 余额
     */
    private Double money;

    /**
     * 推荐人ID
     */
    private Integer refereesId;

    /**
     * 添加时间
     */
    private Integer addtime;

    /**
     * 注册方式 0后台录入 1PC注册 2微网站注册
     */
    private Integer regType;

    /**
     * 是否为指定的院外药房
     */
    private Boolean isSpecified;
    /**
     * 所属范围医院名字
     */
    private String hosname;

    private static final long serialVersionUID = 1L;

    /**
   	 * 图集数组
   	 */
   	public String[] getPics() {
   		if (imgs == null || imgs == "") {
   			return null;
   		}
   		return imgs.split(",");
   	}

   	/**
   	 * 认证图片数组
   	 */
   	public String[] getImges() {
   		if (authImg == null || authImg == "") {
   			return null;
   		}
   		return authImg.split(",");
   	}
    
    public String getHosname() {
		return hosname;
	}

	public void setHosname(String hosname) {
		this.hosname = hosname;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName == null ? null : pharmacyName.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getProvincesId() {
        return provincesId;
    }

    public void setProvincesId(String provincesId) {
        this.provincesId = provincesId == null ? null : provincesId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAuthImg() {
        return authImg;
    }

    public void setAuthImg(String authImg) {
        this.authImg = authImg == null ? null : authImg.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    public Integer getHosId() {
        return hosId;
    }

    public void setHosId(Integer hosId) {
        this.hosId = hosId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Integer getSettlement() {
        return settlement;
    }

    public void setSettlement(Integer settlement) {
        this.settlement = settlement;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName == null ? null : hosName.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getRefereesId() {
        return refereesId;
    }

    public void setRefereesId(Integer refereesId) {
        this.refereesId = refereesId;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public Integer getRegType() {
        return regType;
    }

    public void setRegType(Integer regType) {
        this.regType = regType;
    }

    public Boolean getIsSpecified() {
        return isSpecified;
    }

    public void setIsSpecified(Boolean isSpecified) {
        this.isSpecified = isSpecified;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pharmacyName=").append(pharmacyName);
        sb.append(", tel=").append(tel);
        sb.append(", pwd=").append(pwd);
        sb.append(", cellPhone=").append(cellPhone);
        sb.append(", content=").append(content);
        sb.append(", isShow=").append(isShow);
        sb.append(", isDel=").append(isDel);
        sb.append(", pic=").append(pic);
        sb.append(", imgs=").append(imgs);
        sb.append(", address=").append(address);
        sb.append(", provincesId=").append(provincesId);
        sb.append(", cityId=").append(cityId);
        sb.append(", area=").append(area);
        sb.append(", authImg=").append(authImg);
        sb.append(", manager=").append(manager);
        sb.append(", qrCode=").append(qrCode);
        sb.append(", hosId=").append(hosId);
        sb.append(", type=").append(type);
        sb.append(", commission=").append(commission);
        sb.append(", settlement=").append(settlement);
        sb.append(", parentId=").append(parentId);
        sb.append(", hosName=").append(hosName);
        sb.append(", money=").append(money);
        sb.append(", refereesId=").append(refereesId);
        sb.append(", addtime=").append(addtime);
        sb.append(", regType=").append(regType);
        sb.append(", isSpecified=").append(isSpecified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}