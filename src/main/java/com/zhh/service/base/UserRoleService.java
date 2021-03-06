package com.zhh.service.base;

import com.alibaba.fastjson.JSON;
import com.zhh.dao.IUserRoleDao;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class UserRoleService {
	
	@Autowired
	private IUserRoleDao userRoleDao;

	/**
	 * 添加用户与角色对应关系
	 * @param roleIdList
	 * @param loginNo
	 */
	public void addUserRole(List<String> roleIdList, String loginNo) {
		userRoleDao.addUserRole(roleIdList,loginNo);
	}
	/**
	 * 根据用户账号删除用户所有角色
	 * @param loginNo
	 * @return
	 */
	public void deleteUserRoleByLoginNo(String loginNo) {
		userRoleDao.deleteUserRoleByLoginNo(loginNo);
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
