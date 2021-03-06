package com.zhh.service.base;

import com.alibaba.fastjson.JSON;
import com.zhh.condition.role.RoleCondition;
import com.zhh.dao.IRoleDao;
import com.zhh.entity.base.Role;
import com.zhh.util.CommonParams;
import com.zhh.util.PageUtil;
import com.zhh.util.UUIDUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SuppressWarnings("restriction")
@Service
@Log4j
public class RoleService {

	@Resource
	private IRoleDao roleDao;
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * 新增角色信息
	 * @param role
	 * @return
	 */
	public void addRole(Role role) {
		log.info("添加角色信息===="+JSON.toJSONString(role));
		try{
			Date now = new Date();
			role.setId(UUIDUtils.getUUID());
			role.setInsertDate(now);
			role.setActive(CommonParams.ACTIVE);
			role.setUpdateDate(now);
			roleDao.addRole(role);
		}catch (Exception e) {
			log.error("添加角色失败===="+e.getMessage());
		}
		
	}

	/**
	 * 修改角色信息
	 * @param role
	 * @return
	 */
	public void updateRole(Role role) {
		log.info("修改角色信息===="+JSON.toJSONString(role));
		try{
			Date now = new Date();
			role.setUpdateDate(now);
			roleDao.updateRole(role);
		}catch (Exception e) {
			log.error("修改角色失败===="+e.getMessage());
		}
		
	}

	/**
	 * 锁定角色信息
	 * @param roleId
	 * @return
	 */
	public boolean deleteRole(String roleId) {
		log.info("删除角色信息===="+roleId);
		try{
			return roleDao.deleteRole(roleId);
		}catch (Exception e) {
			log.error("删除角色失败===="+e.getMessage());
			return false;
		}
	}

	/**
	 * 通过账号查询用户所拥有的角色集合
	 * @param loginNo
	 * @return
	 */
	public List<Role> selectRolesByLoginNo(String loginNo) {
		log.info("查询用户所拥有的的角色信息===="+loginNo);
		try{
			List<String> roleIds = userRoleService.selectRolesIdByLoginNo(loginNo);
			if(roleIds==null){
				return null;
			}else{
				return roleDao.getRolesByRoleIds(roleIds);
			}
		}catch (Exception e) {
			log.info("查询用户所拥有的的角色信息失败===="+loginNo);
			return null;
		}
		
	}

	/**
	 * 获取角色分页数据
	 * @param condition
	 * @param page
	 * @return
	 */
	public List<Role> selectPageList(RoleCondition condition, PageUtil page) {
		return roleDao.selectPageList(condition,page);
	}

	/**
	 * 查询符合条件的数据量
	 * @param condition
	 * @return
	 */
	public int selectPageCountByCondition(RoleCondition condition) {
		return roleDao.selectPageCountByCondition(condition);
	}
}
