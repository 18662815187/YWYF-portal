package com.lwyykj.core.bean.text;

import java.io.Serializable;

import com.lwyykj.core.bean.product.Product;
import com.lwyykj.core.bean.user.User;

public class Comments implements Serializable {
    private Integer id;

    /**
     * 评论大表ID（未使用）
     */
    private Integer cid;

    /**
     * 产品id
     */
    private Integer pid;

    /**
     * 评论用户ID
     */
    private Integer uid;

    /**
     * 评论图片，图片地址用逗号隔开
     */
    private String pics;

    private String content;

    /**
     * 本为星级改为：0好评、1中评、2差评
     */
    private Integer greade;

    private Boolean isDel;

    /**
     * 提交时间
     */
    private Integer addtime;
    
    
    /**
     * 临时字段 用户信息
     */
    private User user;
    /**
     * 临时字段产品
     */
    private Product product;

    private static final long serialVersionUID = 1L;
    

    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getGreade() {
        return greade;
    }

    public void setGreade(Integer greade) {
        this.greade = greade;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cid=").append(cid);
        sb.append(", pid=").append(pid);
        sb.append(", uid=").append(uid);
        sb.append(", pics=").append(pics);
        sb.append(", content=").append(content);
        sb.append(", greade=").append(greade);
        sb.append(", isDel=").append(isDel);
        sb.append(", addtime=").append(addtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}