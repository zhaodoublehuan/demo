package com.zhh.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName: IRoleMenuDao
* @Description: 角色菜单dao
* @author zhh
* @date 2017-5-5 上午9:38:48
* 
*/

public interface IRoleMenuDao {
	/** 
	* @Title: selectMenuIdsByRoleIds 
	* @Description: 通过角色id查询对应的菜单集合
	* @param @param roleIds
	* @param @return    设定文件 
	* @return List<String>    返回类型 
	* @throws 
	*/ 
	
	public List<String> selectMenuIdsByRoleIds(@Param("roleIds") List<String> roleIds);
}
