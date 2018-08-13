package com.zhh.dao;

import com.zhh.entity.Product;
import com.zhh.entity.ProductShop;
import com.zhh.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductShopDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductShop record);

    int insertSelective(ProductShop record);

    ProductShop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductShop record);

    int updateByPrimaryKey(ProductShop record);

    List<ProductShop> selectShopListPage(@Param("shop")ProductShop record, @Param("page")PageUtil page);

    int selectShopCount(ProductShop record);

    List<ProductShop> selectAllShop();

}