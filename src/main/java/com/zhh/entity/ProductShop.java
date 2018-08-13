package com.zhh.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ProductShop {
    private Integer id;

    private String name;

    private String remark;

    private DictData shopType;

    private Date insertDate;

    private Date updateDate;

}