package com.zhh.service;

import com.alibaba.fastjson.JSON;
import com.zhh.base.BaseTest;
import com.zhh.entity.product.ProductRecord;
import com.zhh.service.product.ProductRecordService;
import com.zhh.util.PageUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductRecordServiceTest extends BaseTest {

    @Autowired
    private ProductRecordService productRecordService;
    @Test
    public void selectRecordListPage() {
        PageUtil page = new PageUtil();
        page.setRecordStart(0);
        page.setPageSize(10);
        List<ProductRecord> products =productRecordService.selectRecordListPage(null,page);
        System.out.print(JSON.toJSONString(products));
    }

    @Test
    public void selectRecordCount() {
        int count = productRecordService.selectRecordCount(null);
        System.out.print(count);
    }
}