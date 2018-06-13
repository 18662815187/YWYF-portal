package com.lwyykj.core.dao.text;

import com.lwyykj.core.bean.text.BannerPosition;
import com.lwyykj.core.bean.text.BannerPositionQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BannerPositionDao {
	int countByExample(BannerPositionQuery example);

	int deleteByExample(BannerPositionQuery example);

	int deleteByPrimaryKey(Integer id);

	int insert(BannerPosition record);

	int insertSelective(BannerPosition record);

	List<BannerPosition> selectByExample(BannerPositionQuery example);

	BannerPosition selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") BannerPosition record, @Param("example") BannerPositionQuery example);

	int updateByExample(@Param("record") BannerPosition record, @Param("example") BannerPositionQuery example);

	int updateByPrimaryKeySelective(BannerPosition record);

	int updateByPrimaryKey(BannerPosition record);
	//批删
	int deletes(Integer[] ids);
}