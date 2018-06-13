package com.lwyykj.core.bean.product;

import java.util.ArrayList;
import java.util.List;

public class ProductQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ProductQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andFacIdIsNull() {
            addCriterion("fac_id is null");
            return (Criteria) this;
        }

        public Criteria andFacIdIsNotNull() {
            addCriterion("fac_id is not null");
            return (Criteria) this;
        }

        public Criteria andFacIdEqualTo(Integer value) {
            addCriterion("fac_id =", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdNotEqualTo(Integer value) {
            addCriterion("fac_id <>", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdGreaterThan(Integer value) {
            addCriterion("fac_id >", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fac_id >=", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdLessThan(Integer value) {
            addCriterion("fac_id <", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdLessThanOrEqualTo(Integer value) {
            addCriterion("fac_id <=", value, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdIn(List<Integer> values) {
            addCriterion("fac_id in", values, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdNotIn(List<Integer> values) {
            addCriterion("fac_id not in", values, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdBetween(Integer value1, Integer value2) {
            addCriterion("fac_id between", value1, value2, "facId");
            return (Criteria) this;
        }

        public Criteria andFacIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fac_id not between", value1, value2, "facId");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBatchNumIsNull() {
            addCriterion("batch_num is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumIsNotNull() {
            addCriterion("batch_num is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumEqualTo(String value) {
            addCriterion("batch_num =", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotEqualTo(String value) {
            addCriterion("batch_num <>", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumGreaterThan(String value) {
            addCriterion("batch_num >", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumGreaterThanOrEqualTo(String value) {
            addCriterion("batch_num >=", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLessThan(String value) {
            addCriterion("batch_num <", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLessThanOrEqualTo(String value) {
            addCriterion("batch_num <=", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLike(String value) {
            addCriterion("batch_num like", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotLike(String value) {
            addCriterion("batch_num not like", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumIn(List<String> values) {
            addCriterion("batch_num in", values, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotIn(List<String> values) {
            addCriterion("batch_num not in", values, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumBetween(String value1, String value2) {
            addCriterion("batch_num between", value1, value2, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotBetween(String value1, String value2) {
            addCriterion("batch_num not between", value1, value2, "batchNum");
            return (Criteria) this;
        }

        public Criteria andDosageIsNull() {
            addCriterion("dosage is null");
            return (Criteria) this;
        }

        public Criteria andDosageIsNotNull() {
            addCriterion("dosage is not null");
            return (Criteria) this;
        }

        public Criteria andDosageEqualTo(String value) {
            addCriterion("dosage =", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotEqualTo(String value) {
            addCriterion("dosage <>", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageGreaterThan(String value) {
            addCriterion("dosage >", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageGreaterThanOrEqualTo(String value) {
            addCriterion("dosage >=", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLessThan(String value) {
            addCriterion("dosage <", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLessThanOrEqualTo(String value) {
            addCriterion("dosage <=", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLike(String value) {
            addCriterion("dosage like", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotLike(String value) {
            addCriterion("dosage not like", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageIn(List<String> values) {
            addCriterion("dosage in", values, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotIn(List<String> values) {
            addCriterion("dosage not in", values, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageBetween(String value1, String value2) {
            addCriterion("dosage between", value1, value2, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotBetween(String value1, String value2) {
            addCriterion("dosage not between", value1, value2, "dosage");
            return (Criteria) this;
        }

        public Criteria andImgsIsNull() {
            addCriterion("imgs is null");
            return (Criteria) this;
        }

        public Criteria andImgsIsNotNull() {
            addCriterion("imgs is not null");
            return (Criteria) this;
        }

        public Criteria andImgsEqualTo(String value) {
            addCriterion("imgs =", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotEqualTo(String value) {
            addCriterion("imgs <>", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThan(String value) {
            addCriterion("imgs >", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThanOrEqualTo(String value) {
            addCriterion("imgs >=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThan(String value) {
            addCriterion("imgs <", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThanOrEqualTo(String value) {
            addCriterion("imgs <=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLike(String value) {
            addCriterion("imgs like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotLike(String value) {
            addCriterion("imgs not like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsIn(List<String> values) {
            addCriterion("imgs in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotIn(List<String> values) {
            addCriterion("imgs not in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsBetween(String value1, String value2) {
            addCriterion("imgs between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotBetween(String value1, String value2) {
            addCriterion("imgs not between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andSpecsIsNull() {
            addCriterion("specs is null");
            return (Criteria) this;
        }

        public Criteria andSpecsIsNotNull() {
            addCriterion("specs is not null");
            return (Criteria) this;
        }

        public Criteria andSpecsEqualTo(String value) {
            addCriterion("specs =", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotEqualTo(String value) {
            addCriterion("specs <>", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsGreaterThan(String value) {
            addCriterion("specs >", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsGreaterThanOrEqualTo(String value) {
            addCriterion("specs >=", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsLessThan(String value) {
            addCriterion("specs <", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsLessThanOrEqualTo(String value) {
            addCriterion("specs <=", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsLike(String value) {
            addCriterion("specs like", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotLike(String value) {
            addCriterion("specs not like", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsIn(List<String> values) {
            addCriterion("specs in", values, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotIn(List<String> values) {
            addCriterion("specs not in", values, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsBetween(String value1, String value2) {
            addCriterion("specs between", value1, value2, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotBetween(String value1, String value2) {
            addCriterion("specs not between", value1, value2, "specs");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(Double value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(Double value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(Double value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(Double value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(Double value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(Double value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<Double> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<Double> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(Double value1, Double value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(Double value1, Double value2) {
            addCriterion("freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPackageListIsNull() {
            addCriterion("package_list is null");
            return (Criteria) this;
        }

        public Criteria andPackageListIsNotNull() {
            addCriterion("package_list is not null");
            return (Criteria) this;
        }

        public Criteria andPackageListEqualTo(String value) {
            addCriterion("package_list =", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListNotEqualTo(String value) {
            addCriterion("package_list <>", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListGreaterThan(String value) {
            addCriterion("package_list >", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListGreaterThanOrEqualTo(String value) {
            addCriterion("package_list >=", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListLessThan(String value) {
            addCriterion("package_list <", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListLessThanOrEqualTo(String value) {
            addCriterion("package_list <=", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListLike(String value) {
            addCriterion("package_list like", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListNotLike(String value) {
            addCriterion("package_list not like", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListIn(List<String> values) {
            addCriterion("package_list in", values, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListNotIn(List<String> values) {
            addCriterion("package_list not in", values, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListBetween(String value1, String value2) {
            addCriterion("package_list between", value1, value2, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListNotBetween(String value1, String value2) {
            addCriterion("package_list not between", value1, value2, "packageList");
            return (Criteria) this;
        }

        public Criteria andProTypeidIsNull() {
            addCriterion("pro_typeId is null");
            return (Criteria) this;
        }

        public Criteria andProTypeidIsNotNull() {
            addCriterion("pro_typeId is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeidEqualTo(Integer value) {
            addCriterion("pro_typeId =", value, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andProTypeidNotEqualTo(Integer value) {
            addCriterion("pro_typeId <>", value, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andProTypeidGreaterThan(Integer value) {
            addCriterion("pro_typeId >", value, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andProTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_typeId >=", value, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andProTypeidLessThan(Integer value) {
            addCriterion("pro_typeId <", value, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andProTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("pro_typeId <=", value, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andProTypeidIn(List<Integer> values) {
            addCriterion("pro_typeId in", values, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andProTypeidNotIn(List<Integer> values) {
            addCriterion("pro_typeId not in", values, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andProTypeidBetween(Integer value1, Integer value2) {
            addCriterion("pro_typeId between", value1, value2, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andProTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_typeId not between", value1, value2, "proTypeid");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNull() {
            addCriterion("disease_id is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIsNotNull() {
            addCriterion("disease_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdEqualTo(Integer value) {
            addCriterion("disease_id =", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotEqualTo(Integer value) {
            addCriterion("disease_id <>", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThan(Integer value) {
            addCriterion("disease_id >", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disease_id >=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThan(Integer value) {
            addCriterion("disease_id <", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("disease_id <=", value, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdIn(List<Integer> values) {
            addCriterion("disease_id in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotIn(List<Integer> values) {
            addCriterion("disease_id not in", values, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdBetween(Integer value1, Integer value2) {
            addCriterion("disease_id between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andDiseaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disease_id not between", value1, value2, "diseaseId");
            return (Criteria) this;
        }

        public Criteria andFunIdIsNull() {
            addCriterion("fun_id is null");
            return (Criteria) this;
        }

        public Criteria andFunIdIsNotNull() {
            addCriterion("fun_id is not null");
            return (Criteria) this;
        }

        public Criteria andFunIdEqualTo(Integer value) {
            addCriterion("fun_id =", value, "funId");
            return (Criteria) this;
        }

        public Criteria andFunIdNotEqualTo(Integer value) {
            addCriterion("fun_id <>", value, "funId");
            return (Criteria) this;
        }

        public Criteria andFunIdGreaterThan(Integer value) {
            addCriterion("fun_id >", value, "funId");
            return (Criteria) this;
        }

        public Criteria andFunIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fun_id >=", value, "funId");
            return (Criteria) this;
        }

        public Criteria andFunIdLessThan(Integer value) {
            addCriterion("fun_id <", value, "funId");
            return (Criteria) this;
        }

        public Criteria andFunIdLessThanOrEqualTo(Integer value) {
            addCriterion("fun_id <=", value, "funId");
            return (Criteria) this;
        }

        public Criteria andFunIdIn(List<Integer> values) {
            addCriterion("fun_id in", values, "funId");
            return (Criteria) this;
        }

        public Criteria andFunIdNotIn(List<Integer> values) {
            addCriterion("fun_id not in", values, "funId");
            return (Criteria) this;
        }

        public Criteria andFunIdBetween(Integer value1, Integer value2) {
            addCriterion("fun_id between", value1, value2, "funId");
            return (Criteria) this;
        }

        public Criteria andFunIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fun_id not between", value1, value2, "funId");
            return (Criteria) this;
        }

        public Criteria andPhIdIsNull() {
            addCriterion("ph_id is null");
            return (Criteria) this;
        }

        public Criteria andPhIdIsNotNull() {
            addCriterion("ph_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhIdEqualTo(Integer value) {
            addCriterion("ph_id =", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdNotEqualTo(Integer value) {
            addCriterion("ph_id <>", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdGreaterThan(Integer value) {
            addCriterion("ph_id >", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ph_id >=", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdLessThan(Integer value) {
            addCriterion("ph_id <", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdLessThanOrEqualTo(Integer value) {
            addCriterion("ph_id <=", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdIn(List<Integer> values) {
            addCriterion("ph_id in", values, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdNotIn(List<Integer> values) {
            addCriterion("ph_id not in", values, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdBetween(Integer value1, Integer value2) {
            addCriterion("ph_id between", value1, value2, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ph_id not between", value1, value2, "phId");
            return (Criteria) this;
        }

        public Criteria andIsCounterIsNull() {
            addCriterion("is_counter is null");
            return (Criteria) this;
        }

        public Criteria andIsCounterIsNotNull() {
            addCriterion("is_counter is not null");
            return (Criteria) this;
        }

        public Criteria andIsCounterEqualTo(Boolean value) {
            addCriterion("is_counter =", value, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsCounterNotEqualTo(Boolean value) {
            addCriterion("is_counter <>", value, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsCounterGreaterThan(Boolean value) {
            addCriterion("is_counter >", value, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsCounterGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_counter >=", value, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsCounterLessThan(Boolean value) {
            addCriterion("is_counter <", value, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsCounterLessThanOrEqualTo(Boolean value) {
            addCriterion("is_counter <=", value, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsCounterIn(List<Boolean> values) {
            addCriterion("is_counter in", values, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsCounterNotIn(List<Boolean> values) {
            addCriterion("is_counter not in", values, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsCounterBetween(Boolean value1, Boolean value2) {
            addCriterion("is_counter between", value1, value2, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsCounterNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_counter not between", value1, value2, "isCounter");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Boolean value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Boolean value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Boolean value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Boolean value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Boolean value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Boolean> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Boolean> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Boolean value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Boolean value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Boolean value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Boolean value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Boolean value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Boolean> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Boolean> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Boolean value1, Boolean value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNull() {
            addCriterion("is_new is null");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNotNull() {
            addCriterion("is_new is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewEqualTo(Boolean value) {
            addCriterion("is_new =", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotEqualTo(Boolean value) {
            addCriterion("is_new <>", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThan(Boolean value) {
            addCriterion("is_new >", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_new >=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThan(Boolean value) {
            addCriterion("is_new <", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThanOrEqualTo(Boolean value) {
            addCriterion("is_new <=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewIn(List<Boolean> values) {
            addCriterion("is_new in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotIn(List<Boolean> values) {
            addCriterion("is_new not in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewBetween(Boolean value1, Boolean value2) {
            addCriterion("is_new between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_new not between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(Boolean value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(Boolean value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(Boolean value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(Boolean value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(Boolean value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<Boolean> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<Boolean> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsCommendIsNull() {
            addCriterion("is_commend is null");
            return (Criteria) this;
        }

        public Criteria andIsCommendIsNotNull() {
            addCriterion("is_commend is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommendEqualTo(Boolean value) {
            addCriterion("is_commend =", value, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsCommendNotEqualTo(Boolean value) {
            addCriterion("is_commend <>", value, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsCommendGreaterThan(Boolean value) {
            addCriterion("is_commend >", value, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsCommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_commend >=", value, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsCommendLessThan(Boolean value) {
            addCriterion("is_commend <", value, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsCommendLessThanOrEqualTo(Boolean value) {
            addCriterion("is_commend <=", value, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsCommendIn(List<Boolean> values) {
            addCriterion("is_commend in", values, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsCommendNotIn(List<Boolean> values) {
            addCriterion("is_commend not in", values, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsCommendBetween(Boolean value1, Boolean value2) {
            addCriterion("is_commend between", value1, value2, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsCommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_commend not between", value1, value2, "isCommend");
            return (Criteria) this;
        }

        public Criteria andIsActivityIsNull() {
            addCriterion("is_activity is null");
            return (Criteria) this;
        }

        public Criteria andIsActivityIsNotNull() {
            addCriterion("is_activity is not null");
            return (Criteria) this;
        }

        public Criteria andIsActivityEqualTo(Boolean value) {
            addCriterion("is_activity =", value, "isActivity");
            return (Criteria) this;
        }

        public Criteria andIsActivityNotEqualTo(Boolean value) {
            addCriterion("is_activity <>", value, "isActivity");
            return (Criteria) this;
        }

        public Criteria andIsActivityGreaterThan(Boolean value) {
            addCriterion("is_activity >", value, "isActivity");
            return (Criteria) this;
        }

        public Criteria andIsActivityGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_activity >=", value, "isActivity");
            return (Criteria) this;
        }

        public Criteria andIsActivityLessThan(Boolean value) {
            addCriterion("is_activity <", value, "isActivity");
            return (Criteria) this;
        }

        public Criteria andIsActivityLessThanOrEqualTo(Boolean value) {
            addCriterion("is_activity <=", value, "isActivity");
            return (Criteria) this;
        }

        public Criteria andIsActivityIn(List<Boolean> values) {
            addCriterion("is_activity in", values, "isActivity");
            return (Criteria) this;
        }

        public Criteria andIsActivityNotIn(List<Boolean> values) {
            addCriterion("is_activity not in", values, "isActivity");
            return (Criteria) this;
        }

        public Criteria andIsActivityBetween(Boolean value1, Boolean value2) {
            addCriterion("is_activity between", value1, value2, "isActivity");
            return (Criteria) this;
        }

        public Criteria andIsActivityNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_activity not between", value1, value2, "isActivity");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Integer value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Integer value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Integer value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Integer value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Integer> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Integer> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Integer value1, Integer value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSalesIsNull() {
            addCriterion("sales is null");
            return (Criteria) this;
        }

        public Criteria andSalesIsNotNull() {
            addCriterion("sales is not null");
            return (Criteria) this;
        }

        public Criteria andSalesEqualTo(Integer value) {
            addCriterion("sales =", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotEqualTo(Integer value) {
            addCriterion("sales <>", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThan(Integer value) {
            addCriterion("sales >", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales >=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThan(Integer value) {
            addCriterion("sales <", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThanOrEqualTo(Integer value) {
            addCriterion("sales <=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesIn(List<Integer> values) {
            addCriterion("sales in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotIn(List<Integer> values) {
            addCriterion("sales not in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesBetween(Integer value1, Integer value2) {
            addCriterion("sales between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotBetween(Integer value1, Integer value2) {
            addCriterion("sales not between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNull() {
            addCriterion("click_num is null");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNotNull() {
            addCriterion("click_num is not null");
            return (Criteria) this;
        }

        public Criteria andClickNumEqualTo(Integer value) {
            addCriterion("click_num =", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotEqualTo(Integer value) {
            addCriterion("click_num <>", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThan(Integer value) {
            addCriterion("click_num >", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_num >=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThan(Integer value) {
            addCriterion("click_num <", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThanOrEqualTo(Integer value) {
            addCriterion("click_num <=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumIn(List<Integer> values) {
            addCriterion("click_num in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotIn(List<Integer> values) {
            addCriterion("click_num not in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumBetween(Integer value1, Integer value2) {
            addCriterion("click_num between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotBetween(Integer value1, Integer value2) {
            addCriterion("click_num not between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Double value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Double value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Double value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Double value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Double value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Double value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Double> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Double> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Double value1, Double value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Double value1, Double value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeIsNull() {
            addCriterion("whether_fee is null");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeIsNotNull() {
            addCriterion("whether_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeEqualTo(Boolean value) {
            addCriterion("whether_fee =", value, "whetherFee");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeNotEqualTo(Boolean value) {
            addCriterion("whether_fee <>", value, "whetherFee");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeGreaterThan(Boolean value) {
            addCriterion("whether_fee >", value, "whetherFee");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("whether_fee >=", value, "whetherFee");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeLessThan(Boolean value) {
            addCriterion("whether_fee <", value, "whetherFee");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeLessThanOrEqualTo(Boolean value) {
            addCriterion("whether_fee <=", value, "whetherFee");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeIn(List<Boolean> values) {
            addCriterion("whether_fee in", values, "whetherFee");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeNotIn(List<Boolean> values) {
            addCriterion("whether_fee not in", values, "whetherFee");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeBetween(Boolean value1, Boolean value2) {
            addCriterion("whether_fee between", value1, value2, "whetherFee");
            return (Criteria) this;
        }

        public Criteria andWhetherFeeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("whether_fee not between", value1, value2, "whetherFee");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}