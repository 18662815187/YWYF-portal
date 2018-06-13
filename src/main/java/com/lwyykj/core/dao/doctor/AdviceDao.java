package com.lwyykj.core.dao.doctor;

import com.lwyykj.core.bean.doctor.Advice;
import com.lwyykj.core.bean.doctor.AdviceQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdviceDao {
    int countByExample(AdviceQuery example);

    int deleteByExample(AdviceQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Advice record);

    int insertSelective(Advice record);

    List<Advice> selectByExample(AdviceQuery example);

    Advice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Advice record, @Param("example") AdviceQuery example);

    int updateByExample(@Param("record") Advice record, @Param("example") AdviceQuery example);

    int updateByPrimaryKeySelective(Advice record);

    int updateByPrimaryKey(Advice record);
}