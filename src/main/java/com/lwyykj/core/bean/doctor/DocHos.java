package com.lwyykj.core.bean.doctor;

import java.io.Serializable;

public class DocHos implements Serializable {
    private Integer id;

    /**
     * 头像
     */
    private String pic;

    /**
     * 医院ID
     */
    private Integer hosId;

    private String name;

    private String pwd;

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
    private Integer regType;

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
     * 标签逗号隔开
     */
    private String lable;

    private Boolean isDel;

    private Boolean isShow;

    /**
     * 医院名
     */
    private String hosName;

    /**
     * 手机号用于登录
     */
    private String tel;

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

    private static final long serialVersionUID = 1L;

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

    public Integer getHosId() {
        return hosId;
    }

    public void setHosId(Integer hosId) {
        this.hosId = hosId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
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

    public Integer getRegType() {
        return regType;
    }

    public void setRegType(Integer regType) {
        this.regType = regType;
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

    public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName == null ? null : hosName.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pic=").append(pic);
        sb.append(", hosId=").append(hosId);
        sb.append(", name=").append(name);
        sb.append(", pwd=").append(pwd);
        sb.append(", provincesId=").append(provincesId);
        sb.append(", cityId=").append(cityId);
        sb.append(", area=").append(area);
        sb.append(", address=").append(address);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", title=").append(title);
        sb.append(", degree=").append(degree);
        sb.append(", regType=").append(regType);
        sb.append(", money=").append(money);
        sb.append(", parentId=").append(parentId);
        sb.append(", description=").append(description);
        sb.append(", regtime=").append(regtime);
        sb.append(", lable=").append(lable);
        sb.append(", isDel=").append(isDel);
        sb.append(", isShow=").append(isShow);
        sb.append(", hosName=").append(hosName);
        sb.append(", tel=").append(tel);
        sb.append(", authhosname=").append(authhosname);
        sb.append(", authimg=").append(authimg);
        sb.append(", authdegree=").append(authdegree);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}