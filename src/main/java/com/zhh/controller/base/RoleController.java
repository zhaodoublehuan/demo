package com.zhh.controller.base;

import com.zhh.entity.Role;
import com.zhh.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
* @ClassName: RoleController
* @Description: 角色管理控制层
* @author zhh
* @date 2016年8月12日 下午7:36:52
* 
*/

@Controller
@RequestMapping("/role")
public class RoleController {
	private static final Logger LOGGER = Logger.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 添加角色信息
	 * @param role
	 */
	@RequestMapping(value="/addRole", method = RequestMethod.POST)
	@ResponseBody
	public Role addRole(@RequestBody Role role){
		LOGGER.info("添加角色信息");
		Role roleEntity = roleService.addRole(role);
		return roleEntity;
	}
}
