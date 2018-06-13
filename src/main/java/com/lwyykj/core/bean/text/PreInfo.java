package com.lwyykj.core.bean.text;

import java.io.Serializable;

public class PreInfo implements Serializable {
    private Integer id;

    /**
     * 真实名字
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别0女，1男
     */
    private Integer sex;

    /**
     * 就诊医院
     */
    private String hospital;

    /**
     * 就诊医生
     */
    private String doc;

    /**
     * 病情描述
     */
    private String disContent;

    /**
     * 用户编号
     */
    private Integer uid;

    /**
     * 病例照片
     */
    private String pic;

    /**
     * 添加时间
     */
    private Integer addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc == null ? null : doc.trim();
    }

    public String getDisContent() {
        return disContent;
    }

    public void setDisContent(String disContent) {
        this.disContent = disContent == null ? null : disContent.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", hospital=").append(hospital);
        sb.append(", doc=").append(doc);
        sb.append(", disContent=").append(disContent);
        sb.append(", uid=").append(uid);
        sb.append(", pic=").append(pic);
        sb.append(", addtime=").append(addtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}