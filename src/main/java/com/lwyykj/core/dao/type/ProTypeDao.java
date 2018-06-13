package com.lwyykj.core.dao.type;

import com.lwyykj.core.bean.type.ProType;
import com.lwyykj.core.bean.type.ProTypeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProTypeDao {
    int countByExample(ProTypeQuery example);

    int deleteByExample(ProTypeQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProType record);

    int insertSelective(ProType record);

    List<ProType> selectByExample(ProTypeQuery example);

    ProType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProType record, @Param("example") ProTypeQuery example);

    int updateByExample(@Param("record") ProType record, @Param("example") ProTypeQuery example);

    int updateByPrimaryKeySelective(ProType record);

    int updateByPrimaryKey(ProType record);
    //单删
    int delById(Integer id);
    //批量删除
    int delByIds(Integer[] id);
    //查询全部
    List<ProType> selectAllProType();
}