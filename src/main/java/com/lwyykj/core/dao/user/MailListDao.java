package com.lwyykj.core.dao.user;

import com.lwyykj.core.bean.user.MailList;
import com.lwyykj.core.bean.user.MailListQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailListDao {
    int countByExample(MailListQuery example);

    int deleteByExample(MailListQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(MailList record);

    int insertSelective(MailList record);

    List<MailList> selectByExample(MailListQuery example);

    MailList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MailList record, @Param("example") MailListQuery example);

    int updateByExample(@Param("record") MailList record, @Param("example") MailListQuery example);

    int updateByPrimaryKeySelective(MailList record);

    int updateByPrimaryKey(MailList record);
    //统计数据条数
    int countByUid(Integer uid);
    //情况用户默认地址状态
    Integer upDefaultByUid(Integer uid);
    //设置某个记录ID的默认值为1
    Integer upDefaultById(Integer id);
}