package com.zhh.dao;

import java.util.List;

import com.zhh.entity.Role;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: IRoleDao
* @Description: 角色信息dao
* @author zhh
* @date 2016-8-12 上午9:22:36
* 
*/

public interface IRoleDao {
	
	/** 
	* @Title: add 
	* @Description: 添加新的角色信息
	* @param @param role
	* @param @return    设定文件 
	* @return Role    返回类型 
	* @throws 
	*/ 
	
	Role addRole(Role role);
	
	/** 
	* @Title: update 
	* @Description: 修改角色信息
	* @param @param role
	* @param @return    设定文件 
	* @return Role    返回类型 
	* @throws 
	*/ 
	
	Role updateRole(Role role);
	
	/** 
	* @Title: delete 
	* @Description: 删除角色信息 
	* @param @param role
	* @param @return    设定文件 
	* @return Role    返回类型 
	* @throws 
	*/ 
	
	boolean deleteRole(String roleId);

	/** 
	* @Title: getRolesByRoleIds 
	* @Description: 根据角色id查询角色信息 
	* @param @param roleIds
	* @param @return    设定文件 
	* @return List<Role>    返回类型 
	* @throws 
	*/ 
	
	List<Role> getRolesByRoleIds(@Param("roleIds") List<String> roleIds);
}
