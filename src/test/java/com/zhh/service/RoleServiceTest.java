package com.zhh.service;

import com.zhh.base.BaseTest;
import com.zhh.entity.Role;
import com.zhh.service.RoleService;
import org.junit.Test;

import javax.annotation.Resource;

@SuppressWarnings("restriction")
public class RoleServiceTest extends BaseTest{
	
	@Resource
	private RoleService roleService;
	@Test
	public void testAddRole() {
		Role role = new Role();
		role.setName("测试角色");
		role.setDescription("用来测试的角色");
		roleService.addRole(role);
	}

	@Test
	public void testUpdateRole() {
		Role role = new Role();
		role.setId("63ffc310d76d4712b541f8cd94573a40");
		role.setName("测试角色修改");
		role.setDescription("测试描述修改");
		roleService.updateRole(role);
	}

	@Test
	public void testDeleteRole() {
		roleService.deleteRole("63ffc310d76d4712b541f8cd94573a40");
	}

	@Test
	public void testTelectRolesByLoginNo(){
		roleService.selectRolesIdByLoginNo("zhh");
	}

}
