package com.lwyykj.core.text.service;

import com.lwyykj.core.bean.text.DisComments;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 评论服务
 *
 */
public interface CommentsService {
	/**
	 * 通过产品ID查询评论,包含好评、中评、差评百分比及个数
	 * 
	 */
	DisComments selectByPid(Integer pid);
	//查询累积评价数量
	int countNums(Integer pid);
	//保存评论内容
	int insertComm(Integer opId,String content,String imgs,Integer evaluation,Integer uid);
	//评论列表
	Pagination selectByPagination(Integer pageNo,Integer uid);
}
