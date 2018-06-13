package com.lwyykj.core.product.service;

import java.util.List;

import com.lwyykj.core.bean.product.Brand;

import cn.itcast.common.page.Pagination;

public interface BrandService {
	//分页列表
	Pagination selectByPagination(Integer pageNo,String brandName);
	//首页取12条
	List<Brand> selectForPC();
}
