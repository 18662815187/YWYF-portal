package com.lwyykj.core.dao.doctor;

import com.lwyykj.core.bean.doctor.Hospital;
import com.lwyykj.core.bean.doctor.HospitalQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitalDao {
    int countByExample(HospitalQuery example);

    int deleteByExample(HospitalQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    List<Hospital> selectByExample(HospitalQuery example);

    Hospital selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hospital record, @Param("example") HospitalQuery example);

    int updateByExample(@Param("record") Hospital record, @Param("example") HospitalQuery example);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);
    //单删
    int delById(Integer id);
    //批量删除
    int delByIds(Integer[] ids);
    //单审
    int upById(Integer id);
    //批量审核
    int upByIds(Integer[] id);
    
}