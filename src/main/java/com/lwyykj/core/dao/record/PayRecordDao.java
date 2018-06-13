package com.lwyykj.core.dao.record;

import com.lwyykj.core.bean.record.PayRecord;
import com.lwyykj.core.bean.record.PayRecordQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayRecordDao {
    int countByExample(PayRecordQuery example);

    int deleteByExample(PayRecordQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayRecord record);

    int insertSelective(PayRecord record);

    List<PayRecord> selectByExample(PayRecordQuery example);

    PayRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayRecord record, @Param("example") PayRecordQuery example);

    int updateByExample(@Param("record") PayRecord record, @Param("example") PayRecordQuery example);

    int updateByPrimaryKeySelective(PayRecord record);

    int updateByPrimaryKey(PayRecord record);
    //通过流水号查询
    List<PayRecord> selectByTradeNo(String tradeNo);
}