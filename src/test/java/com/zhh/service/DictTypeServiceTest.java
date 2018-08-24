package com.zhh.service;

import com.zhh.base.BaseTest;
import com.zhh.condition.dict.DictTypeCondition;
import com.zhh.entity.dict.DictType;
import com.zhh.service.dict.DictTypeService;
import com.zhh.util.PageUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DictTypeServiceTest extends BaseTest {

    @Autowired
    private DictTypeService dictTypeService;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        DictType dictType = new DictType();
        dictType.setName("测试字典类型");
        dictType.setSeq(0);
        dictType.setRemark("单元测试数据");
        dictTypeService.insert(dictType);
    }

    @Test
    public void selectByPrimaryKey() {
        DictType dictType = dictTypeService.selectByPrimaryKey(3);
        System.out.print(dictType.toString());
    }

    @Test
    public void updateByPrimaryKeySelective() {
        DictType dictType = new DictType();
        dictType.setId(3);
        dictType.setName("测试字典类型");
        dictType.setSeq(0);
        dictType.setRemark("单元测试数据修改");
        dictTypeService.updateByPrimaryKeySelective(dictType);
    }

    @Test
    public void selectPageCountByCondition() {
        DictTypeCondition condition = new DictTypeCondition();
        condition.setName("测试");
        int count = dictTypeService.selectPageCountByCondition(condition);
        System.out.print(count+"%%%%");
    }

    @Test
    public void selectPageList() {
        DictTypeCondition condition = new DictTypeCondition();
        condition.setName("测试");
        PageUtil page = new PageUtil();
        page.setRecordStart(0);
        page.setPageSize(10);
        List<DictType> list = dictTypeService.selectPageList(condition,page);
        System.out.print(list.toString()+"%%%%");
    }
}