package com.zhh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class DictData {

    private Integer id;

    private String name;

    private String remark;

    private Integer typeId;

    private Integer seq;

    private Date insertDate;

    private Date updateDate;

}