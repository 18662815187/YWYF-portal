package com.lwyykj.core.bean.text;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author yl 用于产品详细页评论的临时Model
 *
 */
public class DisComments implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 根据产品ID查询出来的评论集合
	private List<Comments> comments;
	// 好评数
	private Integer good;
	// 中评数
	private Integer mid;
	// 差评
	private Integer low;
	// 好评占比
	private Integer accountGood;
	// 中评占比
	private Integer accountMid;
	// 差评占比
	private Integer accountLow;
	// 所有评价数量
	private Integer allComments;
	
	

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public Integer getGood() {
		return good;
	}

	public void setGood(Integer good) {
		this.good = good;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getLow() {
		return low;
	}

	public void setLow(Integer low) {
		this.low = low;
	}

	public Integer getAccountGood() {
		return accountGood;
	}

	public void setAccountGood(Integer accountGood) {
		this.accountGood = accountGood;
	}

	public Integer getAccountMid() {
		return accountMid;
	}

	public void setAccountMid(Integer accountMid) {
		this.accountMid = accountMid;
	}

	public Integer getAccountLow() {
		return accountLow;
	}

	public void setAccountLow(Integer accountLow) {
		this.accountLow = accountLow;
	}

	public Integer getAllComments() {
		return allComments;
	}

	public void setAllComments(Integer allComments) {
		this.allComments = allComments;
	}
	
}
