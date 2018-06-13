package com.lwyykj.core.text.service;

import javax.servlet.http.HttpServletRequest;

import com.lwyykj.core.bean.text.PreInfo;
import com.lwyykj.core.bean.text.PreUtil;

//处方服务
public interface PreInfoService {
	PreUtil insertPre(PreInfo preInfo,HttpServletRequest request);
}
