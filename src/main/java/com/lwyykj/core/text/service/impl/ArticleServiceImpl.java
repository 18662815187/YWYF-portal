package com.lwyykj.core.text.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lwyykj.core.bean.text.Article;
import com.lwyykj.core.bean.text.ArticleQuery;
import com.lwyykj.core.bean.text.ArticleQuery.Criteria;
import com.lwyykj.core.dao.text.ArticleDao;
import com.lwyykj.core.text.service.ArticleService;

import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 2018.4.17 文章、通知
 *
 */

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleDao articleDao;

	// 列表全部
	@Override
	public List<Article> selectAll() {
		ArticleQuery articleQuery = new ArticleQuery();
		articleQuery.setFields("id, title");
		articleQuery.setOrderByClause("id desc");
		articleQuery.setPageNo(1);
		articleQuery.setPageSize(4);
		Criteria createCriteria = articleQuery.createCriteria();
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andIsShowEqualTo(1);
		return articleDao.selectByExample(articleQuery);
	}

	// 列表
	@Override
	public Pagination selectByPagination(Integer pageNo, String keyword) {
		StringBuilder params = new StringBuilder();
		ArticleQuery articleQuery = new ArticleQuery();
		articleQuery.setOrderByClause("id desc");
		articleQuery.setFields(" id, title,addtime");
		articleQuery.setPageNo(Pagination.cpn(pageNo));
		articleQuery.setPageSize(20);
		Criteria createCriteria = articleQuery.createCriteria();
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andIsShowEqualTo(1);
		if (null != keyword) {
			createCriteria.andTitleLike("%" + keyword + "%");
			params.append("keyword=").append(keyword);
		}
		String url = "/text/list.do";
		Pagination pagination = new Pagination(articleQuery.getPageNo(), articleQuery.getPageSize(),
				articleDao.countByExample(articleQuery), articleDao.selectByExample(articleQuery));
		pagination.pageView(url, params.toString());
		return pagination;
	}

	// 主键查询
	@Override
	public Article selectByPrimaryKey(Integer id) {
		if (null != id) {
			return articleDao.selectByPrimaryKey(id);
		}
		return null;
	}

	@Override
	public List<Article> selectFive() {
		ArticleQuery articleQuery = new ArticleQuery();
		articleQuery.setFields("id, title");
		articleQuery.setOrderByClause("id desc");
		articleQuery.setPageNo(1);
		articleQuery.setPageSize(5);
		Criteria createCriteria = articleQuery.createCriteria();
		createCriteria.andIsDelEqualTo(false);
		createCriteria.andIsShowEqualTo(1);
		return articleDao.selectByExample(articleQuery);
	}

}
