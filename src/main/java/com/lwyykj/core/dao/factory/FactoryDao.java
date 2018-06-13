package com.lwyykj.core.dao.factory;

import com.lwyykj.core.bean.factory.Factory;
import com.lwyykj.core.bean.factory.FactoryQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FactoryDao {
    int countByExample(FactoryQuery example);

    int deleteByExample(FactoryQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Factory record);

    int insertSelective(Factory record);

    List<Factory> selectByExample(FactoryQuery example);

    Factory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Factory record, @Param("example") FactoryQuery example);

    int updateByExample(@Param("record") Factory record, @Param("example") FactoryQuery example);

    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);
    
    int delById(Integer id);
    
    int deletes(Integer[] ids);
    
    int upByIds(Integer[] ids);
}