package com.zhh.service.base;

import com.alibaba.fastjson.JSON;
import com.zhh.dao.IUserRoleDao;
import com.zhh.entity.UserRole;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class UserRoleService {
	
	@Autowired
	private IUserRoleDao userRoleDao;

	/**
	 * 添加用户角色对应关系
	 * @param userRole
	 * @return
	 */
	public UserRole addUserRole(UserRole userRole) {
		log.info("添加用户角色信息===="+JSON.toJSONString(userRole));
		try{
			return userRoleDao.addUserRole(userRole);
		}catch (Exception e) {
			log.error("添加用户角色信息失败====="+e.getMessage());
			return null;
		}
		
	}

	/**
	 * 根据用户账号删除用户所有角色
	 * @param userRole
	 * @return
	 */
	public boolean deleteUserRole(UserRole userRole) {
		log.info("删除用户角色信息===="+JSON.toJSONString(userRole));
		try{
			return userRoleDao.deleteUserRole(userRole);
		}catch (Exception e) {
			log.error("删除用户角色信息失败====="+e.getMessage());
			return false;
		}
	}

	/**
	 * 通过登录账号查询用户所有的角色id
	 * @param loginNo
	 * @return
	 */
	public List<String> selectRolesIdByLoginNo(String loginNo) {
		log.info("查询用户所拥有的角色信息===="+JSON.toJSONString(loginNo));
		try{
			return userRoleDao.selectRolesIdByLoginNo(loginNo);
		}catch (Exception e) {
			log.info("查询用户所拥有的角色信息失败===="+e.getMessage());
			return null;
		}
	}

}
