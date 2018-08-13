package com.zhh.service;

import com.alibaba.fastjson.JSON;
import com.zhh.dao.IRoleDao;
import com.zhh.entity.Role;
import com.zhh.util.CommonParams;
import com.zhh.util.UUIDUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* @ClassName: RoleService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author zhh
* @date 2016-8-12 上午9:20:46
* 
*/
@SuppressWarnings("restriction")
@Service
public class RoleService {
	
	private static final Logger LOGGER = Logger.getLogger(RoleService.class);
	/**
	* @Fields roleDao : dao注入
	*/
	@Resource
	private IRoleDao roleDao;
	@Autowired
	private UserRoleService userRoleService;

	public Role addRole(Role role) {
		LOGGER.info("添加角色信息===="+JSON.toJSONString(role));
		try{
			Date now = new Date();
			role.setId(UUIDUtils.getUUID());
			role.setInsertDate(now);
			role.setActive(CommonParams.ACTIVE);
			role.setUpdateDate(now);
			return roleDao.addRole(role);
		}catch (Exception e) {
			LOGGER.error("添加角色失败===="+e.getMessage());
			return null;
		}
		
	}

	
	public Role updateRole(Role role) {
		LOGGER.info("修改角色信息===="+JSON.toJSONString(role));
		try{
			Date now = new Date();
			role.setUpdateDate(now);
			return roleDao.updateRole(role);
		}catch (Exception e) {
			LOGGER.error("修改角色失败===="+e.getMessage());
			return null;
		}
		
	}

	
	public boolean deleteRole(String roleId) {
		LOGGER.info("删除角色信息===="+roleId);
		try{
			return roleDao.deleteRole(roleId);
		}catch (Exception e) {
			LOGGER.error("删除角色失败===="+e.getMessage());
			return false;
		}
	}

	public List<Role> selectRolesIdByLoginNo(String loginNo) {
		LOGGER.info("查询用户所拥有的的角色信息===="+loginNo);
		try{
			List<String> roleIds = userRoleService.selectRolesIdByLoginNo(loginNo);
			if(roleIds==null){
				return null;
			}else{
				return roleDao.getRolesByRoleIds(roleIds);
			}
		}catch (Exception e) {
			LOGGER.info("查询用户所拥有的的角色信息失败===="+loginNo);
			return null;
		}
		
	}

}
