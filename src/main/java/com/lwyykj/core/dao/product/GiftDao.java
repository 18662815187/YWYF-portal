package com.lwyykj.core.dao.product;

import com.lwyykj.core.bean.product.Gift;
import com.lwyykj.core.bean.product.GiftQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiftDao {
    int countByExample(GiftQuery example);

    int deleteByExample(GiftQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gift record);

    int insertSelective(Gift record);

    List<Gift> selectByExample(GiftQuery example);

    Gift selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gift record, @Param("example") GiftQuery example);

    int updateByExample(@Param("record") Gift record, @Param("example") GiftQuery example);

    int updateByPrimaryKeySelective(Gift record);

    int updateByPrimaryKey(Gift record);
}