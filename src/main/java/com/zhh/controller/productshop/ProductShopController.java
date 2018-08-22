package com.zhh.controller.productshop;

import com.alibaba.fastjson.JSON;
import com.zhh.controller.base.BaseController;
import com.zhh.entity.Menu;
import com.zhh.entity.ProductShop;
import com.zhh.service.product.ProductShopService;
import com.zhh.util.PageReturnParam;
import com.zhh.util.PageUtil;
import com.zhh.util.ReturnResult;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 合作商控制层
 */
@Controller
@RequestMapping("/pshop")
@Log4j
public class ProductShopController extends BaseController {

    @Autowired
    private ProductShopService productShopService;

    @RequestMapping("/index")
    public String pshopIndex(Model model){
        List<Menu> menuList = getUserMenus();
        model.addAttribute("menuList", menuList);
        return "/pshop/pshopList";
    }
    @RequestMapping(method = RequestMethod.POST,value="/addShop")
    @ResponseBody
    public ReturnResult addShop(ProductShop shop){
        log.info(JSON.toJSONString(shop));
        int count = productShopService.insert(shop);
        ReturnResult returnResult = new ReturnResult();
        returnResult.setStatus(0);
        if(count>0){
            returnResult.setMsg("添加成功");
        }else{
            returnResult.setMsg("添加失败");
        }
        return returnResult;
    }
    @RequestMapping(method = RequestMethod.POST,value="/editShop")
    @ResponseBody
    public ReturnResult editShop(ProductShop shop){
        int count = productShopService.updateByPrimaryKey(shop);
        ReturnResult returnResult = new ReturnResult();
        returnResult.setStatus(0);
        if(count>0){
            returnResult.setMsg("修改成功");
        }else{
            returnResult.setMsg("未找到数据");
        }
        return returnResult;
    }
    @RequestMapping("/getAllShop")
    @ResponseBody
    public List<ProductShop> getAllShop(){
        return productShopService.getAllShop();
    }

    @RequestMapping("/getShopById")
    @ResponseBody
    public ProductShop getShopById(Integer id){
        ProductShop shop = productShopService.selectByPrimaryKey(id);
        return shop;
    }
    /**
     * 根据id删除对应的供应商
     * @param id
     * @return
     */
    @RequestMapping("/deleteShop")
    @ResponseBody
    public ReturnResult deleteShop(Integer id){
        log.info("删除合作商=="+id);
        int count = productShopService.deleteByPrimaryKey(id);
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
     * 分页查询产品信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/shopPage")
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
        List<ProductShop> productList = productShopService.selectShopListPage(null,page);
        /*查询总条数*/
        count = productShopService.selectShopCount(null);

        return new PageReturnParam(page.getsEcho(),count,productList);
    }
}
