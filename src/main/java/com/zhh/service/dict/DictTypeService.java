package com.zhh.service.dict;

import com.zhh.condition.dict.DictTypeCondition;
import com.zhh.dao.IDictTypeDao;
import com.zhh.entity.dict.DictType;
import com.zhh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DictTypeService {

    @Autowired
    private IDictTypeDao dictTypeDao;

    /**
     * 产出字典类型
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    /**
     * 添加字典类型
     * @param record
     * @return
     */
    public int insert(DictType record) {
        record.setInsertDate(new Date());
        return dictTypeDao.insert(record);
    }

    /**
     * 根据id查询单个字典类型
     * @param id
     * @return
     */
    public DictType selectByPrimaryKey(Integer id) {
        return dictTypeDao.selectByPrimaryKey(id);
    }

    /**
     * 修改字典类型
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(DictType record) {
        record.setUpdateDate(new Date());
        return dictTypeDao.updateByPrimaryKeySelective(record);
    }

    public int selectPageCountByCondition(DictTypeCondition condition){
        return dictTypeDao.selectPageCountByCondition(condition);
    }

    public List<DictType> selectPageList(DictTypeCondition condition, PageUtil page) {
        return dictTypeDao.selectPageList(condition,page);
    }

}
