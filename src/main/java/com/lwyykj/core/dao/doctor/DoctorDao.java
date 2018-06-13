package com.lwyykj.core.dao.doctor;

import com.lwyykj.core.bean.doctor.Doctor;
import com.lwyykj.core.bean.doctor.DoctorQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorDao {
    int countByExample(DoctorQuery example);

    int deleteByExample(DoctorQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorQuery example);

    Doctor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorQuery example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorQuery example);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
    
    //批删
    int delByIds(Integer[] ids);
    //批量审核
    int upByIds(Integer[] ids);
}