package com.zhh.controller.base;

import com.zhh.entity.Menu;
import com.zhh.entity.UserEntity;
import com.zhh.exception.UserException;
import com.zhh.service.MenuService;
import com.zhh.service.UserService;
import com.zhh.util.PageReturnParam;
import com.zhh.util.PageUtil;
import com.zhh.util.ReturnResult;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	/**
	* @Fields userService : 用户信息service
	*/
	@Autowired
	private UserService userService;
	
	/**
	* @Fields menuService : 菜单信息service
	*/
	@Autowired
	private MenuService menuService;
	
	/** 
	* @Title: userIndex 
	* @Description:用户信息初始页面，显示所有用户
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	@RequestMapping("/userList")
	@RequiresRoles("admin")
	public String userIndex(Model model){
		List<Menu> menuList = getUserMenus();
        model.addAttribute("menuList", menuList);
		return "user/userList";
	}
	/** 
	* @Title: addUser 
	* @Description: 新建用户
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	
	@RequestMapping(method = RequestMethod.POST,value="/addUser")
	@ResponseBody
	public  ReturnResult addUser(UserEntity user){
		ReturnResult result = new ReturnResult();
		try {
			userService.add(user);
			result.setStatus(0);
			result.setMsg("添加用户成功");
		} catch (UserException e) {
			result.setStatus(1);
			result.setMsg("添加用户失败");
		}
		
		return result;
	}
	/** 
	* @Title: updateUser 
	* @Description: 更新用户信息 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public ReturnResult updateUser(@RequestBody UserEntity user,HttpServletResponse response){
		ReturnResult result = new ReturnResult();
		int rt = userService.update(user);
		if(rt==1){
			result.setStatus(0);
			result.setMsg("修改用户成功");
		}else{
			result.setStatus(1);
			result.setMsg("修改用户失败");
		}
		return result;
	}
	
	/** 
	* @Title: deleteUser 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	@ResponseBody
	public ReturnResult deleteUser(@RequestBody List<String> ids,HttpServletResponse response){
		ReturnResult result = new ReturnResult();
		int rt = userService.delete(ids);
		if(rt>0){
			result.setStatus(0);
			result.setMsg("删除用户成功");
		}else{
			result.setStatus(1);
			result.setMsg("删除用户失败");
		}
		return result;
	}
	
	/** 
	* @Title: userPage 
	* @Description: 分页查询用户列表
	* @param @param response    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	@RequestMapping("/userPage")
	@ResponseBody
	public PageReturnParam userPage(HttpServletRequest request,HttpServletResponse response){
		/*查询出来的数量*/ 
		int count = 10;
		/*接收前台datatabel传来分页用的参数*/
		String aoData=request.getParameter("aoData"); 
		LOGGER.info("前台分页参数"+aoData);
		/*转换需要的参数*/
		PageUtil page = PageUtil.getPageParams(aoData);
		/*查询符合条件的用户*/
		List<UserEntity> userList = userService.selectUsers(null,page);
		/*查询总条数*/
		count = userService.selectUsersCount(null);

		return new PageReturnParam(page.getsEcho(),count,userList);
	}
}
