package com.lwyykj.core.dao.doctor;

import com.lwyykj.core.bean.doctor.AdviceDes;
import com.lwyykj.core.bean.doctor.AdviceDesQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdviceDesDao {
    int countByExample(AdviceDesQuery example);

    int deleteByExample(AdviceDesQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdviceDes record);

    int insertSelective(AdviceDes record);

    List<AdviceDes> selectByExample(AdviceDesQuery example);

    AdviceDes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdviceDes record, @Param("example") AdviceDesQuery example);

    int updateByExample(@Param("record") AdviceDes record, @Param("example") AdviceDesQuery example);

    int updateByPrimaryKeySelective(AdviceDes record);

    int updateByPrimaryKey(AdviceDes record);
}