package com.zhh.controller.dict;


import com.zhh.controller.base.BaseController;
import com.zhh.entity.DictType;
import com.zhh.entity.Menu;
import com.zhh.service.DictTypeService;
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
 * 字典类型控制层
 */
@Controller
@RequestMapping("/dictType")
@Log4j
public class DictTypeController extends BaseController {

    @Autowired
    private DictTypeService dictTypeService;

    @RequestMapping("index")
    public String dictTypeIndex(Model model){
        List<Menu> menuList = getUserMenus();
        model.addAttribute("menuList", menuList);
        return "dtype/dtypeList";
    }

    /**
     * 添加字典类型
     * @return
     */
    @RequestMapping("/addDictType")
    @ResponseBody
    public ReturnResult addDictType(Integer id){
        log.info("删除产品id==="+id);
        int count = dictTypeService.deleteByPrimaryKey(id);
        ReturnResult returnResult = getReturnResult(count);
        return returnResult;
    }

    /**
     * 修改字典类型
     * @return
     */
    @RequestMapping("/editDictType")
    @ResponseBody
    public ReturnResult editDictType(Integer id){
        log.info("删除产品id==="+id);
        int count = dictTypeService.deleteByPrimaryKey(id);
        ReturnResult returnResult = getReturnResult(count);
        return returnResult;
    }
    /**
     * 删除字典类型
     * @return
     */
    @RequestMapping("/deleteDictType")
    @ResponseBody
    public ReturnResult deleteDictType(Integer id){
        log.info("删除产品id==="+id);
        int count = dictTypeService.deleteByPrimaryKey(id);
        ReturnResult returnResult = getReturnResult(count);
        return returnResult;
    }

    /**
     * 字典类型数据分页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("dtdataPage")
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
        List<DictType> productList = dictTypeService.selectPageList(null,page);
        /*查询总条数*/
        count = dictTypeService.selectPageCountByCondition(null);

        return new PageReturnParam(page.getsEcho(),count,productList);
    }
}
