package com.lwyykj.core.CenterController;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lwyykj.core.bean.product.Brand;
import com.lwyykj.core.bean.product.DisProduct;
import com.lwyykj.core.bean.text.Article;
import com.lwyykj.core.bean.text.Banner;
import com.lwyykj.core.bean.type.ProType;
import com.lwyykj.core.order.service.CartInfoService;
import com.lwyykj.core.product.service.BrandService;
import com.lwyykj.core.solr.service.SolrService;
import com.lwyykj.core.text.service.ArticleService;
import com.lwyykj.core.text.service.BannerService;
import com.lwyykj.core.type.service.TypeService;

@Controller
public class CenterController {
	@Resource
	private SolrService solrService;
	@Resource
	private TypeService typeService;
	@Resource
	private BrandService brandService;
	@Resource
	private BannerService bannerService;
	@Resource
	private ArticleService articleService;
	@Resource
	private CartInfoService cartInfoService;

	/**
	 * 
	 * PC首页携带数据，1、2、3、9、10、11为分类ID,1234569是banner位置ID，不推荐此种写法的controller,可以建立一个临时包装POJO类来组装这些数据
	 * 分类1：中药西药 2：养生保健 3:医疗器械 9:计生用品 10:中药饮片  11：美容护肤
	 * banner分类 1:头部大banner 2:中药西药位 3：医疗器械 4：养生保健 5app首页 6微网站首页 9首页头条banner 10计生用品 11中药饮片 12美容护肤
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping("/")
	public String index(Model model,HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		int countCart = cartInfoService.countCart(request);
		List<Article> articles = articleService.selectAll();
		List<ProType> proTypes = typeService.queryAll();
		List<DisProduct> disProducts = solrService.queryByTypeId(null, true, 13);
		List<DisProduct> disProducts2 = solrService.queryByTypeId(1, true, 8);
		List<DisProduct> disProducts3 = solrService.queryByTypeId(2, true, 8);
		List<DisProduct> disProducts4 = solrService.queryByTypeId(3, true, 8);
		List<DisProduct> disProducts5 = solrService.queryByTypeId(9, true, 8);
		List<DisProduct> disProducts6 = solrService.queryByTypeId(10, true, 8);
		List<DisProduct> disProducts7 = solrService.queryByTypeId(11, true, 8);
		List<Brand> brands = brandService.selectForPC();
		List<Banner> banners1 = bannerService.queryAll(1);
		List<Banner> banners2 = bannerService.queryAll(2);
		List<Banner> banners3 = bannerService.queryAll(3);
		List<Banner> banners4 = bannerService.queryAll(4);
		List<Banner> banners5 = bannerService.queryAll(9);
		List<Banner> banners6 = bannerService.queryAll(10);
		List<Banner> banners7 = bannerService.queryAll(11);
		List<Banner> banners8 = bannerService.queryAll(12);
		model.addAttribute("countCart", countCart);
		model.addAttribute("articles", articles);
		model.addAttribute("banners1", banners1);
		model.addAttribute("banners2", banners2);
		model.addAttribute("banners3", banners3);
		model.addAttribute("banners4", banners4);
		model.addAttribute("banners5", banners5);
		model.addAttribute("banners6", banners6);
		model.addAttribute("banners7", banners7);
		model.addAttribute("banners8", banners8);
		model.addAttribute("brands", brands);
		model.addAttribute("type11", disProducts7);
		model.addAttribute("type10", disProducts6);
		model.addAttribute("type9", disProducts5);
		model.addAttribute("type3", disProducts4);
		model.addAttribute("type2", disProducts3);
		model.addAttribute("type1", disProducts2);
		model.addAttribute("commend", disProducts);
		model.addAttribute("types", proTypes);
		return "../home";
	}

	@RequestMapping("/queryProduct")
	@ResponseBody
	public Object query(Integer typeId, Boolean isCommend, Integer pageSize) {
		List<DisProduct> products = solrService.queryByTypeId(typeId, isCommend, pageSize);
		return products;
	}
	//关于我们
	@RequestMapping("/aboutUs")
	public String aboutUs(){
		return "/other/concerning";
	}
}
