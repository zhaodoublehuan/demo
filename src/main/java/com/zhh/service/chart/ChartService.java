package com.zhh.service.chart;

import com.zhh.dao.IChartDao;
import com.zhh.entity.chart.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartService {

    @Autowired
    private IChartDao chartDao;
    public List<ChartData> getChartData(Integer type) {
        return chartDao.getChartData(type);


    }

    public List<ChartData> getChartCount() {
        return chartDao.getChartCount();
    }
    }
