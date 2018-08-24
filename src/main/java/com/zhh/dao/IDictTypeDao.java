package com.zhh.dao;

import com.zhh.condition.dict.DictTypeCondition;
import com.zhh.entity.dict.DictType;
import com.zhh.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDictTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DictType record);

    DictType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictType record);

    int selectPageCountByCondition(@Param("condition") DictTypeCondition condition);

    List<DictType> selectPageList(@Param("condition")DictTypeCondition condition, @Param("page")PageUtil page);
}