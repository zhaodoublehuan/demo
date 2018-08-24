package com.zhh.dao;

import com.zhh.entity.base.Permission;

/**
* @ClassName: IPermissionDao
* @Description: 权限管理信息dao层
* @author zhh
* @date 2016-8-12 上午9:48:25
* 
*/

public interface IPermissionDao {
	/** 
	* @Title: addPermision 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return Permission    返回类型 
	* @throws 
	*/ 
	
	Permission addPermision(Permission permission);
	
	/** 
	* @Title: updatePermission 
	* @Description: 修改权限信息
	* @param @param permission
	* @param @return    设定文件 
	* @return Permission    返回类型 
	* @throws 
	*/ 
	
	Permission updatePermission(Permission permission);
	
	/** 
	* @Title: deletePermission 
	* @Description: 删除权限信息
	* @param @param permission
	* @param @return    设定文件 
	* @return Permission    返回类型 
	* @throws 
	*/ 
	
	Permission deletePermission(Permission permission);
}
