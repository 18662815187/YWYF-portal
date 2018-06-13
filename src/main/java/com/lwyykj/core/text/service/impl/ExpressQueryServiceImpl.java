package com.lwyykj.core.text.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwyykj.common.HttpUtils;
import com.lwyykj.core.text.service.ExpressQueryService;
@Service("/expressQueryService")
@Transactional
public class ExpressQueryServiceImpl implements ExpressQueryService{

	@Override
	public String query(String number) {
		String host = "http://jisukdcx.market.alicloudapi.com";
	    String path = "/express/query";
	    String method = "GET";
	    String appcode = "ad15304e133544af9e40ce25009c907b";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("number", number);
	    querys.put("type", "auto");
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//	    	System.out.println(response.toString());
	    	//获取response的body
//	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    	return EntityUtils.toString(response.getEntity());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}

}
