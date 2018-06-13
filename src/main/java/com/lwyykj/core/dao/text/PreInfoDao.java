package com.lwyykj.core.dao.text;

import com.lwyykj.core.bean.text.PreInfo;
import com.lwyykj.core.bean.text.PreInfoQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PreInfoDao {
    int countByExample(PreInfoQuery example);

    int deleteByExample(PreInfoQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(PreInfo record);

    int insertSelective(PreInfo record);

    List<PreInfo> selectByExample(PreInfoQuery example);

    PreInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PreInfo record, @Param("example") PreInfoQuery example);

    int updateByExample(@Param("record") PreInfo record, @Param("example") PreInfoQuery example);

    int updateByPrimaryKeySelective(PreInfo record);

    int updateByPrimaryKey(PreInfo record);
}