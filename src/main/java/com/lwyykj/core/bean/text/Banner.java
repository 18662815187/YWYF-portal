package com.lwyykj.core.bean.text;

import java.io.Serializable;

public class Banner implements Serializable {
    private Integer id;

    private String name;

    /**
     * 链接内容所属ID
     */
    private Integer linkId;

    /**
     * 类型，0通知，1产品，2医生，3活动
     */
    private Integer type;

    /**
     * 封面图
     */
    private String pic;

    /**
     * 位置关联banner位置表
     */
    private Integer position;

    /**
     * 0不显示，1显示，2已删除
     */
    private Integer status;

    private Integer addtime;
    
    /**
     * 临时字段跳转链接
     */
    private String url;
    
    /**
     * 临时字段位置名称
     */
    private String posName;

    private static final long serialVersionUID = 1L;
    
    
    
   

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", name=").append(name);
        sb.append(", linkId=").append(linkId);
        sb.append(", type=").append(type);
        sb.append(", pic=").append(pic);
        sb.append(", position=").append(position);
        sb.append(", status=").append(status);
        sb.append(", addtime=").append(addtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}