package com.lwyykj.core.dao.text;

import com.lwyykj.core.bean.text.Shield;
import com.lwyykj.core.bean.text.ShieldQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShieldDao {
    int countByExample(ShieldQuery example);

    int deleteByExample(ShieldQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shield record);

    int insertSelective(Shield record);

    List<Shield> selectByExample(ShieldQuery example);

    Shield selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shield record, @Param("example") ShieldQuery example);

    int updateByExample(@Param("record") Shield record, @Param("example") ShieldQuery example);

    int updateByPrimaryKeySelective(Shield record);

    int updateByPrimaryKey(Shield record);
}