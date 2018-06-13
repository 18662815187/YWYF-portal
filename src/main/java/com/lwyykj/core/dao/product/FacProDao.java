package com.lwyykj.core.dao.product;

import com.lwyykj.core.bean.product.FacPro;
import com.lwyykj.core.bean.product.FacProQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FacProDao {
    int countByExample(FacProQuery example);

    int deleteByExample(FacProQuery example);

    int insert(FacPro record);

    int insertSelective(FacPro record);

    List<FacPro> selectByExample(FacProQuery example);

    int updateByExampleSelective(@Param("record") FacPro record, @Param("example") FacProQuery example);

    int updateByExample(@Param("record") FacPro record, @Param("example") FacProQuery example);
}