package com.lwyykj.core.bean.record;

import java.io.Serializable;

public class LoginRecord implements Serializable {
    private Integer id;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 登录时间
     */
    private Integer loginTime;

    /**
     * 登录设备
     */
    private String loginDevice;

    /**
     * 浏览器版本 微信版本
     */
    private String browerVer;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Integer loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice == null ? null : loginDevice.trim();
    }

    public String getBrowerVer() {
        return browerVer;
    }

    public void setBrowerVer(String browerVer) {
        this.browerVer = browerVer == null ? null : browerVer.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", loginDevice=").append(loginDevice);
        sb.append(", browerVer=").append(browerVer);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}