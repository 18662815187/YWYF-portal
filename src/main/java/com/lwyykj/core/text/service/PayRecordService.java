package com.lwyykj.core.text.service;

import cn.itcast.common.page.Pagination;

public interface PayRecordService {
	//账单列表
	Pagination selectByPagination(Integer pageNo,Integer uid);
}
