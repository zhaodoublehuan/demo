package com.zhh.dao;

import com.zhh.entity.product.ProductRecord;
import com.zhh.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductRecordDao {

    List<ProductRecord> selectRecordListPage(@Param("record") ProductRecord record, @Param("page") PageUtil page);

    int selectRecordCount(ProductRecord record);

    int insert(ProductRecord record);

    int updateByPrimaryKey(ProductRecord record);

    ProductRecord selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);
}