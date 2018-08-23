package com.zhh.service;

import com.zhh.base.BaseTest;
import com.zhh.entity.Permission;
import com.zhh.service.base.PermissionService;
import com.zhh.util.UUIDUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
@SuppressWarnings("restriction")
public class PermissionServiceTest extends BaseTest{
	
	@Resource
	private PermissionService permissionService;

	@Test
	public void testAddPermision() {
		Permission permission = new Permission();
		Date date = new Date();
		permission.setId(UUIDUtils.getUUID());
		permission.setName("query");
		permission.setDescription("����Ȩ������");
		permission.setInsertDate(date);
		permission.setUpdateDate(date);
		permissionService.addPermision(permission);
	}

	@Test
	public void testUpdatePermission() {
		Permission permission = new Permission();
		Date date = new Date();
		permission.setId(UUIDUtils.getUUID());
		permission.setName("����Ȩ��");
		permission.setDescription("����Ȩ������");
		permission.setInsertDate(date);
		permission.setUpdateDate(date);
		permissionService.updatePermission(permission);
	}

	@Test
	public void testDeletePermission() {
		Permission permission = new Permission();
		Date date = new Date();
		permission.setId(UUIDUtils.getUUID());
		permission.setName("����Ȩ��");
		permission.setDescription("����Ȩ������");
		permission.setInsertDate(date);
		permission.setUpdateDate(date);
		permissionService.deletePermission(permission);
	}

}
