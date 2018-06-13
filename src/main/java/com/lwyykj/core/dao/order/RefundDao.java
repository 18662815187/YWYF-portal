package com.lwyykj.core.dao.order;

import com.lwyykj.core.bean.order.Refund;
import com.lwyykj.core.bean.order.RefundQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundDao {
    int countByExample(RefundQuery example);

    int deleteByExample(RefundQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Refund record);

    int insertSelective(Refund record);

    List<Refund> selectByExample(RefundQuery example);

    Refund selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Refund record, @Param("example") RefundQuery example);

    int updateByExample(@Param("record") Refund record, @Param("example") RefundQuery example);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);
    //统计售后单数量不包含取消的
    int countByOpid(Integer opId);
    
    //取消订单
    int cancel(Integer pid);
    //个人中心首页统计售后数量
    int countByUid(Integer uid);
}