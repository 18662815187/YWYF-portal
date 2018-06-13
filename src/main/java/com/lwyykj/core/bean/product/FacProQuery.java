package com.lwyykj.core.bean.product;

import java.util.ArrayList;
import java.util.List;

public class FacProQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public FacProQuery() {
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

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Integer value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Integer value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Integer value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Integer value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Integer value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Integer> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Integer> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Integer value1, Integer value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andFacNameIsNull() {
            addCriterion("fac_name is null");
            return (Criteria) this;
        }

        public Criteria andFacNameIsNotNull() {
            addCriterion("fac_name is not null");
            return (Criteria) this;
        }

        public Criteria andFacNameEqualTo(String value) {
            addCriterion("fac_name =", value, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameNotEqualTo(String value) {
            addCriterion("fac_name <>", value, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameGreaterThan(String value) {
            addCriterion("fac_name >", value, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameGreaterThanOrEqualTo(String value) {
            addCriterion("fac_name >=", value, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameLessThan(String value) {
            addCriterion("fac_name <", value, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameLessThanOrEqualTo(String value) {
            addCriterion("fac_name <=", value, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameLike(String value) {
            addCriterion("fac_name like", value, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameNotLike(String value) {
            addCriterion("fac_name not like", value, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameIn(List<String> values) {
            addCriterion("fac_name in", values, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameNotIn(List<String> values) {
            addCriterion("fac_name not in", values, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameBetween(String value1, String value2) {
            addCriterion("fac_name between", value1, value2, "facName");
            return (Criteria) this;
        }

        public Criteria andFacNameNotBetween(String value1, String value2) {
            addCriterion("fac_name not between", value1, value2, "facName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
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

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
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

        public Criteria andPhNameIsNull() {
            addCriterion("ph_name is null");
            return (Criteria) this;
        }

        public Criteria andPhNameIsNotNull() {
            addCriterion("ph_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhNameEqualTo(String value) {
            addCriterion("ph_name =", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameNotEqualTo(String value) {
            addCriterion("ph_name <>", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameGreaterThan(String value) {
            addCriterion("ph_name >", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameGreaterThanOrEqualTo(String value) {
            addCriterion("ph_name >=", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameLessThan(String value) {
            addCriterion("ph_name <", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameLessThanOrEqualTo(String value) {
            addCriterion("ph_name <=", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameLike(String value) {
            addCriterion("ph_name like", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameNotLike(String value) {
            addCriterion("ph_name not like", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameIn(List<String> values) {
            addCriterion("ph_name in", values, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameNotIn(List<String> values) {
            addCriterion("ph_name not in", values, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameBetween(String value1, String value2) {
            addCriterion("ph_name between", value1, value2, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameNotBetween(String value1, String value2) {
            addCriterion("ph_name not between", value1, value2, "phName");
            return (Criteria) this;
        }

        public Criteria andHosNameIsNull() {
            addCriterion("hos_name is null");
            return (Criteria) this;
        }

        public Criteria andHosNameIsNotNull() {
            addCriterion("hos_name is not null");
            return (Criteria) this;
        }

        public Criteria andHosNameEqualTo(String value) {
            addCriterion("hos_name =", value, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameNotEqualTo(String value) {
            addCriterion("hos_name <>", value, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameGreaterThan(String value) {
            addCriterion("hos_name >", value, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameGreaterThanOrEqualTo(String value) {
            addCriterion("hos_name >=", value, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameLessThan(String value) {
            addCriterion("hos_name <", value, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameLessThanOrEqualTo(String value) {
            addCriterion("hos_name <=", value, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameLike(String value) {
            addCriterion("hos_name like", value, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameNotLike(String value) {
            addCriterion("hos_name not like", value, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameIn(List<String> values) {
            addCriterion("hos_name in", values, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameNotIn(List<String> values) {
            addCriterion("hos_name not in", values, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameBetween(String value1, String value2) {
            addCriterion("hos_name between", value1, value2, "hosName");
            return (Criteria) this;
        }

        public Criteria andHosNameNotBetween(String value1, String value2) {
            addCriterion("hos_name not between", value1, value2, "hosName");
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

        public Criteria andFreigthIsNull() {
            addCriterion("freigth is null");
            return (Criteria) this;
        }

        public Criteria andFreigthIsNotNull() {
            addCriterion("freigth is not null");
            return (Criteria) this;
        }

        public Criteria andFreigthEqualTo(Double value) {
            addCriterion("freigth =", value, "freigth");
            return (Criteria) this;
        }

        public Criteria andFreigthNotEqualTo(Double value) {
            addCriterion("freigth <>", value, "freigth");
            return (Criteria) this;
        }

        public Criteria andFreigthGreaterThan(Double value) {
            addCriterion("freigth >", value, "freigth");
            return (Criteria) this;
        }

        public Criteria andFreigthGreaterThanOrEqualTo(Double value) {
            addCriterion("freigth >=", value, "freigth");
            return (Criteria) this;
        }

        public Criteria andFreigthLessThan(Double value) {
            addCriterion("freigth <", value, "freigth");
            return (Criteria) this;
        }

        public Criteria andFreigthLessThanOrEqualTo(Double value) {
            addCriterion("freigth <=", value, "freigth");
            return (Criteria) this;
        }

        public Criteria andFreigthIn(List<Double> values) {
            addCriterion("freigth in", values, "freigth");
            return (Criteria) this;
        }

        public Criteria andFreigthNotIn(List<Double> values) {
            addCriterion("freigth not in", values, "freigth");
            return (Criteria) this;
        }

        public Criteria andFreigthBetween(Double value1, Double value2) {
            addCriterion("freigth between", value1, value2, "freigth");
            return (Criteria) this;
        }

        public Criteria andFreigthNotBetween(Double value1, Double value2) {
            addCriterion("freigth not between", value1, value2, "freigth");
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