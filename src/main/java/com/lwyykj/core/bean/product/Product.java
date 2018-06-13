package com.lwyykj.core.bean.product;

import java.io.Serializable;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

import com.lwyykj.core.bean.text.MailFee;

/**
 * 
 * @author yl
 * @Field注解用于solr的提交
 *
 */
public class Product implements Serializable {
	@Field("id")
	private Integer id;

	/**
	 * 品牌ID
	 */
	@Field("brand_id")
	private Integer brandId;

	/**
	 * 厂家ID
	 */
	@Field("fac_id")
	private Integer facId;

	/**
	 * 封面图片
	 */
	@Field("pic")
	private String pic;
	@Field("name")
	private String name;

	/**
	 * 产品批号
	 */
	private String batchNum;

	/**
	 * 剂型
	 */
	private String dosage;

	/**
	 * 图片集
	 */
	private String imgs;

	/**
	 * 规格，多个规格用逗号隔开
	 */
	private String specs;

	/**
	 * 运费
	 */
	private Double freight;

	/**
	 * 商品描述
	 */
	private String description;

	/**
	 * 包装清单
	 */
	private String packageList;

	/**
	 * 产品类型ID
	 */
	@Field("pro_typeId")
	private Integer proTypeid;

	/**
	 * 病症ID
	 */
	@Field("disease_id")
	private Integer diseaseId;

	/**
	 * 人体系统ID
	 */
	@Field("fun_id")
	private Integer funId;

	/**
	 * 归属店铺ID
	 */
	private Integer phId;
	
	 /**
     * 受否处方，0否1是
     */
    private Boolean isCounter;

	private Boolean isDel;

	private Boolean isShow;

	private Boolean isNew;

	private Boolean isHot;

	/**
	 * 是否推荐
	 */
	private Boolean isCommend;

	/**
	 * 是否参与活动
	 */
	private Boolean isActivity;

	private Integer createTime;

	/**
	 * 销售量
	 */
	private Integer sales;

	/**
	 * 点击次数
	 */
	private Integer clickNum;

	/**
	 * 星级
	 */
	private Double grade;

	/**
	 * 临时字段 厂家名称
	 */
	private String fac_name;

	/**
	 * 临时字段品牌名称
	 */
	private String brand_name;

	/**
	 * 临时字段药店名字
	 */
	private String ph_name;
	/**
	 * 临时字段用于全文检索时显示的价格
	 */
	@Field("price")
	private double price;

	/**
	 * 临时字段skus
	 */
	private List<Sku> skus;

	/**
	 * 临时字段用于同类推荐
	 * 
	 */
	private List<Product> products;
	
	/**
     * 是否包邮
     */
    private Boolean whetherFee;
    
    /**
     * 运费模版临时对象
     */
    private MailFee mailFee;

	private static final long serialVersionUID = 1L;
	

	public MailFee getMailFee() {
		return mailFee;
	}

	public void setMailFee(MailFee mailFee) {
		this.mailFee = mailFee;
	}

	public Boolean getWhetherFee() {
		return whetherFee;
	}

	public void setWhetherFee(Boolean whetherFee) {
		this.whetherFee = whetherFee;
	}

	public Boolean getIsCounter() {
		return isCounter;
	}

	public void setIsCounter(Boolean isCounter) {
		this.isCounter = isCounter;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public List<Sku> getSkus() {
		return skus;
	}

	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 图集数组
	 */
	public String[] getPics() {
		if (imgs == null || imgs == "") {
			return null;
		}
		return imgs.split(",");
	}

	public String getFac_name() {
		return fac_name;
	}

	public void setFac_name(String fac_name) {
		this.fac_name = fac_name;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getPh_name() {
		return ph_name;
	}

	public void setPh_name(String ph_name) {
		this.ph_name = ph_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getFacId() {
		return facId;
	}

	public void setFacId(Integer facId) {
		this.facId = facId;
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

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs == null ? null : imgs.trim();
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs == null ? null : specs.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPackageList() {
		return packageList;
	}

	public void setPackageList(String packageList) {
		this.packageList = packageList;
	}

	public Integer getProTypeid() {
		return proTypeid;
	}

	public void setProTypeid(Integer proTypeid) {
		this.proTypeid = proTypeid;
	}

	public Integer getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}

	public Integer getFunId() {
		return funId;
	}

	public void setFunId(Integer funId) {
		this.funId = funId;
	}

	public Integer getPhId() {
		return phId;
	}

	public void setPhId(Integer phId) {
		this.phId = phId;
	}

	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public Boolean getIsCommend() {
		return isCommend;
	}

	public void setIsCommend(Boolean isCommend) {
		this.isCommend = isCommend;
	}

	public Boolean getIsActivity() {
		return isActivity;
	}

	public void setIsActivity(Boolean isActivity) {
		this.isActivity = isActivity;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
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
		sb.append(", batchNum=").append(batchNum);
		sb.append(", dosage=").append(dosage);
		sb.append(", imgs=").append(imgs);
		sb.append(", specs=").append(specs);
		sb.append(", freight=").append(freight);
		sb.append(", description=").append(description);
		sb.append(", packageList=").append(packageList);
		sb.append(", proTypeid=").append(proTypeid);
		sb.append(", diseaseId=").append(diseaseId);
		sb.append(", funId=").append(funId);
		sb.append(", phId=").append(phId);
		sb.append(", isCounter=").append(isCounter);
		sb.append(", isDel=").append(isDel);
		sb.append(", isShow=").append(isShow);
		sb.append(", isNew=").append(isNew);
		sb.append(", isHot=").append(isHot);
		sb.append(", isCommend=").append(isCommend);
		sb.append(", isActivity=").append(isActivity);
		sb.append(", createTime=").append(createTime);
		sb.append(", clickNum=").append(clickNum);
		sb.append(", grade=").append(grade);
		sb.append(", whetherFee=").append(whetherFee);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}