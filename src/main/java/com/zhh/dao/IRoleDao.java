package com.zhh.dao;

import java.util.List;

import com.zhh.condition.role.RoleCondition;
import com.zhh.entity.base.Role;
import com.zhh.util.PageUtil;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: IRoleDao
* @Description: 角色信息dao
* @author zhh
* @date 2016-8-12 上午9:22:36
* 
*/

public interface IRoleDao {
	
	int addRole(Role role);
	
	int updateRole(Role role);

	boolean deleteRole(String roleId);
	
	List<Role> getRolesByRoleIds(@Param("roleIds") List<String> roleIds);

    List<Role> selectPageList(@Param("condition") RoleCondition condition,@Param("page") PageUtil page);

	int selectPageCountByCondition(@Param("condition") RoleCondition condition);
}
