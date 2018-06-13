package com.lwyykj.core.product.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lwyykj.core.bean.product.Brand;
import com.lwyykj.core.bean.product.DisProduct;
import com.lwyykj.core.bean.product.Product;
import com.lwyykj.core.bean.text.DisComments;
import com.lwyykj.core.bean.type.Disease;
import com.lwyykj.core.bean.type.FunType;
import com.lwyykj.core.bean.type.ProType;
import com.lwyykj.core.order.service.CartInfoService;
import com.lwyykj.core.product.service.BrandService;
import com.lwyykj.core.product.service.ProductService;
import com.lwyykj.core.solr.service.SolrService;
import com.lwyykj.core.text.service.CommentsService;
import com.lwyykj.core.type.service.TypeService;

import cn.itcast.common.page.Pagination;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Resource
	private ProductService productService;
	@Resource
	private CommentsService commentsService;
	@Resource
	private BrandService brandService;
	@Resource
	private SolrService solrService;
	@Resource
	private TypeService typeService;
	@Resource
	private CartInfoService cartInfoService;

	// 根据产品ID查询详细内容
	@RequestMapping("/query")
	public String query(Integer id, Model model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		int countCart = cartInfoService.countCart(request);
		Product product = productService.selectByPrimaryKey(id, request);
		if (null != product) {
			// System.out.println(product.getFac_name()+"---------");
			DisComments disComments = commentsService.selectByPid(id);
			model.addAttribute("product", product);
			model.addAttribute("disComments", disComments);
			model.addAttribute("countCart", countCart);
			return "/other/introduction";
		} else {
			List<DisProduct> disProducts = solrService.queryByTypeId(null, true, 5);
			model.addAttribute("countCart", countCart);
			model.addAttribute("disProducts", disProducts);
			model.addAttribute("msg", "很抱歉，您搜索的商品不存在，可能已下架或者被转移。");
			return "/other/non_existent";
		}
	}

	// 产品带分页
	@RequestMapping("/search")
	public String list(Integer pageNo, String keyword, Integer brandId, Integer typeId, Integer disId, Integer funId,
			String price, Integer priceType, Model model, HttpServletRequest request) throws Exception {
		// System.out.println(disId);
		Pagination pagination = solrService.selectByPagination(pageNo, keyword, String.valueOf(brandId),
				String.valueOf(typeId), String.valueOf(disId), String.valueOf(funId), price, priceType);
		List<Brand> brands = brandService.selectForPC();
		List<ProType> proTypes = typeService.selectAllProType();
		List<FunType> funTypes = typeService.selectAllFunType();
		List<Disease> diseases = typeService.selectAllDisease();
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		model.addAttribute("brands", brands);
		model.addAttribute("proTypes", proTypes);
		model.addAttribute("funTypes", funTypes);
		model.addAttribute("diseases", diseases);
		model.addAttribute("pagination", pagination);
		model.addAttribute("brandId", brandId);
		model.addAttribute("typeId", typeId);
		model.addAttribute("disId", disId);
		model.addAttribute("funId", funId);
		model.addAttribute("price", price);
		model.addAttribute("priceType", priceType);
		model.addAttribute("keyword", keyword);
		return "other/search";
	}

	// branList
	@RequestMapping("/brandList")
	public String branList(Integer pageNo, String brandName, Model model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, IOException {
		Pagination pagination = brandService.selectByPagination(pageNo, brandName);
		int countCart = cartInfoService.countCart(request);
		model.addAttribute("countCart", countCart);
		model.addAttribute("pagination", pagination);
		return "/other/classification";
	}

}
