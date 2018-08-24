package com.zhh.entity.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhh.entity.dict.DictData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
public class ProductRecord {

    private Integer id;
    //产品
    private Product product;
    //数量
    private BigDecimal productCount;
    //价格
    private BigDecimal productPrice;
    //合作商
    private ProductShop productShop;
    //进出货表示
    private DictData productInoutType;
    //进出货时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inoutDate;
    //新增时间
    private Date insertDate;
    //修改时间
    private Date updateDate;

}