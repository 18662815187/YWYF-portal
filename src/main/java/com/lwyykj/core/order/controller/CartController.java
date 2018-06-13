package com.lwyykj.core.order.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lwyykj.common.Constants;
import com.lwyykj.core.bean.product.DisProduct;
import com.lwyykj.core.bean.product.Sku;
import com.lwyykj.core.bean.shop.OrderUtil;
import com.lwyykj.core.bean.shop.ProShop;
import com.lwyykj.core.bean.user.MailList;
import com.lwyykj.core.order.service.CartInfoService;
import com.lwyykj.core.order.service.CartService;
import com.lwyykj.core.product.service.SkuService;
import com.lwyykj.core.solr.service.SolrService;
import com.lwyykj.core.user.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource
	private CartService cartService;
	@Resource
	private SkuService skuService;
	@Resource
	private SolrService solrService;
	@Resource
	private UserService userService;
	@Resource
	private CartInfoService cartInfoService;

	// 添加到购物车
	@RequestMapping("/addToCart")
	public String addToCart(Integer skuId, Integer amount, Integer preId, String returnUrl, HttpServletRequest request,
			HttpServletResponse response, Model model, RedirectAttributes rAttributes) throws Exception {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (null != uid && uid > 0) {
			rAttributes.addAttribute("skuId", skuId);
			rAttributes.addAttribute("amount", amount);
			cartService.addToCart(skuId, amount, preId, request, response);
			int countCart = cartInfoService.countCart(request);
			model.addAttribute("countCart", countCart);
			return "redirect:/cart/toAddShop";
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 去加入购物车成功页
	@RequestMapping("/toAddShop")
	public String toAddShop(Integer skuId, Integer amount, Model model,HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		Sku sku = skuService.findById(skuId);
		model.addAttribute("sku", sku);
		model.addAttribute("amount", amount);
		if (null != sku) {
			model.addAttribute("pid", sku.getProId());
		}
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		List<DisProduct> disProducts = solrService.queryByTypeId(null, true, 5);
		model.addAttribute("disProducts", disProducts);
		return "/other/add_shop";
	}

	// 去购物车页面
	@RequestMapping("/toCart")
	public String toCart(String returnUrl, HttpServletRequest request, HttpServletResponse response, Model model,
			RedirectAttributes rAttributes) throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != uid && uid > 0) {
			List<ProShop> proShops = cartService.selectFromRedis(uid);
			model.addAttribute("buyerCart", proShops);
			return "/other/shopcart";
		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 修改指定产品数量,每次点加减都要获取此时的数量
	@RequestMapping("/modifyAmount")
	@ResponseBody
	public Map<String, Object> modify(Integer skuId, Integer amount, String returnUrl, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> map = new HashMap<>();
		if (null != skuId) {
			int result = cartService.modify(skuId, amount, request);
			if (result == -1) {
				map.put("status", 101);
				map.put("msg", "用户未登录!");
				map.put("returnUrl", returnUrl);
				map.put("domain", Constants.DOMAIN);
			} else {
				map.put("status", 1);
				map.put("msg", "更新成功!");
			}
		} else {
			map.put("status", 102);
			map.put("msg", "获取规格失败!");
		}
		return map;
	}

	// 单删购物车
	@RequestMapping("/delByIds")
	public String delByIds(Integer[] skuIds, String returnUrl, HttpServletRequest request,
			RedirectAttributes rAttributes) throws JsonParseException, JsonMappingException, IOException {
		int result = cartService.delBySkuId(skuIds, request);
		if (result == -1) {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		} else if (result == -2) {
			// skuids为空
			return "redirect:/cart/toCart";
		} else {
			return "redirect:/cart/toCart";
		}
	}

	// 购物车确认页中间控制器
	@RequestMapping("/cartMid")
	public String cartMid(Integer[] ids, String returnUrl, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		System.out.println(ids);
		session.setAttribute("ids", ids);
		session.setAttribute("returnUrl", returnUrl);
		return "redirect:/cart/toVerfiyPro";
	}

	// 购物车进确认页
	@RequestMapping("/toVerfiyPro")
	public String toVerfiyPro(String omsg, HttpServletRequest request, HttpServletResponse response, Model model,
			RedirectAttributes rAttributes) throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		Integer[] ids = (Integer[]) request.getSession().getAttribute("ids");
		String returnUrl = (String) request.getSession().getAttribute("returnUrl");
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		if (null != uid && uid > 0) {
			OrderUtil orderUtil = cartService.selectBySkuIds(ids, uid, response);
			System.out.println(orderUtil.getOids());
			if (orderUtil.getStatus() == -1) {
				model.addAttribute("omsg", "<span style='color:red'>您购买的部分产品库存不足!</span>");
				model.addAttribute("flag", 1);
			}else if(orderUtil.getStatus() == -2){
				model.addAttribute("omsg", "<span style='color:red'>获取产品信息失败!</span>");
				model.addAttribute("flag", 1);
			} else {
				model.addAttribute("flag", 0);
				model.addAttribute("omsg", omsg);
			}
			List<MailList> mailLists = userService.selectAllMail(request, 0);
			model.addAttribute("mailLists", mailLists);
			model.addAttribute("proShops", orderUtil.getProShops());
			return "/other/pay2";
		} else {
			rAttributes.addFlashAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}

	// 购物车生成订单
	@RequestMapping("/catrToOrder")
	public String catrToOrder(Integer sendId, HttpServletRequest request, String returnUrl,
			RedirectAttributes rAttributes) throws JsonParseException, JsonMappingException, IOException {
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		Integer[] ids = (Integer[]) session.getAttribute("ids");
		if (null != uid && uid > 0) {
			OrderUtil orderUtil = cartService.catrtApply(sendId, request);
			switch (orderUtil.getStatus()) {
			case 1:
				session.setAttribute("ids", ids);
				session.setAttribute("ou", orderUtil);
				session.setAttribute("oids", orderUtil.getOids());
				rAttributes.addAttribute("type",1);
				return "redirect:/order/toPayMent";

			default:
				session.setAttribute("ids", ids);
				rAttributes.addAttribute("omsg", orderUtil.getMsg());
				return "redirect:/cart/toVerfiyPro";
			}

		} else {
			rAttributes.addAttribute("returnUrl", returnUrl);
			return "redirect:/login/toLogin";
		}

	}
}
