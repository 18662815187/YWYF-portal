package com.lwyykj.core.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lwyykj.common.EncodePassword;
import com.lwyykj.core.bean.order.Order;
import com.lwyykj.core.bean.text.Banner;
import com.lwyykj.core.bean.text.PreInfo;
import com.lwyykj.core.bean.text.PreUtil;
import com.lwyykj.core.bean.user.MailList;
import com.lwyykj.core.bean.user.Msg;
import com.lwyykj.core.bean.user.User;
import com.lwyykj.core.bean.user.UserUtil;
import com.lwyykj.core.order.service.CartInfoService;
import com.lwyykj.core.order.service.OrderService;
import com.lwyykj.core.text.service.BannerService;
import com.lwyykj.core.text.service.CommentsService;
import com.lwyykj.core.text.service.PayRecordService;
import com.lwyykj.core.text.service.PreInfoService;
import com.lwyykj.core.user.service.MsgService;
import com.lwyykj.core.user.service.UserService;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 2018.4.9 用户控制器
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private BannerService bannerService;
	@Resource
	private PreInfoService preInfoService;
	@Resource
	private OrderService orderService;
	@Resource
	private MsgService msgService;
	@Resource
	private CartInfoService cartInfoService;
	@Resource
	private PayRecordService payRecordService;
	@Resource
	private CommentsService commentsService;

	// 用户中心
	@RequestMapping("/userCenter")
	public String userCenter(HttpServletRequest request, Model model, RedirectAttributes rAttributes)
			throws JsonParseException, JsonMappingException, IOException {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("uid");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != id && id > 0) {
			int msgNum = msgService.counMsg(id);
			model.addAttribute("msgNum", msgNum);
			List<Order> orders = orderService.selectByUid(id, 3);
			User user = userService.selectByPrimary(id);
			List<Banner> banners = bannerService.queryAll(13);
			// 待付款
			int a = orderService.countOrder(id, 0);
			model.addAttribute("a", a);
			// 待发货
			int b = orderService.countOrder(id, 1);
			model.addAttribute("b", b);
			// 待收货
			int c = orderService.countOrder(id, 2);
			model.addAttribute("c", c);
			// 待评价
			int d = orderService.countOrder(id, 5);
			model.addAttribute("d", d);
			// 有售后
			int e = orderService.countUserIndex(id);
			model.addAttribute("e", e);
			model.addAttribute("orders", orders);
			model.addAttribute("banners", banners);
			// 使用session存储便于个人中心其他页面提取数据不操作数据库
			session.setAttribute("user", user);
			return "/person/index";
		} else {
			model.addAttribute("msg", "用户id不能为空,请重新登录!");
			String returnUrl = "/user/userCenter";
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 个人信息
	@RequestMapping("/info")
	public String info(HttpServletRequest request, RedirectAttributes rAttributes, Model model)
			throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != uid && uid > 0) {
			return "/person/information";
		} else {
			String returnUrl = "/user/info";
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 提交修改
	@RequestMapping("/apply")
	public String apply(String nickname, Integer sex, String pic, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User user = userService.updateByPrimary(nickname, sex, pic, request);
		if (null != user) {
			session.setAttribute("user", user);
		} else {
			model.addAttribute("msg", "更新失败!");
		}
		return "redirect:/user/info";
	}

	// 收货地址管理
	@RequestMapping("/mailList")
	public String mail(HttpServletRequest request, Model model, String msg, RedirectAttributes rAttributes)
			throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != uid && uid > 0) {
			List<MailList> mailLists = userService.selectAllMail(request, 0);
			model.addAttribute("mails", mailLists);
			model.addAttribute("msg", msg);
			return "/person/address";
		} else {
			String returnUrl = "/user/mailList";
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 提交新地址、更新地址
	@RequestMapping("/mailSOU")
	public String mailSOU(MailList mailList, HttpServletRequest request, Model model, RedirectAttributes rAttributes) {
		int result = userService.saveOrUpdateMail(mailList, request);
		switch (result) {
		case 1001:
			rAttributes.addAttribute("msg", "最多只能添加6个地址!");
			return "redirect:/user/mailList";
		case 0:
			rAttributes.addAttribute("msg", "更新失败!");
			return "redirect:/user/mailList";
		case 1005:
			String returnUrl = "/user/mailList";
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		default:
			return "redirect:/user/mailList";
		}

	}

	// 设置默认地址
	@RequestMapping("/setDefault")
	public String defaultMail(Integer mailId, HttpServletRequest request, RedirectAttributes rAttributes) {
		int result = userService.setDefault(mailId, request);
		switch (result) {
		case 10000:
			return "redirect:/user/mailList";
		case 10001:
			String returnUrl = "/user/mailList";
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		default:
			rAttributes.addAttribute("msg", "更新失败!");
			return "redirect:/user/mailList";
		}
	}

	// 提交处方
	@RequestMapping("/preApply")
	@ResponseBody
	public PreUtil preApply(PreInfo preInfo, HttpServletRequest request) {
		// System.out.println(preInfo.getDisContent());
		PreUtil preUtil = preInfoService.insertPre(preInfo, request);
		return preUtil;
	}

	// 去忘记密码页
	@RequestMapping("/toModifyPwd")
	public String toModifyPwd() {
		return "/other/forget_password";
	}

	// 提交修改密码
	@RequestMapping("/czPwdApply")
	public String czPwdApply(String tel, String pwd, String pwd1, String code, String token, Model model) {
		// System.out.println(tel);
		UserUtil userUtil = userService.czPwd(tel, pwd, pwd1, code, token);
		switch (userUtil.getStatus()) {
		case 10000:
			return "redirect:/login/toLogin";

		default:
			model.addAttribute("msg", userUtil.getMsg());
			model.addAttribute("tel", tel);
			return "/other/forget_password";
		}

	}

	// 删除收货地址
	@RequestMapping("/delMailAddr")
	public String delMailAddr(Integer mid, String returnUrl, HttpServletRequest request,
			RedirectAttributes rAttributes) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			userService.delMailAddr(mid);
			return "redirect:" + returnUrl;
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 消息通知
	@RequestMapping("/msgList")
	public String msgList(HttpServletRequest request, String returnUrl, Model model, RedirectAttributes rAttributes)
			throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != uid && uid > 0) {
			List<Msg> msgs = msgService.selectAll(uid);
			model.addAttribute("msgs", msgs);
			return "/person/news";
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 修改消息已读状态
	@RequestMapping("/modifyMsgStatus")
	@ResponseBody
	public Map<String, Object> msgStatus(Integer msgId) {
		Map<String, Object> map = new HashMap<>();
		if (null != msgId && msgId > 0) {
			int result = msgService.msgStatus(msgId);
			if (result > 0) {
				map.put("status", 1);
				map.put("msg", "修改成功!");
			} else {
				map.put("status", 0);
				map.put("msg", "修改失败!");
			}
		} else {
			map.put("status", -1);
			map.put("msg", "获取消息ID失败!");
		}

		return map;
	}

	// 删除信息
	@RequestMapping("/delMsg")
	public String delMsg(Integer msgId) {
		userService.delMsgById(msgId);
		return "redirect:/user/msgList";
	}

	// 去安全设置页面
	@RequestMapping("/toSafety")
	public String toSafety(HttpServletRequest request, RedirectAttributes rAttributes, Model model)
			throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != uid && uid > 0) {
			return "/person/safety";
		} else {
			String returnUrl = "/user/mailList";
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 去修改登录密码页
	@RequestMapping("/toCzPwd")
	public String toCzPwd(HttpServletRequest request, RedirectAttributes rAttributes, Model model)
			throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			int countCart = cartInfoService.countCart(request);
			model.addAttribute("countCart", countCart);
			return "/person/password";
		} else {
			String returnUrl = "/user/mailList";
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 去修改手机号码页
	@RequestMapping("/toCzTel")
	public String toCzTel(HttpServletRequest request, RedirectAttributes rAttributes, Model model)
			throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != uid && uid > 0) {
			return "/person/bindphone";
		} else {
			String returnUrl = "/user/mailList";
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}
	}

	// 修改密码
	@RequestMapping("/applyUpPwd")
	@ResponseBody
	public Map<String, Object> applyPwd(HttpServletRequest request, String pwd, String pwd1, String pwd2) {
		Map<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		if (null != uid && uid > 0) {
			User user = userService.selectByUid(uid);
			if (user.getPwd().equals(EncodePassword.encodePassword(pwd))) {
				if (pwd1.equals(pwd2)) {
					int result = userService.upByUid(uid, pwd1);
					if (result > 0) {
						// System.out.println("成功");
						map.put("status", 1);
						session.invalidate();
					} else {
						map.put("status", 3);
						map.put("msg", "修改失败,请重试!");
					}
				} else {
					map.put("status", 2);
					map.put("msg", "两次输入的密码不一致!");
				}
			} else {
				map.put("status", 0);
				map.put("msg", "原密码不正确!");
			}

		} else {
			map.put("msg", "未登录");
			map.put("status", -1);
		}
		return map;
	}

	// 去账单管理页面
	@RequestMapping("/toBill")
	public String toBill(HttpServletRequest request, Integer pageNo, Model model)
			throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			int countCart = cartInfoService.countCart(request);
			model.addAttribute("countCart", countCart);
			Pagination pagination = payRecordService.selectByPagination(pageNo, uid);
			model.addAttribute("pagination", pagination);
			return "/person/billlist";
		} else {
			return "redirect:/login/toLogin";
		}

	}

	// 去评论列表
	@RequestMapping("/commList")
	public String commList(Integer pageNo, HttpServletRequest request, Model model) throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			int countCart = cartInfoService.countCart(request);
			model.addAttribute("countCart", countCart);
			Pagination pagination = commentsService.selectByPagination(pageNo, uid);
			model.addAttribute("pagination", pagination);
			return "/person/comment";
		}else{
			return "redirect:/login/toLogin";
		}
	}
}
