package com.zhh.service.base;

import java.util.List;

import com.zhh.dao.IRoleMenuDao;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class RoleMenuService {

	@Autowired
	private IRoleMenuDao roleMenuDao;

	/**
	 * 根据角色id查询角色所有的菜单信息
	 * @param roleIds
	 * @return
	 */
	public List<String> selectMenuIdsByRoleIds(List<String> roleIds) {
		return roleMenuDao.selectMenuIdsByRoleIds(roleIds);
	}

}
