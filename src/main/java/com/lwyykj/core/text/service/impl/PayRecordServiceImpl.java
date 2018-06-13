package com.lwyykj.core.text.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwyykj.core.bean.record.PayRecordQuery;
import com.lwyykj.core.bean.record.PayRecordQuery.Criteria;
import com.lwyykj.core.dao.record.PayRecordDao;
import com.lwyykj.core.text.service.PayRecordService;

import cn.itcast.common.page.Pagination;

@Service("payRecordService")
@Transactional
public class PayRecordServiceImpl implements PayRecordService {
	@Resource
	private PayRecordDao payRecordDao;

	// 账单列表带分页
	@Override
	public Pagination selectByPagination(Integer pageNo, Integer uid) {
		StringBuilder params = new StringBuilder();
		PayRecordQuery payRecordQuery = new PayRecordQuery();
		payRecordQuery.setOrderByClause("id desc");
		payRecordQuery.setPageNo(Pagination.cpn(pageNo));
		payRecordQuery.setPageSize(10);
		Criteria createCriteria = payRecordQuery.createCriteria();
		createCriteria.andUidEqualTo(uid);
		createCriteria.andIsDelEqualTo(false);
		String url = "/user/toBill";
		Pagination pagination = new Pagination(payRecordQuery.getPageNo(), payRecordQuery.getPageSize(),
				payRecordDao.countByExample(payRecordQuery), payRecordDao.selectByExample(payRecordQuery));
		pagination.pageView(url, params.toString());
		return pagination;
	}

}
