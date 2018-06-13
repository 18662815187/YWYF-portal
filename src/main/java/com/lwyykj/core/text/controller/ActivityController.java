package com.lwyykj.core.text.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwyykj.core.bean.product.DisProduct;
import com.lwyykj.core.solr.service.SolrService;

/**
 * 
 * @author yl 2018.4.27 活动控制器
 *
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
	@Resource
	private SolrService solrService;
	
	@RequestMapping("/query")
	public String query(Integer id,Model model){
		model.addAttribute("msg", "暂无活动!");
		List<DisProduct> disProducts = solrService.queryByTypeId(null, true, 5);
		model.addAttribute("disProducts", disProducts);
		return "/other/non_existent";
	}
}
