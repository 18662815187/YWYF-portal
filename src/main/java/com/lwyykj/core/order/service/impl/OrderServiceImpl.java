package com.lwyykj.core.order.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lwyykj.common.Constants;
import com.lwyykj.core.bean.order.Order;
import com.lwyykj.core.bean.order.OrderProduct;
import com.lwyykj.core.bean.order.OrderQuery;
import com.lwyykj.core.bean.order.OrderQuery.Criteria;
import com.lwyykj.core.bean.order.Refund;
import com.lwyykj.core.bean.order.RefundQuery;
import com.lwyykj.core.bean.product.Product;
import com.lwyykj.core.bean.product.Sku;
import com.lwyykj.core.bean.shop.OrderUtil;
import com.lwyykj.core.bean.text.MailFee;
import com.lwyykj.core.bean.user.MailList;
import com.lwyykj.core.dao.order.OrderDao;
import com.lwyykj.core.dao.order.OrderProductDao;
import com.lwyykj.core.dao.order.RefundDao;
import com.lwyykj.core.dao.product.ProductDao;
import com.lwyykj.core.dao.product.SkuDao;
import com.lwyykj.core.dao.text.MailFeeDao;
import com.lwyykj.core.dao.user.MailListDao;
import com.lwyykj.core.order.service.OrderService;
import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 2018.5.10 订单服务
 *
 */

@Service("/orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao;
	@Resource
	private OrderProductDao orderProductDao;
	@Resource
	private SkuDao skuDao;
	@Resource
	private ProductDao productDao;
	@Resource
	private MailListDao mailListDao;
	@Resource
	private MailFeeDao mailFeeDao;
	@Resource
	private RefundDao refundDao;

	// 提交订单
	@Override
	public OrderUtil applyOrder(Integer skuId, Integer docId, Integer amount, Integer orderType, Integer preId,
			Integer sendId, Integer uid) {
		OrderUtil orderUtil = new OrderUtil();
		Order order = new Order();
		OrderProduct orderProduct = new OrderProduct();
		// 生成订单号拼接uid
		String orderNum = uid + Constants.getOrderNum();
		// 生成支付流水号
		// String payNum = uid + Constants.getOrderNum();
		Product product = null;
		Integer now = (int) (new Date().getTime() / 1000);
		Double totalFee = 0.00;
		if (null != sendId && sendId > 0 && !"undefined".equals(sendId)) {
			MailList mailList = mailListDao.selectByPrimaryKey(sendId);
			if (null != orderType && !"".equals(orderType) && orderType == 0) {
				// 立即购买的订单
				Sku sku = skuDao.selectByPrimaryKey(skuId);
				if (null != sku && sku.getProId() > 0 && null != sku.getProId()) {
					if (amount > sku.getStock()) {
						orderUtil.setMsg("库存不足!");
						orderUtil.setStatus(103);
					} else {
						Double totalFee1 = sku.getPrice() * amount;
						product = productDao.selectByPrimaryKey(sku.getProId());
						if (null != product) {
							order.setStoreId(product.getPhId());
							orderUtil.setProName(product.getName());
							if (product.getWhetherFee()) {
								totalFee = totalFee1;
							} else {
								List<MailFee> mailFees = mailFeeDao.selectByPhId(product.getPhId());
								if (null != mailFees && mailFees.size() > 0) {
									MailFee mailFee = mailFees.get(0);
									if (mailFee.getTopUp() > 0.00 && totalFee1 >= mailFee.getTopUp()) {
										totalFee = totalFee1;
									} else {
										totalFee = totalFee1 + mailFee.getMoney();
									}
								} else {
									totalFee = totalFee1;
								}
							}
							// order.setPayNum(payNum);
							order.setAddtime(now);
							order.setSendId(sendId);
							order.setUid(uid);
							order.setOrderNum(orderNum);
							order.setOrderStatus(0);
							order.setIsDel(false);
							order.setTotalfee(totalFee);
							order.setPrescriptionId(preId);
							int a = orderDao.insertSelective(order);
							sku.setStock(sku.getStock() - amount);
							int c = skuDao.updateByPrimaryKeySelective(sku);
							if (a > 0 && c > 0) {
								orderUtil.setOid(order.getId());
								orderProduct.setDocId(docId);
								orderProduct.setAddtime(now);
								orderProduct.setOid(order.getId());
								orderProduct.setIsDel(false);
								orderProduct.setIsOnline(true);
								orderProduct.setPreId(preId);
								orderProduct.setPrice(sku.getPrice());
								orderProduct.setNum(amount);
								orderProduct.setRefundStatus(0);
								orderProduct.setSkuid(skuId);
								Integer b = orderProductDao.insertSelective(orderProduct);
								if (b > 0) {
									// 成功
									orderUtil.setStatus(100);
									orderUtil.setMsg("订单生成成功!");
									orderUtil.setTotalFee(totalFee);
									orderUtil.setOrderNum(orderNum);
									orderUtil.setMailList(mailList);
								} else {
									orderUtil.setMsg("订单详情生成失败!");
									orderUtil.setStatus(102);
								}
							} else {
								orderUtil.setMsg("主订单生成失败或订单异常!");
								orderUtil.setStatus(101);
							}

						} else {
							orderUtil.setMsg("此产品占不支持销售!");
							orderUtil.setStatus(104);
						}

					}

				}

			} else {
				// 购物车提交的订单,这里不会走，购物车生成订单分出去了
			}
		} else {
			orderUtil.setMsg("你还未选择或者添加收货地址!");
			orderUtil.setStatus(107);
		}

		return orderUtil;
	}

	// 根据uid查询订单，用于个人中心查询三个
	@Override
	public List<Order> selectByUid(Integer uid, Integer pageSize) {
		OrderQuery orderQuery = new OrderQuery();
		Criteria createCriteria = orderQuery.createCriteria();
		orderQuery.setOrderByClause("id desc");
		orderQuery.setPageNo(1);
		orderQuery.setPageSize(pageSize);
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andUidEqualTo(uid);
		List<Order> orders = orderDao.selectByExample(orderQuery);
		for (Order order : orders) {
			OrderProduct orderProduct = orderProductDao.selectByOid(order.getId()).get(0);
			Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
			Product product = productDao.selectByPrimaryKey(sku.getProId());
			sku.setProduct(product);
			orderProduct.setSku(sku);
			order.setOrderProduct(orderProduct);
		}
		return orders;
	}

	// 带分页订单管理
	@Override
	public Pagination selectByPagination(Integer pageNo, Integer uid, Integer type) {
		StringBuilder params = new StringBuilder();
		OrderQuery orderQuery = new OrderQuery();
		Criteria createCriteria = orderQuery.createCriteria();
		orderQuery.setPageNo(Pagination.cpn(pageNo));
		orderQuery.setPageSize(10);
		orderQuery.setOrderByClause("id desc");
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andUidEqualTo(uid);
		if (null != type) {
			createCriteria.andOrderStatusEqualTo(type);
			params.append("type=").append(type);
		}
		List<Order> orders = orderDao.selectByExample(orderQuery);
		for (Order order : orders) {
			List<OrderProduct> orderProducts = orderProductDao.selectByOid(order.getId());
			Double total = 0d;
			for (OrderProduct orderProduct : orderProducts) {
				Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
				Product product = productDao.selectByPrimaryKey(sku.getProId());
				sku.setProduct(product);
				orderProduct.setSku(sku);
				total += sku.getPrice() * orderProduct.getNum();
				int refundNum = refundDao.countByOpid(orderProduct.getId());
				orderProduct.setReNum(refundNum);
				// System.out.println(refundNum);
			}
			order.setOrderProducts(orderProducts);
			// System.out.println(orderProducts.size());
			// 用于列表显示的运费
			List<MailFee> mailFees = mailFeeDao.selectByPhId(order.getStoreId());
			if (null != mailFees && mailFees.size() > 0) {
				MailFee mailFee = mailFees.get(0);
				if (mailFee.getTopUp() > 0.00 && total >= mailFee.getTopUp()) {
					order.setMailFee(0d);
				} else {
					order.setMailFee(mailFee.getMoney());
				}
			} else {
				order.setMailFee(0d);
			}
		}
		String url = "/order/orderList";
		Pagination pagination = new Pagination(orderQuery.getPageNo(), orderQuery.getPageSize(),
				orderDao.countByExample(orderQuery), orders);
		pagination.pageView(url, params.toString());
		return pagination;
	}

	// 通过统一支付流水号查询
	@Override
	public List<Order> selectByPayNum(String payNum) {
		OrderQuery orderQuery = new OrderQuery();
		Criteria createCriteria = orderQuery.createCriteria();
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andPayNumEqualTo(payNum);
		List<Order> orders = orderDao.selectByExample(orderQuery);
		if (null != orders && orders.size() > 0) {
			return orders;
		} else {
			return null;
		}
	}

	// 订单管理待付款立即支付
	@Override
	public OrderUtil orderToPay(Integer oid, Integer uid) {
		Order order = orderDao.selectByPrimaryKey(oid);
		List<String> pNames = new ArrayList<>();
		OrderUtil orderUtil = new OrderUtil();
		MailList mailList = new MailList();
		Double total = 0d;
		String orderNum = "";
		if (null != order) {
			List<OrderProduct> orderProducts = orderProductDao.selectByOid(order.getId());
			if (null != orderProducts && orderProducts.size() > 0) {
				for (OrderProduct orderProduct : orderProducts) {
					pNames.add(
							productDao.selectByPrimaryKey(skuDao.selectByPrimaryKey(orderProduct.getSkuid()).getProId())
									.getName());
				}
			}
			total = order.getTotalfee();
			mailList = mailListDao.selectByPrimaryKey(order.getSendId());
			orderNum = order.getOrderNum();
		}
		String join = StringUtils.join(pNames.toArray(), ",");
		orderUtil.setTotalFee(total);
		orderUtil.setProName(join);
		orderUtil.setMailList(mailList);
		orderUtil.setOrderNum(orderNum);
		orderUtil.setOid(oid);
		return orderUtil;
	}

	// 删除订单
	@Override
	public int delOrder(Integer oid) {
		if (null != oid && oid > 0) {
			Order order = orderDao.selectByPrimaryKey(oid);
			if (null != order) {
				if (order.getOrderStatus() == 0) {
					List<OrderProduct> orderProducts = orderProductDao.selectByOid(oid);
					for (OrderProduct orderProduct : orderProducts) {
						Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
						sku.setStock(sku.getStock() + orderProduct.getNum());
						skuDao.updateByPrimaryKeySelective(sku);
					}
				}
				order.setIsDel(true);
				return orderDao.updateByPrimaryKeySelective(order);
			} else {
				return 0;
			}

		} else {
			return 0;
		}

	}

	// 确认订单
	@Override
	public int confirm(Integer oid) {
		if (null != oid && oid > 0) {
			Order order = orderDao.selectByPrimaryKey(oid);
			// 交易完成待评价
			order.setOrderStatus(3);
			return orderDao.updateByPrimaryKeySelective(order);
		} else {
			return 0;
		}
	}

	// 统计不同状态订单数量
	@Override
	public int countOrder(Integer uid, Integer type) {
		OrderQuery orderQuery = new OrderQuery();
		Criteria createCriteria = orderQuery.createCriteria();
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andUidEqualTo(uid);
		createCriteria.andOrderStatusEqualTo(type);
		return orderDao.countByExample(orderQuery);
	}

	// 通过oid查询订单
	@Override
	public Order selectByOid(Integer oid) {
		Order order = orderDao.selectByPrimaryKey(oid);
		Double total = 0d;
		if (null != order) {
			MailList maillist = mailListDao.selectByPrimaryKey(order.getSendId());
			List<MailFee> mailFees = mailFeeDao.selectByPhId(order.getStoreId());
			List<OrderProduct> orderProducts = orderProductDao.selectByOid(oid);
			for (OrderProduct orderProduct : orderProducts) {
				total += orderProduct.getNum() * orderProduct.getPrice();
				Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
				sku.setProduct(productDao.selectByPrimaryKey(sku.getProId()));
				orderProduct.setSku(sku);
			}
			if (null != mailFees && mailFees.size() > 0) {
				MailFee mailFee = mailFees.get(0);
				if (mailFee.getTopUp() > 0.00 && total >= mailFee.getTopUp()) {
					order.setMailFee(0d);
				} else {
					order.setMailFee(mailFee.getMoney());
				}
			} else {
				order.setMailFee(0d);
			}
			order.setOrderProducts(orderProducts);
			order.setTotalfee(total);
			order.setMailList(maillist);
		}
		return order;
	}

	// 进退换货页面
	@Override
	public OrderProduct toChange(Integer opId) {
		OrderProduct orderProduct = orderProductDao.selectByPrimaryKey(opId);
		if (null != orderProduct) {
			Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
			Product product = productDao.selectByPrimaryKey(sku.getProId());
			sku.setProduct(product);
			orderProduct.setSku(sku);
		}
		return orderProduct;
	}

	// 保存售后记录
	@Override
	public int saveRefund(Refund refund, Integer uid) {
		int result = 0;
		refund.setUid(uid);
		refund.setOpNum(Constants.getOrderNum());
		refund.setAddtime((int) (new Date().getTime() / 1000));
		int a = refundDao.insertSelective(refund);
		if (a > 0) {
			OrderProduct orderProduct = orderProductDao.selectByPrimaryKey(refund.getOpId());
			orderProduct.setRefundId(refund.getId());
			result = orderProductDao.updateByPrimaryKeySelective(orderProduct);
		}
		return result;
	}

	// 去售后列表
	@Override
	public Pagination selectByPagination(Integer uid, Integer pageNo) {
		StringBuilder params = new StringBuilder();
		RefundQuery refundQuery = new RefundQuery();
		refundQuery.setOrderByClause("id desc");
		refundQuery.setPageNo(Pagination.cpn(pageNo));
		refundQuery.setPageSize(10);
		com.lwyykj.core.bean.order.RefundQuery.Criteria createCriteria = refundQuery.createCriteria();
		createCriteria.andUidEqualTo(uid);
		List<Refund> refunds = refundDao.selectByExample(refundQuery);
		for (Refund refund : refunds) {
			OrderProduct orderProduct = orderProductDao.selectByPrimaryKey(refund.getOpId());
			Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
			sku.setProduct(productDao.selectByPrimaryKey(sku.getProId()));
			orderProduct.setSku(sku);
			refund.setOrderProduct(orderProduct);
		}
		String url = "/order/toChange";
		Pagination pagination = new Pagination(refundQuery.getPageNo(), refundQuery.getPageSize(),
				refundDao.countByExample(refundQuery), refunds);
		pagination.pageView(url, params.toString());
		return pagination;
	}

	// 取消售后
	@Override
	public Integer cancelRefund(Integer rid) {
		if (null != rid && rid > 0) {
			return refundDao.cancel(rid);
		} else {
			return 0;
		}

	}

	// 录入快递单号
	@Override
	public Integer upKdNum(Integer id, String kdNum) {
		if (null != id && id > 0) {
			Refund refund = refundDao.selectByPrimaryKey(id);
			refund.setKdNum(kdNum);
			return refundDao.updateByPrimaryKeySelective(refund);
		} else {
			return 0;
		}

	}

	// 个人中心首页统计售后
	@Override
	public Integer countUserIndex(Integer uid) {
		return refundDao.countByUid(uid);
	}

	// 售后确认完成
	@Override
	public int confirmRefund(Integer rid) {
		Refund refund = refundDao.selectByPrimaryKey(rid);
		refund.setStatus(6);
		return refundDao.updateByPrimaryKeySelective(refund);
	}
	//去评论页
	@Override
	public Order toComm(Integer oid) {
		Order order = orderDao.selectByPrimaryKey(oid);
		Double total=0d;
		if(null!=order){
			List<OrderProduct> ops = orderProductDao.selectByOid(oid);
			if(null!=ops&&ops.size()>0){
				for (OrderProduct orderProduct : ops) {
					Sku sku = skuDao.selectByPrimaryKey(orderProduct.getSkuid());
					Product product = productDao.selectByPrimaryKey(sku.getProId());
					sku.setProduct(product);
					orderProduct.setSku(sku);
					total+=orderProduct.getPrice() * orderProduct.getNum();
				}
			}
			order.setOrderProducts(ops);
			order.setMailFee(order.getTotalfee()-total);
		}
		return order;
	}

}
