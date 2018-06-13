package com.lwyykj.core.type.service;

import java.util.List;

import com.lwyykj.core.bean.type.Disease;
import com.lwyykj.core.bean.type.FunType;
import com.lwyykj.core.bean.type.ProType;

public interface TypeService {
	//PC导航
	List<ProType> queryAll();
	//查询所有一级分类
	List<ProType> selectAllProType();
	//查询所有二级分类
	List<FunType> selectAllFunType();
	//查询三级分类
	List<Disease> selectAllDisease();
}
