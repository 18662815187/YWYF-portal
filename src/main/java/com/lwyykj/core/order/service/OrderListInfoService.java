package com.lwyykj.core.order.service;

import java.util.List;

import com.lwyykj.core.bean.shop.OrderListInfo;

import cn.itcast.common.page.Pagination;

public interface OrderListInfoService {
	//个人中心首页截取三个订单
	List<OrderListInfo> selectOrderList(Integer uid,Integer pageSize);
	//订单管理列表页
	Pagination selectByPagination(Integer pageNo,Integer uid);
}
