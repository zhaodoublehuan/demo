package com.zhh.service.product;

import com.zhh.dao.IProductDao;
import com.zhh.entity.product.Product;
import com.zhh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductDao productDao;

    public int deleteByPrimaryKey(Integer id) {
        return productDao.deleteByPrimaryKey(id);
    }

    public int insert(Product record) {
        record.setInsertDate(new Date());
        return productDao.insert(record);
    }

    public int insertSelective(Product record) {
        return productDao.insertSelective(record);
    }

    public Product selectByPrimaryKey(Integer id) {
        return productDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Product record) {
        return productDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Product record) {
        return productDao.updateByPrimaryKey(record);
    }

    public List<Product> selectProductListPage(Product record, PageUtil page) {
        return productDao.selectProductListPage(record,page);
    }

    public int selectProductCount(Product record) {
        return productDao.selectProductCount(record);
    }

    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

}
