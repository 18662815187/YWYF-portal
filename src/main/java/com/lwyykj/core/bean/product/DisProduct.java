package com.lwyykj.core.bean.product;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
/**
 * 此类用于solr搜索服务
 * @author yl
 * @Field注解用于solr的提交
 *
 */
public class DisProduct implements Serializable {
	@Field("id")
	private String id;

	/**
	 * 品牌ID
	 */
	@Field("brand_id")
	private String brandId;

	/**
	 * 厂家ID
	 */
	@Field("fac_id")
	private String facId;
	/**
	 * 封面图片
	 */
	@Field("pic")
	private String pic;
	@Field("name")
	private String name;
	/**
	 * 产品类型ID
	 */
	@Field("pro_typeId")
	private String proTypeid;
	/**
	 * 病症ID
	 */
	@Field("disease_id")
	private String diseaseId;
	/**
	 * 人体系统ID
	 */
	@Field("fun_id")
	private String funId;
	/**
	 * 临时字段用于全文检索时显示的价格
	 */
	@Field("price")
	private String price;
	
	@Field("addtime")
	private String createTime;
	
	/**
	 * 是否推荐
	 */
	@Field("is_commend")
	private String isCommend;
	/**
	 * 临时字段用于跳转
	 * 
	 */
	private String url;

	private static final long serialVersionUID = 1L;
	
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIsCommend() {
		return isCommend;
	}

	public void setIsCommend(String isCommend) {
		this.isCommend = isCommend;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getFacId() {
		return facId;
	}

	public void setFacId(String facId) {
		this.facId = facId;
	}

	public String getProTypeid() {
		return proTypeid;
	}

	public void setProTypeid(String proTypeid) {
		this.proTypeid = proTypeid;
	}

	public String getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}

	public String getFunId() {
		return funId;
	}

	public void setFunId(String funId) {
		this.funId = funId;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic == null ? null : pic.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	

	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", brandId=").append(brandId);
		sb.append(", facId=").append(facId);
		sb.append(", pic=").append(pic);
		sb.append(", name=").append(name);
		sb.append(", proTypeid=").append(proTypeid);
		sb.append(", diseaseId=").append(diseaseId);
		sb.append(", funId=").append(funId);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append(", isCommend=").append(isCommend);
		sb.append("]");
		return sb.toString();
	}
}