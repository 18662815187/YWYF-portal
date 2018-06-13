package com.lwyykj.core.bean.doctor;

import java.io.Serializable;
import java.math.BigDecimal;

public class Doctor implements Serializable {
    private Integer id;

    /**
     * 头像
     */
    private String pic;

    private String name;

    /**
     * 手机号用于登录
     */
    private String tel;

    private String pwd;

    /**
     * 用于认证的医院名字
     */
    private String authhosname;

    /**
     * 认证图片用逗号隔开
     */
    private String authimg;

    /**
     * 用于认证的职称
     */
    private String authdegree;

    /**
     * 医院ID
     */
    private Integer hosId;

    /**
     * 个人地址
     */
    private String address;

    private Integer age;

    private Integer sex;

    /**
     * 职称，0主治医师，1副主任，2主任
     */
    private Integer title;

    /**
     * 其他称号
     */
    private String degree;

    /**
     * 添加方式，0后台录入，1PC网站注册，2微网站注册，3app注册
     */
    private Integer type;

    /**
     * 环信帐号
     */
    private String hxLogin;

    /**
     * 坐标X
     */
    private BigDecimal positionX;

    /**
     * 坐标Y
     */
    private BigDecimal positionY;

    /**
     * 余额
     */
    private Double money;

    /**
     * 上级ID
     */
    private Integer parentId;

    /**
     * 介绍
     */
    private String description;

    /**
     * 注册时间
     */
    private Integer regtime;

    /**
     * 冗余价格1
     */
    private Double price1;

    /**
     * 冗余价格2
     */
    private Double price2;

    /**
     * 冗余价格3
     */
    private Double price3;

    /**
     * 标签逗号隔开
     */
    private String lable;

    private Boolean isDel;

    private Boolean isShow;

    private static final long serialVersionUID = 1L;
    
    
	/**
   	 * 认证图片数组
   	 */
   	public String[] getImges() {
   		if (authimg == null || authimg == "") {
   			return null;
   		}
   		return authimg.split(",");
   	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getAuthhosname() {
        return authhosname;
    }

    public void setAuthhosname(String authhosname) {
        this.authhosname = authhosname == null ? null : authhosname.trim();
    }

    public String getAuthimg() {
        return authimg;
    }

    public void setAuthimg(String authimg) {
        this.authimg = authimg == null ? null : authimg.trim();
    }

    public String getAuthdegree() {
        return authdegree;
    }

    public void setAuthdegree(String authdegree) {
        this.authdegree = authdegree == null ? null : authdegree.trim();
    }

    public Integer getHosId() {
        return hosId;
    }

    public void setHosId(Integer hosId) {
        this.hosId = hosId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHxLogin() {
        return hxLogin;
    }

    public void setHxLogin(String hxLogin) {
        this.hxLogin = hxLogin == null ? null : hxLogin.trim();
    }

    public BigDecimal getPositionX() {
        return positionX;
    }

    public void setPositionX(BigDecimal positionX) {
        this.positionX = positionX;
    }

    public BigDecimal getPositionY() {
        return positionY;
    }

    public void setPositionY(BigDecimal positionY) {
        this.positionY = positionY;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRegtime() {
        return regtime;
    }

    public void setRegtime(Integer regtime) {
        this.regtime = regtime;
    }

    public Double getPrice1() {
        return price1;
    }

    public void setPrice1(Double price1) {
        this.price1 = price1;
    }

    public Double getPrice2() {
        return price2;
    }

    public void setPrice2(Double price2) {
        this.price2 = price2;
    }

    public Double getPrice3() {
        return price3;
    }

    public void setPrice3(Double price3) {
        this.price3 = price3;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable == null ? null : lable.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pic=").append(pic);
        sb.append(", name=").append(name);
        sb.append(", tel=").append(tel);
        sb.append(", pwd=").append(pwd);
        sb.append(", authhosname=").append(authhosname);
        sb.append(", authimg=").append(authimg);
        sb.append(", authdegree=").append(authdegree);
        sb.append(", hosId=").append(hosId);
        sb.append(", address=").append(address);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", title=").append(title);
        sb.append(", degree=").append(degree);
        sb.append(", type=").append(type);
        sb.append(", hxLogin=").append(hxLogin);
        sb.append(", positionX=").append(positionX);
        sb.append(", positionY=").append(positionY);
        sb.append(", money=").append(money);
        sb.append(", parentId=").append(parentId);
        sb.append(", description=").append(description);
        sb.append(", regtime=").append(regtime);
        sb.append(", price1=").append(price1);
        sb.append(", price2=").append(price2);
        sb.append(", price3=").append(price3);
        sb.append(", lable=").append(lable);
        sb.append(", isDel=").append(isDel);
        sb.append(", isShow=").append(isShow);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}