package com.lwyykj.core.text.service;

import java.util.List;

import com.lwyykj.core.bean.text.Banner;

public interface BannerService {
	//根据位置ID查询所有广告
	List<Banner> queryAll(Integer position);
}
