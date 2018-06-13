package com.lwyykj.core.bean.factory;

import java.io.Serializable;

public class Factory implements Serializable {
    private Integer id;

    private String name;

    private String address;

    private String tel;

    private String pass;

    /**
     * 负责人
     */
    private String manager;

    /**
     * 负责人电话
     */
    private String phone;

    private String content;

    /**
     * 省份编码
     */
    private String provincesId;

    /**
     * 城市编码
     */
    private String cityId;

    /**
     * 地区编码
     */
    private String area;

    /**
     * 头像
     */
    private String pic;

    /**
     * 企业图集
     */
    private String imgs;

    /**
     * 余额
     */
    private Double money;

    /**
     * 上级ID
     */
    private Integer parentId;

    /**
     * 审核
     */
    private Boolean isShow;

    private Boolean isDel;
   
    /**
     * 注册方式，0后台录入，1PC注册，2微网站注册
     */
    private Integer regType;

    /**
     * 注册时间
     */
    private Integer regTime;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getRegType() {
        return regType;
    }

    public void setRegType(Integer regType) {
        this.regType = regType;
    }

    public Integer getRegTime() {
        return regTime;
    }

    public void setRegTime(Integer regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", tel=").append(tel);
        sb.append(", pass=").append(pass);
        sb.append(", manager=").append(manager);
        sb.append(", phone=").append(phone);
        sb.append(", content=").append(content);
        sb.append(", provincesId=").append(provincesId);
        sb.append(", cityId=").append(cityId);
        sb.append(", area=").append(area);
        sb.append(", pic=").append(pic);
        sb.append(", imgs=").append(imgs);
        sb.append(", money=").append(money);
        sb.append(", parentId=").append(parentId);
        sb.append(", isShow=").append(isShow);
        sb.append(", isDel=").append(isDel);
        sb.append(", regType=").append(regType);
        sb.append(", regTime=").append(regTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}