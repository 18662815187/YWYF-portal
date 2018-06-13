package com.lwyykj.core.text.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lwyykj.core.bean.product.DisProduct;
import com.lwyykj.core.bean.text.Article;
import com.lwyykj.core.solr.service.SolrService;
import com.lwyykj.core.text.service.ArticleService;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 2018.4.26 图文控制器
 *
 */
@Controller
@RequestMapping("/text")
public class TextController {
	@Resource
	private ArticleService articleService;
	@Resource
	private SolrService solrService;

	@RequestMapping("/list.do")
	public String list(Integer pageNo, String keyword, Model model) {
		Pagination pagination = articleService.selectByPagination(pageNo, keyword);
		model.addAttribute("pagination", pagination);
		model.addAttribute("keyword", keyword);
		return "/person/news";
	}

	@RequestMapping("/query")
	public String query(Integer id, Model model) {
		Article article = articleService.selectByPrimaryKey(id);
		if (null != article) {
			List<Article> ars = articleService.selectFive();
			model.addAttribute("ars", ars);
			model.addAttribute("title", article.getTitle());
			model.addAttribute("article", article);
			return "/person/blog";
		} else {
			List<DisProduct> disProducts = solrService.queryByTypeId(null, true, 5);
			model.addAttribute("disProducts", disProducts);
			model.addAttribute("msg", "很抱歉，您搜索的文章不存在，可能已删除或者被转移。");
			return "/other/non_existent";
		}

	}

}
