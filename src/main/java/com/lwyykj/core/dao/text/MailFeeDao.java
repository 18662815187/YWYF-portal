package com.lwyykj.core.dao.text;

import com.lwyykj.core.bean.text.MailFee;
import com.lwyykj.core.bean.text.MailFeeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailFeeDao {
    int countByExample(MailFeeQuery example);

    int deleteByExample(MailFeeQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(MailFee record);

    int insertSelective(MailFee record);

    List<MailFee> selectByExample(MailFeeQuery example);

    MailFee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MailFee record, @Param("example") MailFeeQuery example);

    int updateByExample(@Param("record") MailFee record, @Param("example") MailFeeQuery example);

    int updateByPrimaryKeySelective(MailFee record);

    int updateByPrimaryKey(MailFee record);
    
    //通过商家ID查询
    List<MailFee> selectByPhId(Integer phId);
}