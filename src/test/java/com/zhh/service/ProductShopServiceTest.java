package com.zhh.service;

import com.alibaba.fastjson.JSON;
import com.zhh.base.BaseTest;
import com.zhh.entity.DictData;
import com.zhh.entity.ProductShop;
import com.zhh.service.product.ProductShopService;
import com.zhh.util.PageUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ProductShopServiceTest extends BaseTest {

    @Autowired
    private ProductShopService productShopService;

    @Test
    public void selectShopListPage() {
        PageUtil page = new PageUtil();
        page.setRecordStart(0);
        page.setPageSize(10);
        List<ProductShop> products =productShopService.selectShopListPage(null,page);
        System.out.print(JSON.toJSONString(products));
    }

    @Test
    public void selectShopCount() {
        int count = productShopService.selectShopCount(null);
        System.out.print(count);
    }

    @Test
    public void deleteByPrimaryKey() {
        int id = 3;
        int count = productShopService.deleteByPrimaryKey(16);
        System.out.print(count);
    }

    @Test
    public void insert() {
        ProductShop shop = new ProductShop();
        DictData shopType = new DictData();
        shopType.setId(5);
        shop.setName("大连厂");
        shop.setRemark("大连厂的描述");
        shop.setShopType(shopType);
        shop.setInsertDate(new Date());
        int count = productShopService.insert(shop);
        System.out.print(count);
    }

    @Test
    public void selectByPrimaryKey() {
        ProductShop shop = productShopService.selectByPrimaryKey(3);
        System.out.print(JSON.toJSONString(shop));
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectAllShop() {
        List<ProductShop> products =productShopService.getAllShop();
        System.out.print(JSON.toJSONString(products));
    }
}