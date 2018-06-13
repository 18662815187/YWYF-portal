package com.lwyykj.core.dao.doctor;

import com.lwyykj.core.bean.doctor.DocHos;
import com.lwyykj.core.bean.doctor.DocHosQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocHosDao {
    int countByExample(DocHosQuery example);

    int deleteByExample(DocHosQuery example);

    int insert(DocHos record);

    int insertSelective(DocHos record);

    List<DocHos> selectByExample(DocHosQuery example);

    int updateByExampleSelective(@Param("record") DocHos record, @Param("example") DocHosQuery example);

    int updateByExample(@Param("record") DocHos record, @Param("example") DocHosQuery example);
}