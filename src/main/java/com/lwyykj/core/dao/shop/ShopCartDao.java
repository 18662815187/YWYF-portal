package com.lwyykj.core.dao.shop;

import com.lwyykj.core.bean.shop.ShopCart;
import com.lwyykj.core.bean.shop.ShopCartQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCartDao {
    int countByExample(ShopCartQuery example);

    int deleteByExample(ShopCartQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    List<ShopCart> selectByExample(ShopCartQuery example);

    ShopCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopCart record, @Param("example") ShopCartQuery example);

    int updateByExample(@Param("record") ShopCart record, @Param("example") ShopCartQuery example);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);
}