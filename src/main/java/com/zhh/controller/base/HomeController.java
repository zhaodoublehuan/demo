package com.zhh.controller.base;

import com.alibaba.fastjson.JSON;
import com.zhh.entity.Menu;
import com.zhh.entity.UserEntity;
import com.zhh.service.MenuService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
* @ClassName: HomeController
* @Description: 登录--首页控制层
* @author zhh
* @date 2016年8月12日 下午7:41:06
* 
*/

@SuppressWarnings("restriction")
@Controller
public class HomeController extends BaseController{
	
	private static final Logger LOGGER = Logger.getLogger(HomeController.class);
	
	@Resource
	private MenuService menuService;
	/** 
	* @Title: loginForm 
	* @Description: 跳转登录页面控制 
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	
	@RequestMapping(value="/login",method=RequestMethod.GET)  
    public String loginForm(){  
        return "login";  
    }  
      
    /** 
    * @Title: login 
    * @Description: 登录验证 
    * @param @param user
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws 
    */ 
    
    @RequestMapping(value="/login",method=RequestMethod.POST)  
    public String login(UserEntity user,Model model) {  
        try {  
            //使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！  
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUserName(), user.getPassword()));
            LOGGER.info("登录用户==="+JSON.toJSONString(user));
            //根据当前登录用户查询其所能看到得菜单
            List<Menu> menuList = getUserMenus();
            model.addAttribute("menuList", menuList);
            return "/chart/chart";
        } catch (Exception e) {  
        	e.printStackTrace();
            return "login";  
        }  
    }  
      
    /** 
    * @Title: logout 
    * @Description: 退出登录方法
    * @param @param redirectAttributes
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws 
    */ 
    
    @RequestMapping(value="/logout",method=RequestMethod.GET)    
    public String logout(RedirectAttributes redirectAttributes ){   
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息  
        SecurityUtils.getSubject().logout();    
        redirectAttributes.addFlashAttribute("message", "您已安全退出");    
        return "login";  
    }   
      
    /** 
    * @Title: unauthorizedRole 
    * @Description: 用户无操作权限
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws 
    */ 
    
    @RequestMapping("/403")  
    public String unauthorizedRole(){  
        return "403";  
    }  
}
