package com.lwyykj.core.dao.product;

import com.lwyykj.core.bean.product.Brand;
import com.lwyykj.core.bean.product.BrandQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandDao {
	int countByExample(BrandQuery example);

	int deleteByExample(BrandQuery example);

	int deleteByPrimaryKey(Integer id);

	int insert(Brand record);

	int insertSelective(Brand record);

	List<Brand> selectByExample(BrandQuery example);

	Brand selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandQuery example);

	int updateByExample(@Param("record") Brand record, @Param("example") BrandQuery example);

	int updateByPrimaryKeySelective(Brand record);

	int updateByPrimaryKey(Brand record);

	// 单删
	int DelByid(Integer id);

	// 批删
	int deletes(Integer[] ids);

	// 批量更新
	int upByIds(Integer[] ids);
	//PC首页
	List<Brand> selectAll();
}