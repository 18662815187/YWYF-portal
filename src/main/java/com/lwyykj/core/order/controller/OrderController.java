package com.lwyykj.core.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lwyykj.common.Constants;
import com.lwyykj.core.bean.order.Order;
import com.lwyykj.core.bean.order.OrderProduct;
import com.lwyykj.core.bean.order.Refund;
import com.lwyykj.core.bean.product.OrderVerfiy;
import com.lwyykj.core.bean.product.Product;
import com.lwyykj.core.bean.shop.OrderUtil;
import com.lwyykj.core.bean.user.MailList;
import com.lwyykj.core.bean.user.UserUtil;
import com.lwyykj.core.order.service.CartInfoService;
import com.lwyykj.core.order.service.OrderService;
import com.lwyykj.core.pay.service.AlipayService;
import com.lwyykj.core.product.service.ProductService;
import com.lwyykj.core.product.service.SkuService;
import com.lwyykj.core.text.service.CommentsService;
import com.lwyykj.core.text.service.ExpressQueryService;
import com.lwyykj.core.user.service.UserService;
import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 2018.5.9 订单确认提交控制器
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource
	private SkuService skuService;
	@Resource
	private UserService userService;
	@Resource
	private OrderService orderService;
	@Resource
	private AlipayService alipayService;
	@Resource
	private ProductService productService;
	@Resource
	private CartInfoService cartInfoService;
	@Resource
	private ExpressQueryService expressQueryService;
	@Resource
	private CommentsService commentsService;

	// 立即购买去订单确认页
	@RequestMapping("/toPay")
	public String toPay(Integer skuId, Integer amount, Integer type, String returnUrl, Integer preId, Integer orderType,
			HttpServletRequest request, Model model, RedirectAttributes rAttributes, String omsg)
			throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != uid && uid > 0) {
			Product product = productService.selectByPid(skuService.selectByPrimary(skuId).getProId());
			if (product.getIsCounter()) {
				if (null != preId) {
					List<MailList> mailLists = userService.selectAllMail(request, type);
					List<OrderVerfiy> orderVerfiys = skuService.orderApply(skuId, amount);
					model.addAttribute("mailLists", mailLists);
					model.addAttribute("orderVerfiys", orderVerfiys);
					model.addAttribute("skuId", skuId);
					model.addAttribute("amount", amount);
					model.addAttribute("preId", preId);
					// 0立即购买进入、1购物车进入
					model.addAttribute("orderType", orderType);
					// 提交订单出问题时携带的信息
					model.addAttribute("omsg", omsg);
					return "/other/pay";
				} else {
					return "redirect:" + returnUrl;
				}
			} else {
				List<MailList> mailLists = userService.selectAllMail(request, type);
				List<OrderVerfiy> orderVerfiys = skuService.orderApply(skuId, amount);
				model.addAttribute("mailLists", mailLists);
				model.addAttribute("orderVerfiys", orderVerfiys);
				model.addAttribute("skuId", skuId);
				model.addAttribute("amount", amount);
				model.addAttribute("preId", preId);
				// 0立即购买进入、1购物车进入
				model.addAttribute("orderType", orderType);
				// 提交订单出问题是携带的信息
				model.addAttribute("omsg", omsg);
				return "/other/pay";
			}
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 确认订单生成订单,需判断库存是否可用
	@RequestMapping("/applyOrder")
	public String applyOrder(Integer skuId, Integer docId, Integer sendId, Integer amount, Integer orderType,
			Integer preId, String returnUrl, HttpServletRequest request, RedirectAttributes rAttributes, Model model) {
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		if (null != uid && uid > 0) {
			OrderUtil orderUtil = orderService.applyOrder(skuId, docId, amount, orderType, preId, sendId, uid);
			switch (orderUtil.getStatus()) {
			case 100:
				// model.addAttribute("totalFee", orderUtil.getTotalFee());
				// model.addAttribute("orderNum", orderUtil.getOrderNum());
				// model.addAttribute("mail", orderUtil.getMailList());
				// model.addAttribute("proName", orderUtil.getProName());
				session.setAttribute("ou", orderUtil);
				rAttributes.addAttribute("type", 0);
				return "redirect:/order/toPayMent";
			case 103:
				rAttributes.addFlashAttribute("omsg", "<span style='color:red'>您购买的部分产品库存不足!</span>");
				return "redirect:" + returnUrl;
			case 107:
				rAttributes.addFlashAttribute("omsg", "<span style='color:red'>您还未选择或者添加收货地址!</span>");
				return "redirect:" + returnUrl;
			default:
				rAttributes.addFlashAttribute("omsg", orderUtil.getMsg());
				return "redirect:" + returnUrl;
			}
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 设置订单确认页收货地址默认地址
	@RequestMapping("/orderDefaultAddr")
	public String orderDefaultAddr(Integer mailId, String returnUrl, HttpServletRequest request,
			RedirectAttributes rAttributes) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (uid > 0) {
			userService.setDefault(mailId, request);
			return "redirect:" + returnUrl;
		} else {
			return "redirect:" + returnUrl;
		}
	}

	// 保存或更新订单确认页新地址
	@RequestMapping("/mailSaveOrUpdate")
	@ResponseBody
	public Object mailSave(MailList mailList, String returnUrl, HttpServletRequest request,
			RedirectAttributes rAttributes) {
		UserUtil userUtil = new UserUtil();
		int result = userService.saveOrUpdateMail(mailList, request);
		switch (result) {
		case 1005:
			userUtil.setStatus(1005);
			userUtil.setMsg("用户未登录，请重新登录!");
			userUtil.setReturnUrl(returnUrl);
			break;
		case 1001:
			userUtil.setMsg("最大只能添加6个收货地址!");
			userUtil.setStatus(1001);
			userUtil.setReturnUrl(returnUrl);
			break;
		case 1000:
			userUtil.setMsg("新增成功!");
			userUtil.setStatus(1000);
			userUtil.setReturnUrl(returnUrl);
			break;
		default:
			userUtil.setStatus(999);
			userUtil.setMsg("更新成功!");
			userUtil.setReturnUrl(returnUrl);
			break;
		}
		return userUtil;
	}

	// 订单确认页删除收货地址
	@RequestMapping("/delAddr")
	public String delAddr(Integer mid, String returnUrl, HttpServletRequest request, RedirectAttributes rAttributes) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			userService.delMailAddr(mid);
			return "redirect:" + returnUrl;
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}
	}

	// 防止选择支付页面多次刷新重复生成订单这里使用session
	@RequestMapping("/toPayMent")
	public String toPayMent(Integer type, Model model, HttpServletRequest request, RedirectAttributes rAttributes,
			String msg) throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int a = cartInfoService.countCart(request);
		model.addAttribute("a", a);
		if (null != uid && uid > 0) {
			OrderUtil orderUtil = (OrderUtil) request.getSession().getAttribute("ou");
			model.addAttribute("orderUtil", orderUtil);
			model.addAttribute("msg", msg);
			if (type == 1) {
				return "/other/payment2";
			} else {
				return "/other/payment";
			}
		} else {
			String url = Constants.DOMAIN + "/order/orderList";
			rAttributes.addAttribute("returnUrl", url);
			return "redirect:/login/toLogin";
		}
	}

	// 发起支付
	@RequestMapping("/startPay")
	public String startPay(Integer oid, HttpServletRequest req, HttpServletResponse res, Integer type,
			RedirectAttributes rAttributes) {
		HttpSession session = req.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		String oids = (String) session.getAttribute("oids");
		if (null != uid && uid > 0) {
			if (null != oid) {
				List<Integer> ooid = new ArrayList<>();
				ooid.add(oid);
				String oids1 = StringUtils.join(ooid.toArray(), ",");
				if (type == 0) {
					rAttributes.addAttribute("oids", oids1);
					return "redirect:/alipay/pagePay";
				} else {
					session.setAttribute("oids", oids1);
					return "redirect:/weixinpay/payWX";
				}
			} else if (null != oids) {
				if (type == 0) {
					rAttributes.addAttribute("oids", oids);
					return "redirect:/alipay/pagePay";
				} else {
					session.setAttribute("oids", oids);
					return "redirect:/weixinpay/payWX";
				}
			} else {
				rAttributes.addAttribute("msg", "订单信息获取异常，请尝试刷新页面或者重新购买!");
				return "redirect:/order/toPayMent";
			}
		} else {
			String url = Constants.DOMAIN + "/user/myOrder";
			rAttributes.addAttribute("returnUrl", url);
			return "redirect:/login/toLogin";
		}

	}

	// 个人中心订单管理
	@RequestMapping("/orderList")
	public String orderList(Integer pageNo, Integer type, String returnUrl, HttpServletRequest request, Model model,
			RedirectAttributes rAttributes) throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			int countCart = cartInfoService.countCart(request);
			model.addAttribute("countCart", countCart);
			Pagination pagination = orderService.selectByPagination(pageNo, uid, type);
			model.addAttribute("pagination", pagination);
			model.addAttribute("type", type);
			return "/person/order";
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}
	}

	// 微信支付订单状态查询
	@RequestMapping("/queryStatus")
	@ResponseBody
	public Map<String, Object> queryStatus(String payNum) {
		Map<String, Object> map = new HashMap<>();
		List<Order> orders = orderService.selectByPayNum(payNum);
		if (null != orders && orders.size() > 0) {
			map.put("status", orders.get(0).getOrderStatus());
		} else {
			map.put("status", -1);
			map.put("msg", "订单信息获取失败!");
		}
		return map;

	}

	// 订单管理页面头
	@RequestMapping("/orderI")
	public String orderI(Model model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		return "/person/order_i";
	}

	// 订单物流查询
	@RequestMapping("/expressQuery")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object expressQuery(String number) {
		String result = expressQueryService.query(number);
		Object parse = JSON.parse(result);
		return parse;
	}

	// 订单详情页
	@RequestMapping("/orderInfo")
	public String orderInfo(Integer oid, HttpServletRequest request, Model model) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			Order order = orderService.selectByOid(oid);
			model.addAttribute("order", order);
			return "/person/orderinfo";
		} else {
			return "redirect:/login/toLogin";
		}

	}

	// 个人中心订单管理测试用，用完可删
	@RequestMapping("/orderList1")
	@ResponseBody
	public Object orderList1(Integer pageNo, Integer type, String returnUrl, Integer uid, Model model,
			RedirectAttributes rAttributes) {
		// Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			Pagination pagination = orderService.selectByPagination(pageNo, uid, type);
			return pagination;
		} else {
			return null;
		}
	}

	// 订单管理未付款订单立即支付
	@RequestMapping("/orderToPayment")
	public String orderToPayment(Integer oid, String returnUrl, Model model, String msg, HttpServletRequest request,
			RedirectAttributes rAttributes) throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int a = cartInfoService.countCart(request);
		model.addAttribute("a", a);
		if (null != uid && uid > 0) {
			OrderUtil orderUtil = orderService.orderToPay(oid, uid);
			model.addAttribute("orderUtil", orderUtil);
			model.addAttribute("msg", msg);
			return "/other/payment";
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 删除订单
	@RequestMapping("/delOrder")
	public String delOrder(Integer oid) {
		orderService.delOrder(oid);
		return "redirect:/order/orderList";
	}

	// 确认收货
	@RequestMapping("/Confirm")
	public String Confirm(Integer oid) {
		orderService.confirm(oid);
		return "redirect:/order/orderList";
	}

	// 去退换货详情页面
	@RequestMapping("/toChange")
	public String toChange(HttpServletRequest request, Integer pageNo, String returnUrl, RedirectAttributes rAttributes,
			Model model) throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != uid) {
			Pagination pagination = orderService.selectByPagination(uid, pageNo);
			model.addAttribute("pagination", pagination);
			return "/person/change";
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}
	}

	// 去退换货操作页面
	@RequestMapping("/toRefund")
	public String toRefund(Integer opId, Model model,HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		if (null != opId && opId > 0) {
			int countCart = cartInfoService.countCart(request);
			model.addAttribute("countCart", countCart);
			OrderProduct orderProduct = orderService.toChange(opId);
			model.addAttribute("orderProduct", orderProduct);
		}
		return "/person/refund";
	}

	// 提交售后申请
	@RequestMapping("/applyRefund")
	@ResponseBody
	public Map<String, Object> applyRefund(Refund refund, HttpServletRequest request) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		Map<String, Object> map = new HashMap<>();
		if (null != uid && uid > 0) {
			int result = orderService.saveRefund(refund, uid);
			if (result > 0) {
				map.put("status", 1);
			} else {
				map.put("status", -1);
				map.put("msg", "保存失败!");
			}
		} else {
			map.put("status", -2);
			map.put("msg", "您还未登录!");
		}
		return map;
	}

	// 取消售后申请
	@RequestMapping("/cancel")
	public String cancel(Integer rid) {
		orderService.cancelRefund(rid);
		return "redirect:/order/toChange";
	}

	// 填写快递单号
	@RequestMapping("/upKdNum")
	public String upKdNum(Integer id, String kdNum) {
		orderService.upKdNum(id, kdNum);
		return "redirect:/order/toChange";
	}

	// 确认售后问题
	@RequestMapping("/confirmRefund")
	public String confirmRefund(Integer rid) {
		orderService.confirmRefund(rid);
		return "redirect:/order/toChange";
	}

	// 去评价页面
	@RequestMapping("/toComm")
	public String toComm(HttpServletRequest request, Integer oid, String returnUrl, RedirectAttributes rAttributes,
			Model model) throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			int countCart = cartInfoService.countCart(request);
			model.addAttribute("countCart", countCart);
			Order order = orderService.toComm(oid);
			model.addAttribute("order", order);
			return "/person/comm";
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 提交评价
	@RequestMapping("/applyComm")
	@ResponseBody
	public Map<String, Object> applyComm(Integer opId, String content, String imgs, Integer evaluation,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
//		System.out.println(opId+"--------"+content+"------"+imgs+"-----" +evaluation);
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			int result = commentsService.insertComm(opId, content, imgs, evaluation, uid);
			if(result>0){
				map.put("status", 1);
			}else{
				map.put("msg", "评论失败!");
				map.put("status", 2);
			}
		}else{
			map.put("msg", "请先登录!");
			map.put("status", -1);
		}
		return map;
	}
}
