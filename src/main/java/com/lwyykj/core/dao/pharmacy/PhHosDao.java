package com.lwyykj.core.dao.pharmacy;

import com.lwyykj.core.bean.pharmacy.PhHos;
import com.lwyykj.core.bean.pharmacy.PhHosQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhHosDao {
    int countByExample(PhHosQuery example);

    int deleteByExample(PhHosQuery example);

    int insert(PhHos record);

    int insertSelective(PhHos record);

    List<PhHos> selectByExample(PhHosQuery example);

    int updateByExampleSelective(@Param("record") PhHos record, @Param("example") PhHosQuery example);

    int updateByExample(@Param("record") PhHos record, @Param("example") PhHosQuery example);
}