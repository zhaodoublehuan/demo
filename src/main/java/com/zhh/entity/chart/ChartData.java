package com.zhh.entity.chart;

import com.zhh.entity.DictData;
import com.zhh.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ChartData {
    private BigDecimal price;

    private BigDecimal number;
    //进出货表示
    private DictData productInoutType;
    //产品信息
    private Product product;
}
