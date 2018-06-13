package com.lwyykj.core.dao.text;

import com.lwyykj.core.bean.text.Blacklist;
import com.lwyykj.core.bean.text.BlacklistQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlacklistDao {
    int countByExample(BlacklistQuery example);

    int deleteByExample(BlacklistQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Blacklist record);

    int insertSelective(Blacklist record);

    List<Blacklist> selectByExample(BlacklistQuery example);

    Blacklist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Blacklist record, @Param("example") BlacklistQuery example);

    int updateByExample(@Param("record") Blacklist record, @Param("example") BlacklistQuery example);

    int updateByPrimaryKeySelective(Blacklist record);

    int updateByPrimaryKey(Blacklist record);
}