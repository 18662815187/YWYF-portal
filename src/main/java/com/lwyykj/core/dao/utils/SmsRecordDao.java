package com.lwyykj.core.dao.utils;

import com.lwyykj.core.bean.utils.SmsRecord;
import com.lwyykj.core.bean.utils.SmsRecordQuery;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsRecordDao {
    int countByExample(SmsRecordQuery example);

    int deleteByExample(SmsRecordQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsRecord record);

    int insertSelective(SmsRecord record);

    List<SmsRecord> selectByExample(SmsRecordQuery example);

    SmsRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsRecord record, @Param("example") SmsRecordQuery example);

    int updateByExample(@Param("record") SmsRecord record, @Param("example") SmsRecordQuery example);

    int updateByPrimaryKeySelective(SmsRecord record);

    int updateByPrimaryKey(SmsRecord record);
    //根据手机号查询记录
    int selectByTel(@Param("tel")String tel,@Param("startTime")Integer startTime,@Param("endTime")Integer endTime);
    //根据IP查询
    int selectByIp(@Param("ip")String ip,@Param("startTime")Integer startTime,@Param("endTime")Integer endTime);
}