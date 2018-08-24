package com.zhh.service.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhh.dao.IPermissionDao;
import com.zhh.entity.base.Permission;

/**
* @ClassName: PermissionService
* @Description: 权限管理service实现
* @author zhh
* @date 2016-8-12 上午9:52:14
* 
*/
@SuppressWarnings("restriction")
@Service
public class PermissionService {
	/**
	* @Fields permissionDao : dao层注入
	*/
	@Resource
	private IPermissionDao permissionDao;
	
	public Permission addPermision(Permission permission) {
		return permissionDao.addPermision(permission);
	}

	
	public Permission updatePermission(Permission permission) {
		return permissionDao.updatePermission(permission);
	}

	
	public Permission deletePermission(Permission permission) {
		return permissionDao.deletePermission(permission);
	}

}
