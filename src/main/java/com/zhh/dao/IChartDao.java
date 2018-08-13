package com.zhh.dao;

import com.zhh.entity.chart.ChartData;

import java.util.List;

public interface IChartDao {
    List<ChartData> getChartData(Integer type);

    List<ChartData> getChartCount();

}
