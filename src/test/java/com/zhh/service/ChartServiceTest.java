package com.zhh.service;

import com.alibaba.fastjson.JSON;
import com.zhh.base.BaseTest;
import com.zhh.entity.chart.ChartData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ChartServiceTest extends BaseTest {
    @Autowired
    private ChartService chartService;
    @Test
    public void getChartData() {
        List<ChartData> list = chartService.getChartData(7);
        System.out.print(JSON.toJSON(list));
    }

    @Test
    public void getChartCount() {
        List<ChartData> list = chartService.getChartCount();
        System.out.print(JSON.toJSON(list));
    }
}