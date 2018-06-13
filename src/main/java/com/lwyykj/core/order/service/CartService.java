package com.lwyykj.core.order.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lwyykj.core.bean.shop.BuyerCart;
import com.lwyykj.core.bean.shop.OrderUtil;
import com.lwyykj.core.bean.shop.ProShop;
import com.lwyykj.core.bean.shop.ShopCart;

public interface CartService {
	// 添加进购物车
	void addToCart(Integer skuId, Integer amount, Integer preId, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	// 提取购物车
	List<ProShop> selectFromRedis(Integer uid)throws JsonParseException, JsonMappingException, IOException;

	// 保存购物车到数据库
	public int saveToCart(ShopCart shopCart);

	// 查询购物车
	public ShopCart findByUId(Integer id);

	// 更新购物车
	public int update(ShopCart shopCart);

	// 插入购物车
	public int insertToSql(BuyerCart buyerCart, Integer uid) throws Exception;
	
	//删除指定购物车数据
	int delBySkuId(Integer[] skuIds,HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException ;
	
	//清空购物车
	int delAll(Integer uid);
	
	//修改购物车内产品数量
	int modify(Integer skuId,Integer amount,HttpServletRequest request)throws JsonParseException, JsonMappingException, IOException;
	
	//购物车订单确认页数据
	OrderUtil  selectBySkuIds(Integer[] ids,Integer uid,HttpServletResponse response)throws JsonParseException, JsonMappingException, IOException;
	//购物车生成订单
	OrderUtil catrtApply(Integer sendId,HttpServletRequest request)throws JsonParseException, JsonMappingException, IOException;
}
