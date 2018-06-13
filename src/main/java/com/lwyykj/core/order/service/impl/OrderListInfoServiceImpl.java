package com.lwyykj.core.order.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lwyykj.core.bean.shop.OrderListInfo;
import com.lwyykj.core.bean.shop.OrderListInfoQuery;
import com.lwyykj.core.bean.shop.OrderListInfoQuery.Criteria;
import com.lwyykj.core.dao.shop.OrderListInfoDao;
import com.lwyykj.core.order.service.OrderListInfoService;

import cn.itcast.common.page.Pagination;

@Service("/orderListService")
@Transactional
public class OrderListInfoServiceImpl implements OrderListInfoService {
	@Resource
	private OrderListInfoDao orderListInfoDao;

	// 个人中心首页订单
	@Override
	public List<OrderListInfo> selectOrderList(Integer uid, Integer pageSize) {
		OrderListInfoQuery orderListInfoQuery = new OrderListInfoQuery();
		Criteria createCriteria = orderListInfoQuery.createCriteria();
		orderListInfoQuery.setPageNo(1);
		orderListInfoQuery.setOrderByClause("addtime desc");
		orderListInfoQuery.setPageSize(pageSize);
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andUidEqualTo(uid);
		return orderListInfoDao.selectByExample(orderListInfoQuery);
	}

	// 订单管理列表带分页
	@Override
	public Pagination selectByPagination(Integer pageNo, Integer uid) {
		StringBuilder params = new StringBuilder();
		OrderListInfoQuery orderListInfoQuery = new OrderListInfoQuery();
		Criteria createCriteria = orderListInfoQuery.createCriteria();
		orderListInfoQuery.setOrderByClause("addtime desc");
		orderListInfoQuery.setPageNo(Pagination.cpn(pageNo));
		orderListInfoQuery.setPageSize(20);
		createCriteria.andUidEqualTo(uid);
		String url = "/orderlist/list.do";
		Pagination pagination = new Pagination(orderListInfoQuery.getPageNo(), orderListInfoQuery.getPageSize(),
				orderListInfoDao.countByExample(orderListInfoQuery),
				orderListInfoDao.selectByExample(orderListInfoQuery));
		pagination.pageView(url, params.toString());
		return pagination;
	}

}
