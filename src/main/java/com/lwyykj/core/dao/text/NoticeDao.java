package com.lwyykj.core.dao.text;

import com.lwyykj.core.bean.text.Notice;
import com.lwyykj.core.bean.text.NoticeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeDao {
    int countByExample(NoticeQuery example);

    int deleteByExample(NoticeQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExampleWithBLOBs(NoticeQuery example);

    List<Notice> selectByExample(NoticeQuery example);

    Notice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeQuery example);

    int updateByExampleWithBLOBs(@Param("record") Notice record, @Param("example") NoticeQuery example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeQuery example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
}