package com.zhh.service.product;

import com.zhh.dao.IProductShopDao;
import com.zhh.entity.product.ProductShop;
import com.zhh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductShopService {

    @Autowired
    private IProductShopDao productShopDao;

    public int deleteByPrimaryKey(Integer id) {
        return productShopDao.deleteByPrimaryKey(id);
    }

    public int insert(ProductShop record) {
        record.setInsertDate(new Date());
        return productShopDao.insert(record);
    }

    public ProductShop selectByPrimaryKey(Integer id) {
        return productShopDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(ProductShop record) {
        return 0;
    }

    public int updateByPrimaryKey(ProductShop record) {
        return productShopDao.updateByPrimaryKey(record);
    }

    public List<ProductShop> getAllShop(){
        return productShopDao.selectAllShop();
    }

    public List<ProductShop> selectShopListPage(ProductShop record, PageUtil page) {
        return productShopDao.selectShopListPage(record,page);
    }

    public int selectShopCount(ProductShop record) {
        return productShopDao.selectShopCount(record);
    }
}
