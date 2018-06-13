package com.lwyykj.core.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lwyykj.core.bean.product.Brand;
import com.lwyykj.core.bean.product.BrandQuery;
import com.lwyykj.core.bean.product.BrandQuery.Criteria;
import com.lwyykj.core.dao.product.BrandDao;
import com.lwyykj.core.product.service.BrandService;
import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 2018.4.10
 *
 */
@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {
	@Resource
	private BrandDao brandDao;

	@Override
	public Pagination selectByPagination(Integer pageNo, String brandName) {
		StringBuilder sb = new StringBuilder();
		BrandQuery brandQuery = new BrandQuery();
		Criteria createCriteria = brandQuery.createCriteria();
		brandQuery.setFields("id,pic");
		brandQuery.setOrderByClause("id desc");
		brandQuery.setPageNo(Pagination.cpn(pageNo));
		brandQuery.setPageSize(30);
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andIsShowEqualTo(true);
		if (null != brandName) {
			createCriteria.andBrandNameLike("%" + brandName + "%");
			sb.append("branName=").append(brandName);
		}
		String url = "/product/brandList";
		Pagination pagination = new Pagination(brandQuery.getPageNo(), brandQuery.getPageSize(),
				brandDao.countByExample(brandQuery), brandDao.selectByExample(brandQuery));
		pagination.pageView(url, sb.toString());
		return pagination;
	}

	// PC首页品牌
	@Override
	public List<Brand> selectForPC() {
		List<Brand> brands = brandDao.selectAll();
		return brands;
	}

}
