package com.lwyykj.core.product.service;

import java.util.List;

import com.lwyykj.core.bean.product.OrderVerfiy;
import com.lwyykj.core.bean.product.Sku;

public interface SkuService {
	//主键查询
	Sku selectByPrimary(Integer id);
	//订单确认（立即下单）
	List<OrderVerfiy> orderApply(Integer skuId,Integer amount);
	//主键查询带产品对象
	Sku findById(Integer id);
}
