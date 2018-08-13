package com.zhh.service;

import com.zhh.bean.dict.DictDataBean;
import com.zhh.condition.dict.DictDataCondition;
import com.zhh.dao.IDictDataDao;
import com.zhh.entity.DictData;
import com.zhh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictDataService{

    @Autowired
    private IDictDataDao dictDataDao;

    /**
     * 删除字典数据
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    /**
     *根据字典类型删除字典数据
     * @return
     */
    public int deleteDictDataByDictTypeId(Integer dictTypeId){
        return 0;
    }

    /**
     * 新增字典数据
     * @param record
     * @return
     */
    public int insert(DictData record) {
        return 0;
    }

    /**
     * 根据字典数据id获取字典数据
     * @param id
     * @return
     */
    public DictData selectByPrimaryKey(Integer id) {
        return null;
    }

    /**
     * 修改字典数据
     * @param record
     * @return
     */
    public int updateByPrimaryKey(DictData record) {
        return 0;
    }

    /**
     *根据条件查询数据数量
     * @param condition
     * @return
     */
    public int selectPageCountByCondition(DictDataCondition condition){
        return dictDataDao.selectPageCountByCondition(condition);
    }

    /**
     *根据查询条件获取分页数据
     * @param condition
     * @param page
     * @return
     */
    public List<DictDataBean> selectPageList(DictDataCondition condition, PageUtil page) {
        return dictDataDao.selectPageList(condition,page);
    }
}
