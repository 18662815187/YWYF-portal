package com.lwyykj.core.bean.text;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 附件图片
     */
    private String imgs;

    /**
     * 作者
     */
    private String author;

    private Date addtime;

    /**
     * 备注
     */
    private String note;

    /**
     * 1未删除，0已删除，true/false
     */
    private Boolean isShow;

    /**
     * 通知内容
     */
    private String context;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", imgs=").append(imgs);
        sb.append(", author=").append(author);
        sb.append(", addtime=").append(addtime);
        sb.append(", note=").append(note);
        sb.append(", isShow=").append(isShow);
        sb.append(", context=").append(context);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}