package com.lwyykj.core.dao.order;

import com.lwyykj.core.bean.order.OrderProduct;
import com.lwyykj.core.bean.order.OrderProductQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderProductDao {
    int countByExample(OrderProductQuery example);

    int deleteByExample(OrderProductQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    List<OrderProduct> selectByExample(OrderProductQuery example);

    OrderProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderProduct record, @Param("example") OrderProductQuery example);

    int updateByExample(@Param("record") OrderProduct record, @Param("example") OrderProductQuery example);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);
    //通过oid查询
    List<OrderProduct> selectByOid(Integer oid);
}