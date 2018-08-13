package com.zhh.controller.chart;

import com.zhh.controller.base.BaseController;
import com.zhh.entity.Menu;
import com.zhh.entity.chart.ChartData;
import com.zhh.service.ChartService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/chart")
public class ChartController extends BaseController {

    @Autowired
    private ChartService chartServicce;
    @RequestMapping("index")
    public String chartIndex(Model model){
        List<Menu> menuList = getUserMenus();
        model.addAttribute("menuList", menuList);
        return "/chart/chart";
    }
    @RequestMapping("getProductSum")
    @ResponseBody
    public List<ChartData> getProductSum(Integer type){
        return chartServicce.getChartData(type);
    }

    @RequestMapping("getChartCount")
    @ResponseBody
    public  List<ChartData> getChartCount(){
        return chartServicce.getChartCount();
    }
}
