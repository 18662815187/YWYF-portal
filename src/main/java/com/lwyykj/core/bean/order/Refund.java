package com.lwyykj.core.bean.order;

import java.io.Serializable;

public class Refund implements Serializable {
    private Integer id;

    /**
     * 小单ID
     */
    private Integer opId;

    /**
     * 退换货快递单号
     */
    private String kdNum;

    /**
     * 0申请售后，1同意售后申请 2.拒绝售后申请 3.退款完成4换货完成,5.取消售后
     */
    private Integer status;

    /**
     * 1.不想要了2.买错了3.实际产品和描述不符
     */
    private Integer style;

    /**
     * 售后图片
     */
    private String img;

    /**
     * 售后原因
     */
    private String note;

    /**
     * 1退款2换货
     */
    private Integer reStyle;

    /**
     * 商家审核备注
     */
    private String content;

    /**
     * 用户ID
     */
    private Integer uid;
    
    /**
     * 临时字段，小单
     */
    
    private OrderProduct orderProduct;
    
    /**
     * 业务处理流水号
     */
    private String opNum;
    
    private Integer addtime;
    
    /**
     * 换货发回快递单号
     */
    private String expressNum;

    private static final long serialVersionUID = 1L;

    
    
    public String getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}

	public Integer getAddtime() {
		return addtime;
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}

	public String getOpNum() {
		return opNum;
	}

	public void setOpNum(String opNum) {
		this.opNum = opNum;
	}

	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public String getKdNum() {
        return kdNum;
    }

    public void setKdNum(String kdNum) {
        this.kdNum = kdNum == null ? null : kdNum.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getReStyle() {
        return reStyle;
    }

    public void setReStyle(Integer reStyle) {
        this.reStyle = reStyle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", opId=").append(opId);
        sb.append(", kdNum=").append(kdNum);
        sb.append(", status=").append(status);
        sb.append(", style=").append(style);
        sb.append(", img=").append(img);
        sb.append(", note=").append(note);
        sb.append(", reStyle=").append(reStyle);
        sb.append(", content=").append(content);
        sb.append(", uid=").append(uid);
        sb.append(", opNum=").append(opNum);
        sb.append(", addtime=").append(addtime);
        sb.append(", expressNum=").append(expressNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}