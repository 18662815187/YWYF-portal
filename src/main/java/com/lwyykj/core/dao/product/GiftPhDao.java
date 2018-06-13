package com.lwyykj.core.dao.product;

import com.lwyykj.core.bean.product.GiftPh;
import com.lwyykj.core.bean.product.GiftPhQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiftPhDao {
    int countByExample(GiftPhQuery example);

    int deleteByExample(GiftPhQuery example);

    int insert(GiftPh record);

    int insertSelective(GiftPh record);

    List<GiftPh> selectByExample(GiftPhQuery example);

    int updateByExampleSelective(@Param("record") GiftPh record, @Param("example") GiftPhQuery example);

    int updateByExample(@Param("record") GiftPh record, @Param("example") GiftPhQuery example);
}