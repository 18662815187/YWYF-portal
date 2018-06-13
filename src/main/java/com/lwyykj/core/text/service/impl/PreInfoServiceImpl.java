package com.lwyykj.core.text.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwyykj.core.bean.text.PreInfo;
import com.lwyykj.core.bean.text.PreUtil;
import com.lwyykj.core.dao.text.PreInfoDao;
import com.lwyykj.core.text.service.PreInfoService;

/**
 * 
 * @author yl 2018.5.5 处方服务
 *
 */
@Service("preService")
@Transactional
public class PreInfoServiceImpl implements PreInfoService {
	@Resource
	private PreInfoDao preInfoDao;
	//提交处方
	@Override
	public PreUtil insertPre(PreInfo preInfo, HttpServletRequest request) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		PreUtil preUtil = new PreUtil();
		if (null != uid && uid > 0) {
			preInfo.setUid(uid);
			preInfo.setAddtime((int) (new Date().getTime() / 1000));
			int a = preInfoDao.insertSelective(preInfo);
			if (a > 0) {
//				System.out.println(preInfo.getId());
				preUtil.setPreId(preInfo.getId());
				// 提交成功10000
				preUtil.setStatus(10000);
			} else {
				// 插入失败10001
				preUtil.setStatus(10001);
			}
		} else {
			//uid为空
			preUtil.setStatus(10002);
		}
		return preUtil;
	}

}
