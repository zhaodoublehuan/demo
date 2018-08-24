package com.zhh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IUserRoleDao {

	public List<String> selectRolesIdByLoginNo(@Param("loginNo") String loginNo);

    void addUserRole(@Param("roleIdList") List<String> roleIdList,@Param("loginNo") String loginNo);

	void deleteUserRoleByLoginNo(String loginNo);
}
