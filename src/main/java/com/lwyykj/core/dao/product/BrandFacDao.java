package com.lwyykj.core.dao.product;

import com.lwyykj.core.bean.product.BrandFac;
import com.lwyykj.core.bean.product.BrandFacQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandFacDao {
    int countByExample(BrandFacQuery example);

    int deleteByExample(BrandFacQuery example);

    int insert(BrandFac record);

    int insertSelective(BrandFac record);

    List<BrandFac> selectByExample(BrandFacQuery example);

    int updateByExampleSelective(@Param("record") BrandFac record, @Param("example") BrandFacQuery example);

    int updateByExample(@Param("record") BrandFac record, @Param("example") BrandFacQuery example);
}