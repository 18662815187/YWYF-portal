package com.lwyykj.core.dao.text;

import com.lwyykj.core.bean.text.Comments;
import com.lwyykj.core.bean.text.CommentsQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentsDao {
	int countByExample(CommentsQuery example);

	int deleteByExample(CommentsQuery example);

	int deleteByPrimaryKey(Integer id);

	int insert(Comments record);

	int insertSelective(Comments record);

	List<Comments> selectByExample(CommentsQuery example);

	Comments selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Comments record, @Param("example") CommentsQuery example);

	int updateByExample(@Param("record") Comments record, @Param("example") CommentsQuery example);

	int updateByPrimaryKeySelective(Comments record);

	int updateByPrimaryKey(Comments record);

	// 根据产品ID计算所有评论数
	int countAll(Integer pid);

	// 根据产品ID计算好评数
	int countGood(Integer pid);

	// 根据产品ID计算中评数
	int countMid(Integer pid);

	// 根据产品ID计算差评数
	int countLow(Integer pid);
	//查询该ID所有评价
	List<Comments> countAllCom(Integer pid);
}