package com.lwyykj.core.dao.type;

import com.lwyykj.core.bean.type.Disease;
import com.lwyykj.core.bean.type.DiseaseQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiseaseDao {
	int countByExample(DiseaseQuery example);

	int deleteByExample(DiseaseQuery example);

	int deleteByPrimaryKey(Integer id);

	int insert(Disease record);

	int insertSelective(Disease record);

	List<Disease> selectByExample(DiseaseQuery example);

	Disease selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Disease record, @Param("example") DiseaseQuery example);

	int updateByExample(@Param("record") Disease record, @Param("example") DiseaseQuery example);

	int updateByPrimaryKeySelective(Disease record);

	int updateByPrimaryKey(Disease record);

	// 单删更新删除状态
	int delById(Integer id);

	// 批量删除
	int delByIds(Integer[] ids);
	//根据fid查询
	List<Disease> findByFid(Integer fid);
	//查询所有
	List<Disease> selectAllDisease();

}