package com.lwyykj.core.text.service;

import java.util.List;

import com.lwyykj.core.bean.text.Article;

import cn.itcast.common.page.Pagination;

public interface ArticleService {
	//首页查询所有
	List<Article> selectAll();
	//分页列表
	Pagination selectByPagination(Integer pageNo,String keyword);
	//根据主键查询
	Article selectByPrimaryKey(Integer id);
	//文章内页推荐新闻
	List<Article> selectFive();
}
