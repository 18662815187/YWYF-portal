package com.lwyykj.core.order.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwyykj.core.bean.shop.BuyerCart;
import com.lwyykj.core.bean.shop.BuyerItem;
import com.lwyykj.core.bean.shop.ShopCart;
import com.lwyykj.core.bean.shop.ShopCartQuery;
import com.lwyykj.core.bean.shop.ShopCartQuery.Criteria;
import com.lwyykj.core.dao.shop.ShopCartDao;
import com.lwyykj.core.order.service.CartInfoService;

@Service("/cartInfoService")
@Transactional
public class CartInfoServiceImpl implements CartInfoService {
	@Resource
	private ShopCartDao shopCartDao;

	// 计算购物车内产品数量
	@Override
	public int countCart(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		ObjectMapper om = new ObjectMapper();
		// 排除null的字段
		om.setSerializationInclusion(Include.NON_NULL);
		BuyerCart buyerCart = new BuyerCart();
		if (null != uid && uid > 0) {
			ShopCartQuery shopCartQuery = new ShopCartQuery();
			Criteria createCriteria = shopCartQuery.createCriteria();
			createCriteria.andUidEqualTo(uid);
			List<ShopCart> shopCarts = shopCartDao.selectByExample(shopCartQuery);
			if (shopCarts.size() > 0 && null != shopCarts) {
				String carInfo = shopCarts.get(0).getCarInfo();
				buyerCart = om.readValue(carInfo, BuyerCart.class);
				List<BuyerItem> items = buyerCart.getItems();
				return items.size();
			} else {
				return 0;
			}
		} else {
			return 0;
		}

	}

}
