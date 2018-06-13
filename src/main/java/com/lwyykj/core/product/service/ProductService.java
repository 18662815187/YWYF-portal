package com.lwyykj.core.product.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lwyykj.core.bean.product.Product;

import cn.itcast.common.page.Pagination;
/**
 * 
 * @author yl 2018.3.23
 *
 */
public interface ProductService {
	//列表
	public Pagination selectByPagination(Integer pageNo,String keywords);
	//搜索联想关键字，查询所有名字
	List<Product> findAllName(String keywords);
	//根据主键检索
	Product selectByPrimaryKey(Integer id,HttpServletRequest request);
	//主键查询非页面使用
	Product selectByPid(Integer pid);
}
