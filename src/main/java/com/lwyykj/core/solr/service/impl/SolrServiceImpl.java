package com.lwyykj.core.solr.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwyykj.common.Constants;
import com.lwyykj.core.bean.product.DisProduct;
import com.lwyykj.core.bean.product.DisProductQuery;
import com.lwyykj.core.solr.service.SolrService;
import cn.itcast.common.page.Pagination;

/**
 * 
 * @author yl 2018.4.9 solr全文搜索
 *
 */
@Service("solrService")
@Transactional
public class SolrServiceImpl implements SolrService {
	@Resource
	private SolrClient solrClient;

	// 根据产品类别查询
	@Override
	public List<DisProduct> queryByTypeId(Integer typeId, Boolean isCommend, Integer pageSize) {
		SolrQuery query = new SolrQuery();
		// 搜索范围是所有信息
		query.set("q", "*:*");
		// 分类过滤条件
		if (null != typeId) {
			query.addFilterQuery("pro_typeId:" + typeId);
		}
		if (null != isCommend) {
			query.addFilterQuery("is_commend:" + isCommend);
		}
		// 参数sort,设置返回结果的排序规则
		query.setSort("addtime", SolrQuery.ORDER.desc);
		// 设置分页参数
		query.setStart(0);
		if (null != pageSize && pageSize > 0) {
			query.setRows(pageSize);// 每一页多少值
		} else {
			query.setRows(8);
		}

		// 获取查询结果
		QueryResponse response;
		try {
			response = solrClient.query(query);
			// 查询结果转化对象
			List<DisProduct> disProducts = response.getBeans(DisProduct.class);
			if (null != disProducts && disProducts.size() > 0) {
				for (DisProduct disProduct : disProducts) {
					disProduct.setUrl(Constants.DOMAIN + "/product/query?id=" + disProduct.getId());
				}
				return disProducts;
			}
		} catch (SolrServerException e) {
			System.out.println("solr查询失败!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO操作失败!");
			e.printStackTrace();
		}
		return null;
	}

	// 全文搜索
	@Override
	public Pagination selectByPagination(Integer pageNo, String keyword, String brandId, String typeId, String disId,
			String funId, String price, Integer priceType) throws Exception {
		// 创建包装类
		DisProductQuery disProductQuery = new DisProductQuery();
		// 当前页
		disProductQuery.setPageNo(Pagination.cpn(pageNo));
		// 每页显示数量
		disProductQuery.setPageSize(15);
		StringBuilder params = new StringBuilder();
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setStart(0);
		solrQuery.setRows(Integer.MAX_VALUE);
		if (null != keyword && keyword != "" && !keyword.equals("null")&& !keyword.equals("undefined")) {
			params.append("keyword=").append(keyword);
			solrQuery.set("q", "name:" + keyword);
			// solrQuery.set("q", "name:" + keyword + "~");
		} else {
			// 空值时查询
			params.append("keyword=").append("*");
			solrQuery.set("q", "*:*");
		}
		if (null != brandId && brandId != "null" && brandId != "") {
			solrQuery.addFilterQuery("brand_id:" + brandId);
			params.append("&brandId=").append(brandId);
			// System.out.println(brandId);
		}
		if (null != typeId && typeId != "null" && typeId != "") {
			solrQuery.addFilterQuery("pro_typeId:" + typeId);
			params.append("&typeId=").append(typeId);
		}
		if (null != disId && disId != "null" && disId != "") {
			solrQuery.addFilterQuery("disease_id:" + disId);
			params.append("&disId=").append(disId);
		}
		if (null != funId && funId != "null" && funId != "") {
			solrQuery.addFilterQuery("fun_id:" + funId);
			params.append("&funId=").append(funId);
		}
		// 过滤价格 0-99 1600 0 TO 99 通过切割“-”或者起始和结束价格，最大长度是2，最小是1
		if (null != price && price != "null" && price != "") {
			String[] p = price.split("-");
			if (p.length == 2) {
				solrQuery.addFilterQuery("price:[" + p[0] + " TO " + p[1] + "]");
			} else {
				solrQuery.addFilterQuery("price:[" + p[0] + " TO *]");
			}
		}
		// 高亮开关
		solrQuery.setHighlight(true);
		// 设置高亮字段，此字段是在solr的搜索字段
		solrQuery.addHighlightField("name");
		// 设置样式前缀
		solrQuery.setHighlightSimplePre("<span style='color:red'>");
		// 设置高亮后缀
		solrQuery.setHighlightSimplePost("</span>");
		if (null != priceType) {
			switch (priceType) {
			case 1:
				// 排序按价格倒序
				solrQuery.addSort("price", ORDER.desc);
				break;
			case 2:
				// 排序按价格顺序
				solrQuery.addSort("price", ORDER.asc);
				break;
			default:
				solrQuery.addSort("addtime", ORDER.desc);
				break;
			}
		} else {
			// 排序按时间
			solrQuery.addSort("addtime", ORDER.desc);
		}
		// 分页limit 开始行和size
		solrQuery.setStart(disProductQuery.getStartRow());
		solrQuery.setRows(disProductQuery.getPageSize());
		// 执行查询
		QueryResponse response = solrClient.query(solrQuery);
		// 用list是因为名称内可能存在多个名字用逗号隔开
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		List<DisProduct> disProducts = response.getBeans(DisProduct.class);
		// System.out.println(disProducts.size()+"---");
		for (DisProduct disProduct : disProducts) {
			// 商品名称ik,如果是多个以逗号隔开的名字取下标为0的那个重新设置
			Map<String, List<String>> map = highlighting.get(disProduct.getId());
			List<String> list = map.get("name");
			if (null != list) {
				disProduct.setName(list.get(0));
			}
		}
		Pagination pagination = new Pagination(disProductQuery.getPageNo(), disProductQuery.getPageSize(),
				(int) response.getResults().getNumFound(), disProducts);
		String url = "/product/search";
		pagination.pageView(url, params.toString());
		return pagination;
	}

	// 带分组算法
	@Override
	public List<List<DisProduct>> queryAll() {
		Map<String, List<DisProduct>> map = new HashMap<>();
		SolrQuery query = new SolrQuery();
		// 搜索范围是所有信息
		query.set("q", "*:*");
		// 参数sort,设置返回结果的排序规则
		query.setSort("addtime", SolrQuery.ORDER.desc);
		// 获取查询结果
		QueryResponse response;
		try {
			response = solrClient.query(query);
			// 查询结果转化对象
			List<DisProduct> disProducts = response.getBeans(DisProduct.class);
			if (null != disProducts && disProducts.size() > 0) {
				for (DisProduct disProduct : disProducts) {
					List<DisProduct> tempList = map.get(disProduct.getId());
					if (tempList == null) {
						tempList = new ArrayList<>();
						tempList.add(disProduct);
						map.put(disProduct.getId(), tempList);
					} else {
						tempList.add(disProduct);
					}
				}
				List<List<DisProduct>> list = new ArrayList<>();
				for (Object key : map.keySet()) {
					list.add(map.get(key));
				}
				return list;
			}
		} catch (SolrServerException e) {
			System.out.println("solr查询失败!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO操作失败!");
			e.printStackTrace();
		}
		return null;
	}

}
