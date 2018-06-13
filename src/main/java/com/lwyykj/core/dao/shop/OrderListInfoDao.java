package com.lwyykj.core.dao.shop;

import com.lwyykj.core.bean.shop.OrderListInfo;
import com.lwyykj.core.bean.shop.OrderListInfoQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderListInfoDao {
    int countByExample(OrderListInfoQuery example);

    int deleteByExample(OrderListInfoQuery example);

    int insert(OrderListInfo record);

    int insertSelective(OrderListInfo record);

    List<OrderListInfo> selectByExample(OrderListInfoQuery example);

    int updateByExampleSelective(@Param("record") OrderListInfo record, @Param("example") OrderListInfoQuery example);

    int updateByExample(@Param("record") OrderListInfo record, @Param("example") OrderListInfoQuery example);
}