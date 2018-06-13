package com.lwyykj.core.type.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lwyykj.core.bean.type.Disease;
import com.lwyykj.core.bean.type.FunType;
import com.lwyykj.core.bean.type.ProType;
import com.lwyykj.core.bean.type.ProTypeQuery;
import com.lwyykj.core.bean.type.ProTypeQuery.Criteria;
import com.lwyykj.core.dao.type.DiseaseDao;
import com.lwyykj.core.dao.type.FunTypeDao;
import com.lwyykj.core.dao.type.ProTypeDao;
import com.lwyykj.core.type.service.TypeService;

/**
 * 
 * @author yl 2018.4.11 首页导航分类
 *
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Resource
	private ProTypeDao proTypeDao;
	@Resource
	private FunTypeDao funTypeDao;
	@Resource
	private DiseaseDao diseaseDao;
	
	//首页导航
	@Override
	public List<ProType> queryAll() {
		ProTypeQuery proTypeQuery = new ProTypeQuery();
		proTypeQuery.setOrderByClause("id asc");
		Criteria createCriteria = proTypeQuery.createCriteria();
		createCriteria.andIsDelEqualTo(false);
		List<ProType> proTypes = proTypeDao.selectByExample(proTypeQuery);
		for (ProType proType : proTypes) {
			List<FunType> funTypes = funTypeDao.findByParId(proType.getId());
			proType.setFunTypes(funTypes);
			for (FunType funType : funTypes) {
				funType.setDiseases(diseaseDao.findByFid(funType.getId()));
			}
			
		}
		return proTypes;
	}

	@Override
	public List<ProType> selectAllProType() {
		return proTypeDao.selectAllProType();
	}

	@Override
	public List<FunType> selectAllFunType() {
		return funTypeDao.selectAllFunType();
	}

	@Override
	public List<Disease> selectAllDisease() {
		return diseaseDao.selectAllDisease();
	}

}
