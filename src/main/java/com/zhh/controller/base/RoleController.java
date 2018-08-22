package com.zhh.controller.base;

import com.zhh.entity.Role;
import com.zhh.service.RoleService;
import com.zhh.util.PageReturnParam;
import com.zhh.util.PageUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	/**
	 * 添加角色信息
	 * @param role
	 */
	@RequestMapping(value="/addRole", method = RequestMethod.POST)
	@ResponseBody
	public Role addRole(Role role){
		Role roleEntity = roleService.addRole(role);
		return roleEntity;
	}

	/**
	 * 查询角色列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/rolePage")
	@ResponseBody
	public PageReturnParam rolePage(HttpServletRequest request){

		/*接收前台datatabel传来分页用的参数*/
		String aoData=request.getParameter("aoData");
		/*转换需要的参数*/
		PageUtil page = PageUtil.getPageParams(aoData);
		/*查询总条数*/
		int count = roleService.selectRolesCount(null);

		List<Role> userList = new ArrayList<Role>();

		if(count>0){
			/*查询符合条件的用户*/
			userList = roleService.selectRolePage(null,page);
		}
		return new PageReturnParam(page.getsEcho(),count,userList);
	}
}
