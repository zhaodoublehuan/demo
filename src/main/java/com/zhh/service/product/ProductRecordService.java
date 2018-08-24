package com.zhh.service.product;

import com.zhh.dao.IProductRecordDao;
import com.zhh.entity.product.ProductRecord;
import com.zhh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRecordService {

    @Autowired
    private IProductRecordDao productRecordDao;

    public List<ProductRecord> selectRecordListPage(ProductRecord record, PageUtil page) {
        return  productRecordDao.selectRecordListPage(record,page);
    }

    public int selectRecordCount(ProductRecord record) {
        return productRecordDao.selectRecordCount(record);
    }

    public int insert(ProductRecord record) {
        return productRecordDao.insert(record);
    }

    public int updateByPrimaryKey(ProductRecord record) {
        return productRecordDao.updateByPrimaryKey(record);
    }

    public ProductRecord selectByPrimaryKey(Integer id) {
        return productRecordDao.selectByPrimaryKey(id);
    }

    public int deleteByPrimaryKey(Integer id) {
        return productRecordDao.deleteByPrimaryKey(id);
    }

}
