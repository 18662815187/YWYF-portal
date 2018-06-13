package com.lwyykj.core.bean.doctor;

import java.io.Serializable;
import java.math.BigDecimal;

public class Hospital implements Serializable {
    private Integer id;

    /**
     * 医院名
     */
    private String hosName;

    /**
     * 头像
     */
    private String pic;

    private String tel;

    private String pwd;

    /**
     * GPS坐标X轴
     */
    private BigDecimal locationX;

    /**
     * GPS坐标Y轴
     */
    private BigDecimal locationY;

    /**
     * 介绍
     */
    private String content;

    /**
     * 余额
     */
    private Double money;

    /**
     * 图集
     */
    private String imgs;

    /**
     * 是否审核通过
     */
    private Boolean isShow;

    /**
     * 医院二维码
     */
    private String qrcode;

    /**
     * 省份编码
     */
    private String provincesId;

    /**
     * 城市编码
     */
    private String cityId;

    /**
     * 行政区域ID
     */
    private String area;

    /**
     * 认证相关图片用逗号隔开
     */
    private String authImg;

    /**
     * 是否删除
     */
    private Boolean isDel;

    /**
     * 添加时间
     */
    private Integer addtime;

    /**
     * 注册方式 0后台录入 1PC注册 2微网站注册
     */
    private Integer regType;

    /**
     * 地址
     */
    private String address;

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
   	
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName == null ? null : hosName.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
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

    public BigDecimal getLocationX() {
        return locationX;
    }

    public void setLocationX(BigDecimal locationX) {
        this.locationX = locationX;
    }

    public BigDecimal getLocationY() {
        return locationY;
    }

    public void setLocationY(BigDecimal locationY) {
        this.locationY = locationY;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
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

    public Integer getRegType() {
        return regType;
    }

    public void setRegType(Integer regType) {
        this.regType = regType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hosName=").append(hosName);
        sb.append(", pic=").append(pic);
        sb.append(", tel=").append(tel);
        sb.append(", pwd=").append(pwd);
        sb.append(", locationX=").append(locationX);
        sb.append(", locationY=").append(locationY);
        sb.append(", content=").append(content);
        sb.append(", money=").append(money);
        sb.append(", imgs=").append(imgs);
        sb.append(", isShow=").append(isShow);
        sb.append(", qrcode=").append(qrcode);
        sb.append(", provincesId=").append(provincesId);
        sb.append(", cityId=").append(cityId);
        sb.append(", area=").append(area);
        sb.append(", authImg=").append(authImg);
        sb.append(", isDel=").append(isDel);
        sb.append(", addtime=").append(addtime);
        sb.append(", regType=").append(regType);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}