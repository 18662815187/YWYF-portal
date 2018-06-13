package com.lwyykj.core.dao.type;

import com.lwyykj.core.bean.type.FunType;
import com.lwyykj.core.bean.type.FunTypeQuery;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunTypeDao {
    int countByExample(FunTypeQuery example);

    int deleteByExample(FunTypeQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(FunType record);

    int insertSelective(FunType record);

    List<FunType> selectByExample(FunTypeQuery example);

    FunType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FunType record, @Param("example") FunTypeQuery example);

    int updateByExample(@Param("record") FunType record, @Param("example") FunTypeQuery example);

    int updateByPrimaryKeySelective(FunType record);

    int updateByPrimaryKey(FunType record);
    
    //单删
    int delById(Integer id);
    //批量删除
    int delByIds(Integer[] ids);
    //根据上级ID查询
  	List<FunType> findByParId(Integer pid);
  	//根据IDS更新父级ID
  	int updateByIds(@Param("pid")Integer pid,@Param("templist")List<FunType> funTypes);
  	//首页取三条二级分类
  	List<FunType> findByTid(Integer tid);
  	//查询所有
  	List<FunType> selectAllFunType();
}