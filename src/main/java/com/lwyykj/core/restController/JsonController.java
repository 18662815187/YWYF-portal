package com.lwyykj.core.restController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwyykj.core.bean.product.Product;
import com.lwyykj.core.product.service.ProductService;

/**
 * 
 * @author yl 2018.4.13
 * 此控制器为纯json输出格式
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/rest")
public class JsonController {
	@Resource
	private ProductService productService;
	//首页搜索关键字联想
	@RequestMapping("/searchKeywords")
	public Object search(String keyword){
		List<Product> products = productService.findAllName(keyword);
		return products;
	}
}
