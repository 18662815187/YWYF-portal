package com.lwyykj.core.dao.product;

import com.lwyykj.core.bean.product.Product;
import com.lwyykj.core.bean.product.ProductQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDao {
    int countByExample(ProductQuery example);

    int deleteByExample(ProductQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductQuery example);

    Product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductQuery example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductQuery example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    //批删
    int deletes(Integer[] ids);
    //批量上架
    int upByIds(Integer[] ids);
    //批量下架
    int unShowByIds(Integer[] ids);
    //where in批量查询
    List<Product> selectByIds(Integer[] ids);
    //主键查询，只留ID和name
    Product findByPrimary(Integer id);
}