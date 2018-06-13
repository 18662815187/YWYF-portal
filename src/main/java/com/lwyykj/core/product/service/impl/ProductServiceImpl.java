package com.lwyykj.core.product.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwyykj.core.bean.product.Product;
import com.lwyykj.core.bean.product.ProductQuery;
import com.lwyykj.core.bean.product.ProductQuery.Criteria;
import com.lwyykj.core.bean.product.Sku;
import com.lwyykj.core.bean.text.MailFee;
import com.lwyykj.core.dao.factory.FactoryDao;
import com.lwyykj.core.dao.pharmacy.PharmacyDao;
import com.lwyykj.core.dao.product.BrandDao;
import com.lwyykj.core.dao.product.ProductDao;
import com.lwyykj.core.dao.product.SkuDao;
import com.lwyykj.core.dao.text.MailFeeDao;
import com.lwyykj.core.product.service.ProductService;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 2018.4.13 产品服务
 *
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductDao productDao;
	@Resource
	private SkuDao skuDao;
	@Resource
	private BrandDao brandDao;
	@Resource
	private FactoryDao factoryDao;
	@Resource
	private PharmacyDao pharmacyDao;
	@Resource
	private MailFeeDao mailFeeDao;

	@Override
	public Pagination selectByPagination(Integer pageNo, String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	// 首页搜索联想用
	@Override
	public List<Product> findAllName(String keywords) {
		ProductQuery productQuery = new ProductQuery();
		productQuery.setFields("name");
		productQuery.setPageNo(1);
		productQuery.setPageSize(10);
		Criteria createCriteria = productQuery.createCriteria();
		if (null != keywords) {
			createCriteria.andNameLike("%" + keywords + "%");
		}
		return productDao.selectByExample(productQuery);
	}

	// 商品内页
	@Override
	public Product selectByPrimaryKey(Integer id, HttpServletRequest request) {
		String referer = request.getHeader("referer");
		Product product = productDao.selectByPrimaryKey(id);
		if (null != product) {
			// 设置主体产品厂家和商家名字
			product.setFac_name(factoryDao.selectByPrimaryKey(product.getFacId()).getName());
			product.setPh_name(pharmacyDao.selectByPrimaryKey(product.getPhId()).getPharmacyName());
			if (referer == null || referer == "") {
				int disId = product.getDiseaseId();
				List<Sku> skus = skuDao.selectByPid(id);
				ProductQuery productQuery = new ProductQuery();
				productQuery.setFields("id,pic,name");
				Criteria createCriteria = productQuery.createCriteria();
				createCriteria.andIsDelEqualTo(false);
				createCriteria.andIsShowEqualTo(true);
				if (disId > 0) {
					createCriteria.andDiseaseIdEqualTo(disId);
				}
				// 查询同类产品作为该产品的内置对象
				List<Product> products = productDao.selectByExample(productQuery);
				for (Product product2 : products) {
					if (skuDao.selectByPid(product2.getId()).size() > 0
							&& null != skuDao.selectByPid(product2.getId())) {
						product2.setPrice(skuDao.selectByPid(product2.getId()).get(0).getPrice());
					}
					List<MailFee> mails = mailFeeDao.selectByPhId(product2.getPhId());
					if (null != mails && mails.size() > 0) {
						product2.setMailFee(mails.get(0));
					}
				}
				product.setSkus(skus);
				product.setProducts(products);
				return product;
			} else {
				// 点击数加1
				product.setClickNum(product.getClickNum() + 1);
				productDao.updateByPrimaryKeySelective(product);
				int disId = product.getDiseaseId();
				List<Sku> skus = skuDao.selectByPid(id);
				ProductQuery productQuery = new ProductQuery();
				productQuery.setOrderByClause("id desc");
				productQuery.setFields("id,pic,name");
				productQuery.setPageNo(1);
				productQuery.setPageSize(6);
				Criteria createCriteria = productQuery.createCriteria();
				createCriteria.andIsDelEqualTo(false);
				createCriteria.andIsShowEqualTo(true);
				if (disId > 0) {
					createCriteria.andDiseaseIdEqualTo(disId);
				}
				List<Product> products = productDao.selectByExample(productQuery);
				for (Product product2 : products) {
					if (skuDao.selectByPid(product2.getId()).size() > 0
							&& null != skuDao.selectByPid(product2.getId())) {
						product2.setPrice(skuDao.selectByPid(product2.getId()).get(0).getPrice());
					}
				}
				product.setSkus(skus);
				product.setProducts(products);
				return product;
			}

		}
		return null;
	}
	//主键查询
	@Override
	public Product selectByPid(Integer pid){
		return productDao.findByPrimary(pid);
	}
}
