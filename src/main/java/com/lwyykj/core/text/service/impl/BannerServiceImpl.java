package com.lwyykj.core.text.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwyykj.common.Constants;
import com.lwyykj.core.bean.text.Banner;
import com.lwyykj.core.bean.text.BannerQuery;
import com.lwyykj.core.bean.text.BannerQuery.Criteria;
import com.lwyykj.core.dao.product.ProductDao;
import com.lwyykj.core.dao.text.BannerDao;
import com.lwyykj.core.text.service.BannerService;

/**
 * 
 * @author yl 2018.4.9 广告位管理
 *
 */

@Service("bannerService")
public class BannerServiceImpl implements BannerService {
	@Resource
	private ProductDao productDao;
	@Resource
	private BannerDao bannerDao;

	// 查询所有
	@Override
	public List<Banner> queryAll(Integer position) {
		String rUrl = "";
		BannerQuery bannerQuery = new BannerQuery();
		bannerQuery.setOrderByClause("id desc");
		Criteria createCriteria = bannerQuery.createCriteria();
		createCriteria.andStatusEqualTo(1);
		if (null != position) {
			createCriteria.andPositionEqualTo(position);
		}
		List<Banner> banners = bannerDao.selectByExample(bannerQuery);
		for (Banner banner : banners) {
			switch (banner.getType()) {
			// 产品
			case 1:
				rUrl = Constants.DOMAIN + "/product/query?id=" + banner.getLinkId();
				banner.setUrl(rUrl);
				break;
			// 医生
			case 2:
				rUrl = Constants.DOMAIN + "/doctor/query?id=" + banner.getLinkId();
				banner.setUrl(rUrl);
				break;
			// 活动
			case 3:
				rUrl = Constants.DOMAIN + "/activity/query?id=" + banner.getLinkId();
				banner.setUrl(rUrl);
				break;
			// 通知
			default:
				rUrl = Constants.DOMAIN + "/text/query?id=" + banner.getLinkId();
				banner.setUrl(rUrl);
				break;
			}
		}
		return banners;
	}

}
