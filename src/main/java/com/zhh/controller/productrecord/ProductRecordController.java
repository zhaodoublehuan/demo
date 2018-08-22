package com.zhh.controller.productrecord;


import com.alibaba.fastjson.JSON;
import com.zhh.controller.base.BaseController;
import com.zhh.entity.Menu;
import com.zhh.entity.ProductRecord;
import com.zhh.service.product.ProductRecordService;
import com.zhh.util.PageReturnParam;
import com.zhh.util.PageUtil;
import com.zhh.util.ReturnResult;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 产品记录控制层
 */
@Controller
@RequestMapping("/precord")
@Log4j
public class ProductRecordController extends BaseController {

    @Autowired
    private ProductRecordService productRecordService;

    @RequestMapping("index")
    public String recordIndex(Model model){
        List<Menu> menuList = getUserMenus();
        model.addAttribute("menuList", menuList);
        return "/precord/precordList";
    }
    @RequestMapping("/addRecord")
    @ResponseBody
    public ReturnResult addRecord(ProductRecord record){
        log.info("添加记录"+JSON.toJSONString(record));
        int count = productRecordService.insert(record);
        ReturnResult returnResult = new ReturnResult();
        returnResult.setStatus(0);
        if(count>0){
            returnResult.setMsg("添加成功");
        }else{
            returnResult.setMsg("添加失败");
        }
        return returnResult;
    }
    @RequestMapping("/editRecord")
    @ResponseBody
    public ReturnResult editRecord(ProductRecord record){
        int count = productRecordService.updateByPrimaryKey(record);
        ReturnResult returnResult = new ReturnResult();
        returnResult.setStatus(0);
        if(count>0){
            returnResult.setMsg("修改成功");
        }else{
            returnResult.setMsg("修改失败");
        }
        return returnResult;
    }
    @RequestMapping("/getRecordById")
    @ResponseBody
    public ProductRecord getRecordById(Integer id){
        return productRecordService.selectByPrimaryKey(id);
    }
    @RequestMapping("/deleteReccord")
    @ResponseBody
    public ReturnResult deleteReccord(Integer id){
        log.info("删除记录id==="+id);
        int count = productRecordService.deleteByPrimaryKey(id);
        ReturnResult returnResult = new ReturnResult();
        returnResult.setStatus(0);
        if(count>0){
            returnResult.setMsg("删除成功");
        }else{
            returnResult.setMsg("未找到数据");
        }
        return returnResult;
    }
    /**
     * 分页查询记录信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/recordPage")
    @ResponseBody
    public PageReturnParam productPage(HttpServletRequest request, HttpServletResponse response){
        /*查询出来的数量*/
        int count = 10;
        /*接收前台datatabel传来分页用的参数*/
        String aoData=request.getParameter("aoData");
        log.info("前台分页参数"+aoData);
        /*转换需要的参数*/
        PageUtil page = PageUtil.getPageParams(aoData);
        /*查询符合条件的用户*/
        List<ProductRecord> recordList = productRecordService.selectRecordListPage(null,page);
        /*查询总条数*/
        count = productRecordService.selectRecordCount(null);
        return new PageReturnParam(page.getsEcho(),count,recordList);
    }
}
