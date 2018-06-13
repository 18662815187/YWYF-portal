package com.lwyykj.core.bean.user;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String tel;

    private String pwd;

    /**
     * 环信帐号
     */
    private String hxLogin;

    private Integer sex;

    private Integer age;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 联系地址
     */
    private String adreess;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 头像
     */
    private String pic;

    /**
     * 用户链接，个人网址
     */
    private String userUrl;

    /**
     * 冗余字段1
     */
    private String more;

    private Double money;

    /**
     * 冗余字段2
     */
    private Integer param1;

    private Integer addtime;

    /**
     * 创建方式，0后台录入，1微网站注册，2PC网站注册，3App注册
     */
    private Integer addType;

    /**
     * 用户权限类型
     */
    private Integer role;

    /**
     * 0正常显示1冻结2屏蔽
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getHxLogin() {
        return hxLogin;
    }

    public void setHxLogin(String hxLogin) {
        this.hxLogin = hxLogin == null ? null : hxLogin.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAdreess() {
        return adreess;
    }

    public void setAdreess(String adreess) {
        this.adreess = adreess == null ? null : adreess.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl == null ? null : userUrl.trim();
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more == null ? null : more.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getParam1() {
        return param1;
    }

    public void setParam1(Integer param1) {
        this.param1 = param1;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public Integer getAddType() {
        return addType;
    }

    public void setAddType(Integer addType) {
        this.addType = addType;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tel=").append(tel);
        sb.append(", pwd=").append(pwd);
        sb.append(", hxLogin=").append(hxLogin);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", nickname=").append(nickname);
        sb.append(", adreess=").append(adreess);
        sb.append(", qrcode=").append(qrcode);
        sb.append(", signature=").append(signature);
        sb.append(", pic=").append(pic);
        sb.append(", userUrl=").append(userUrl);
        sb.append(", more=").append(more);
        sb.append(", money=").append(money);
        sb.append(", param1=").append(param1);
        sb.append(", addtime=").append(addtime);
        sb.append(", addType=").append(addType);
        sb.append(", role=").append(role);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}