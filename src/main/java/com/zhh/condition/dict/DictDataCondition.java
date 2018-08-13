package com.zhh.condition.dict;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 数据字典数据条件类
 */
@Getter
@Setter
@ToString
public class DictDataCondition {

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String remark;

    /**
     * 字典类型名称
     */
    private String typeName;

}
