package com.lwyykj.core.dao.order;

import com.lwyykj.core.bean.order.Order;
import com.lwyykj.core.bean.order.OrderQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDao {
    int countByExample(OrderQuery example);

    int deleteByExample(OrderQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderQuery example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderQuery example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderQuery example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    //更新订单金额
    int updateByOid(@Param("id")Integer oid,@Param("totalFee")Double totalFee);
 // 修改订单的状态
 	int modifyOrder(@Param("id") Integer id, @Param("status") Integer status);
 	//根据支付统一流水号查询
 	List<Order> selectByPayNum(String payNum);
 	
}