package com.zhh.controller.base;

import com.zhh.entity.Menu;
import com.zhh.entity.UserEntity;
import com.zhh.exception.ZhhException;
import com.zhh.service.MenuService;
import com.zhh.service.UserService;
import com.zhh.util.PageReturnParam;
import com.zhh.util.PageUtil;
import com.zhh.util.ReturnResult;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
@Log4j
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
	/**
	 * 用户信息初始页面，显示所有用户
	*/ 
	@RequestMapping("/userList")
	@RequiresRoles("admin")
	public String userIndex(Model model){
		List<Menu> menuList = getUserMenus();
        model.addAttribute("menuList", menuList);
		return "user/userList";
	}

	/**
	 * 新建用户
	 * @param userEntity
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public  ReturnResult addUser(UserEntity userEntity){
		ReturnResult result = new ReturnResult();
		try {
			userService.add(userEntity);
			result.setStatus(0);
			result.setMsg("添加用户成功");
		} catch (ZhhException e) {
			result.setStatus(1);
			result.setMsg("添加用户失败");
		}
		
		return result;
	}

	/**
	 * 更新用户信息
	 * @param user
	 * @param response
	 * @return
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
	 * 锁定用户
	 * @param ids
	 * @return
	 */
	@RequestMapping("/lockUser")
	@ResponseBody
	public ReturnResult lockUser(@RequestBody List<String> ids){
		ReturnResult result = new ReturnResult();
		int rt = userService.lockUser(ids);
		if(rt>0){
			result.setStatus(0);
			result.setMsg("锁定用户成功");
		}else{
			result.setStatus(1);
			result.setMsg("锁定用户失败");
		}
		return result;
	}

	/**
	 * 批量解锁用户
	 * @param ids
	 * @return
	 */
	@RequestMapping("/unLockUser")
	@ResponseBody
	public ReturnResult unLockUser(@RequestBody List<String> ids){
		ReturnResult result = new ReturnResult();
		int rt = userService.unLockUser(ids);
		if(rt>0){
			result.setStatus(0);
			result.setMsg("解锁用户成功");
		}else{
			result.setStatus(1);
			result.setMsg("解锁用户失败");
		}
		return result;
	}

	/**
	 * 查询用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/userPage")
	@ResponseBody
	public PageReturnParam userPage(HttpServletRequest request){
		/*查询出来的数量*/ 
		int count = 10;
		/*接收前台datatabel传来分页用的参数*/
		String aoData=request.getParameter("aoData"); 
		log.info("前台分页参数"+aoData);
		/*转换需要的参数*/
		PageUtil page = PageUtil.getPageParams(aoData);
		/*查询符合条件的用户*/
		List<UserEntity> userList = userService.selectUsers(null,page);
		/*查询总条数*/
		count = userService.selectUsersCount(null);

		return new PageReturnParam(page.getsEcho(),count,userList);
	}
}
