package com.zhh.dao;

import com.zhh.bean.dict.DictDataBean;
import com.zhh.condition.dict.DictDataCondition;
import com.zhh.entity.DictData;
import com.zhh.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDictDataDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DictData record);

    int insertSelective(DictData record);

    DictData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictData record);

    int updateByPrimaryKey(DictData record);

    int selectPageCountByCondition(@Param("condition") DictDataCondition condition);

    List<DictDataBean> selectPageList(@Param("condition") DictDataCondition condition, @Param("page") PageUtil page);
}