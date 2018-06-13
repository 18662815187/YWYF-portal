package com.lwyykj.core.dao.user;

import com.lwyykj.core.bean.user.Msg;
import com.lwyykj.core.bean.user.MsgQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgDao {
    int countByExample(MsgQuery example);

    int deleteByExample(MsgQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Msg record);

    int insertSelective(Msg record);

    List<Msg> selectByExample(MsgQuery example);

    Msg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Msg record, @Param("example") MsgQuery example);

    int updateByExample(@Param("record") Msg record, @Param("example") MsgQuery example);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);
    //查询指定和不指定的信息
    List<Msg> selectByUid(Integer uid);
    //统计指定用户未读信息
    int countMsg(Integer uid);
}