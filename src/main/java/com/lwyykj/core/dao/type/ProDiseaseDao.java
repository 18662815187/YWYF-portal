package com.lwyykj.core.dao.type;

import com.lwyykj.core.bean.type.ProDisease;
import com.lwyykj.core.bean.type.ProDiseaseQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProDiseaseDao {
    int countByExample(ProDiseaseQuery example);

    int deleteByExample(ProDiseaseQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProDisease record);

    int insertSelective(ProDisease record);

    List<ProDisease> selectByExample(ProDiseaseQuery example);

    ProDisease selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProDisease record, @Param("example") ProDiseaseQuery example);

    int updateByExample(@Param("record") ProDisease record, @Param("example") ProDiseaseQuery example);

    int updateByPrimaryKeySelective(ProDisease record);

    int updateByPrimaryKey(ProDisease record);
}