package com.lwyykj.core.order.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface CartInfoService {
	//统计购物车数量
	int countCart(HttpServletRequest request)throws JsonParseException, JsonMappingException, IOException;
}
