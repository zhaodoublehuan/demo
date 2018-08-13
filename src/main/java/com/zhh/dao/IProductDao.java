package com.zhh.dao;

import com.zhh.entity.Product;
import com.zhh.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectProductListPage(@Param("product") Product record, @Param("page") PageUtil page);

    int selectProductCount(Product record);

    List<Product> getAllProduct();
}