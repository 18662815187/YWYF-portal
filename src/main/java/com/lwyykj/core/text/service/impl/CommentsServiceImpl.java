package com.lwyykj.core.text.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwyykj.core.bean.order.Order;
import com.lwyykj.core.bean.order.OrderProduct;
import com.lwyykj.core.bean.text.Comments;
import com.lwyykj.core.bean.text.CommentsQuery;
import com.lwyykj.core.bean.text.CommentsQuery.Criteria;
import com.lwyykj.core.bean.text.DisComments;
import com.lwyykj.core.dao.order.OrderDao;
import com.lwyykj.core.dao.order.OrderProductDao;
import com.lwyykj.core.dao.product.ProductDao;
import com.lwyykj.core.dao.product.SkuDao;
import com.lwyykj.core.dao.text.CommentsDao;
import com.lwyykj.core.dao.user.UserDao;
import com.lwyykj.core.text.service.CommentsService;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 2018.4.19 评论服务，充分利用临时pojo
 *
 */
@Service("commentsService")
@Transactional
public class CommentsServiceImpl implements CommentsService {
	@Resource
	private CommentsDao commentsDao;
	@Resource
	private UserDao userDao;
	@Resource
	private OrderProductDao orderProductDao;
	@Resource
	private SkuDao skuDao;
	@Resource
	private OrderDao orderDao;
	@Resource
	private ProductDao productDao;

	/**
	 * 产品详细页内的评论，返回的是临时组装pojo类型
	 */
	@Override
	public DisComments selectByPid(Integer pid) {
		DisComments disComments = new DisComments();
		List<Comments> comments = commentsDao.countAllCom(pid);
		for (Comments comments2 : comments) {
			comments2.setUser(userDao.selectById(comments2.getUid()));
		}
		int countAll = commentsDao.countAll(pid);
		int countGood = commentsDao.countGood(pid);
		int countMid = commentsDao.countMid(pid);
		int countLow = commentsDao.countLow(pid);
		disComments.setComments(comments);
		disComments.setAllComments(countAll);
		disComments.setGood(countGood);
		disComments.setMid(countMid);
		disComments.setLow(countLow);
		if (countAll == 0) {
			disComments.setAccountGood(0);
			disComments.setAccountLow(0);
			disComments.setAccountMid(0);
		} else {
			disComments.setAccountGood((countGood / countAll) * 100);
			disComments.setAccountMid((countMid / countAll) * 100);
			disComments.setAccountLow((countLow / countAll) * 100);
		}
		return disComments;
	}

	// 通过商品ID查询评论数量
	@Override
	public int countNums(Integer pid) {
		CommentsQuery commentsQuery = new CommentsQuery();
		Criteria createCriteria = commentsQuery.createCriteria();
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andPidEqualTo(pid);
		return commentsDao.countByExample(commentsQuery);
	}

	// 提交评论
	@Override
	public int insertComm(Integer opId, String content, String imgs, Integer evaluation, Integer uid) {
		Comments comments = new Comments();
		Integer result = 0;
		Boolean flag = false;
		OrderProduct orderProduct = orderProductDao.selectByPrimaryKey(opId);
		Integer pid = skuDao.selectByPrimaryKey(orderProduct.getSkuid()).getProId();
		comments.setAddtime((int) (new Date().getTime() / 1000));
		comments.setContent(content);
		comments.setGreade(evaluation);
		comments.setPics(imgs);
		comments.setIsDel(false);
		comments.setUid(uid);
		comments.setPid(pid);
		result = commentsDao.insertSelective(comments);
		if (result > 0) {
			orderProduct.setIsOnline(true);
			orderProductDao.updateByPrimaryKeySelective(orderProduct);
		}
		// 查询所有小单遍历，如果有未评论的改变标签为true并且停止循环
		List<OrderProduct> orderProducts = orderProductDao.selectByOid(orderProduct.getOid());
		if (null != orderProducts && orderProducts.size() > 0) {
			for (OrderProduct orderProduct2 : orderProducts) {
				if (!orderProduct2.getIsOnline()) {
					flag = true;
					break;
				}
			}
		}
		// 如果所有小单都已评论则改变大单状态到完成并评论
		if (!flag) {
			Order order = orderDao.selectByPrimaryKey(orderProduct.getOid());
			order.setOrderStatus(5);
			orderDao.updateByPrimaryKeySelective(order);
		}
		return result;
	}

	// 评论列表
	@Override
	public Pagination selectByPagination(Integer pageNo, Integer uid) {
		CommentsQuery commentsQuery = new CommentsQuery();
		commentsQuery.setOrderByClause("id desc");
		commentsQuery.setPageNo(Pagination.cpn(pageNo));
		commentsQuery.setPageSize(10);
		Criteria createCriteria = commentsQuery.createCriteria();
		createCriteria.andUidEqualTo(uid);
		createCriteria.andIsDelEqualTo(false);
		List<Comments> comments = commentsDao.selectByExample(commentsQuery);
		if (null != comments && comments.size() > 0) {
			for (Comments comments2 : comments) {
				comments2.setProduct(productDao.selectByPrimaryKey(comments2.getPid()));
			}
		}
		StringBuilder params = new StringBuilder();
		String url = "/user/commList";
		Pagination pagination = new Pagination(commentsQuery.getPageNo(), commentsQuery.getPageSize(),
				commentsDao.countByExample(commentsQuery), comments);
		pagination.pageView(url, params.toString());
		return pagination;
	}

}
