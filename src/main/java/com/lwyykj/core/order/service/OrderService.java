package com.lwyykj.core.order.service;


import java.util.List;

import com.lwyykj.core.bean.order.Order;
import com.lwyykj.core.bean.order.OrderProduct;
import com.lwyykj.core.bean.order.Refund;
import com.lwyykj.core.bean.shop.OrderUtil;
import cn.itcast.common.page.Pagination;

public interface OrderService {
	// 生成订单
	OrderUtil applyOrder(Integer skuId, Integer docId, Integer amount, Integer orderType, Integer preId, Integer sendId,
			Integer uid);
	//个人中心订单
	List<Order> selectByUid(Integer uid,Integer pageSize);
	//订单管理带分页
	Pagination selectByPagination(Integer pageNo,Integer uid,Integer type);
	//通过统一支付流水号查询
	List<Order> selectByPayNum(String payNum);
	//订单管理待付款立即支付
	OrderUtil orderToPay(Integer oid,Integer uid);
	//删除订单
	int delOrder(Integer oid);
	//确认收货
	int confirm(Integer oid);
	
	//统计各种状态订单的数量
	int countOrder(Integer uid,Integer type);
	//根据订单ID查询详情
	Order selectByOid(Integer oid);
	
	//进入退换货申请页面
	OrderProduct toChange(Integer opId);
	//保存退换货记录
	int saveRefund(Refund refund,Integer uid);
	//去换货列表
	Pagination selectByPagination(Integer uid,Integer pageNo);
	//取消售后
	Integer cancelRefund(Integer rid);
	//更新快递单号
	Integer upKdNum(Integer id,String kdNum);
	//统计售后单数量用于个人中心首页
	Integer countUserIndex(Integer uid);
	//确认售后完成
	int confirmRefund(Integer rid);
	//去评论页
	Order toComm(Integer oid);
	
}
