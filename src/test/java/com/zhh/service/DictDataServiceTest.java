package com.zhh.service;

import com.zhh.base.BaseTest;
import com.zhh.bean.dict.DictDataBean;
import com.zhh.condition.dict.DictDataCondition;
import com.zhh.service.dict.DictDataService;
import com.zhh.util.PageUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DictDataServiceTest extends BaseTest {

    @Autowired
    private DictDataService dictDataService;

    @Test
    public void selectPageCountByCondition() {
        DictDataCondition condition = new DictDataCondition();
        condition.setTypeName("测试");
        int count = dictDataService.selectPageCountByCondition(condition);
        System.out.print(count);
    }

    @Test
    public void selectPageList() {
        DictDataCondition condition = new DictDataCondition();
        condition.setTypeName("测试");
        PageUtil page = new PageUtil();
        page.setRecordStart(0);
        page.setPageSize(10);
        List<DictDataBean> list = dictDataService.selectPageList(condition,page);
        System.out.print(list);
    }
}