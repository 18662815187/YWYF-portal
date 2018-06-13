package com.lwyykj.core.solr.service;

import java.util.List;

import com.lwyykj.core.bean.product.DisProduct;
import cn.itcast.common.page.Pagination;

public interface SolrService {
	// 根据模块分类ID查询结果
	List<DisProduct> queryByTypeId(Integer typeId, Boolean isCommend, Integer pageSize);

	// 全文搜索
	Pagination selectByPagination(Integer pageNo, String keyword, String brandId, String typeId, String disId,
			String funId, String price,Integer priceType) throws Exception;

	// 搜索全部，按分类进行分组
	List<List<DisProduct>> queryAll();
}
