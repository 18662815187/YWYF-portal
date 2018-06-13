package com.lwyykj.core.dao.record;

import com.lwyykj.core.bean.record.AdminLoginRecord;
import com.lwyykj.core.bean.record.AdminLoginRecordQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminLoginRecordDao {
    int countByExample(AdminLoginRecordQuery example);

    int deleteByExample(AdminLoginRecordQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminLoginRecord record);

    int insertSelective(AdminLoginRecord record);

    List<AdminLoginRecord> selectByExample(AdminLoginRecordQuery example);

    AdminLoginRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminLoginRecord record, @Param("example") AdminLoginRecordQuery example);

    int updateByExample(@Param("record") AdminLoginRecord record, @Param("example") AdminLoginRecordQuery example);

    int updateByPrimaryKeySelective(AdminLoginRecord record);

    int updateByPrimaryKey(AdminLoginRecord record);
}