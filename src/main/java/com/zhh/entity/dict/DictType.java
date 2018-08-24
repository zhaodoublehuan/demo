package com.zhh.entity.dict;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class DictType {
    private Integer id;

    private String name;

    private String remark;

    private Integer seq;

    private Date insertDate;

    private Date updateDate;

}