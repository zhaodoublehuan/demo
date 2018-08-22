package com.zhh.service.base;

import com.alibaba.fastjson.JSON;
import com.zhh.condition.menu.MenuCondition;
import com.zhh.dao.IMenuDao;
import com.zhh.entity.Menu;
import com.zhh.exception.ZhhException;
import com.zhh.util.PageUtil;
import com.zhh.util.UUIDUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @ClassName: MenuService
* @Description: 菜单管理实现类
* @author zhh
* @date 2016-8-13 上午10:33:43
* 
*/
@SuppressWarnings("restriction")
@Service
@Log4j
public class MenuService {

	@Autowired
	private IMenuDao menuDao;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleMenuService roleMenuService;

	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 */
	public Menu addMenu(Menu menu) throws ZhhException {
		log.info("添加菜单信息===="+JSON.toJSONString(menu));
		try{
			menu.setId(UUIDUtils.getUUID());
			menu.setInsertDate(new Date());
			return menuDao.addMenu(menu);			
		}catch (Exception e) {
			log.error("添加菜单信息失败==="+e.getMessage());
			throw new ZhhException("添加菜单失败");
		}
	}

	/**
	 * 修改菜单信息
	 * @param menu
	 * @return
	 */
	public Menu updateMenu(Menu menu) {
		log.info("修改菜单======"+JSON.toJSONString(menu));
		try{
			menu.setUpdateDate(new Date());
			return menuDao.updateMenu(menu);			
		}catch (Exception e) {
			log.error("修改菜单失败====="+e.getMessage());
			return null;
		}
	}

	/**
	 * 禁用菜单
	 * @param menuId
	 * @return
	 */
	public boolean lockMenu(String menuId) {
		log.info("删除菜单======"+menuId);
		try{
			menuDao.deleteMenu(menuId);
		}catch (Exception e) {
			log.error("删除菜单失败===="+e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 查询所有菜单信息
	 * @param condition
	 * @param page
	 * @return
	 */
	public List<Menu> selectMenus(MenuCondition condition, PageUtil page) {
		try {
			log.info("查询菜单条件======" + JSON.toJSONString(condition));
			List<Menu> menus = menuDao.selectMenus(condition, page);
			log.info("查询出的菜单为======" + JSON.toJSONString(menus));
			return menus;
		} catch (Exception e) {
			log.error("查询失败=====" + e.getMessage());
			return null;
		}
	}

	/**
	 * 根据查询条件查询数量
	 * @param condition
	 * @return
	 */
	public int selectMenusCount(MenuCondition condition) {
		return menuDao.selectMenusCount(condition);
	}

	/**
	 * 根据登录账户获取拥有的菜单权限
	 * @param loginNo
	 * @return
	 */
	public List<Menu> selectMenusByLoginNo(String loginNo) {

		/*根据登录账号查询用户所拥有的角色*/
		List<String> roleIds = userRoleService.selectRolesIdByLoginNo(loginNo);

		log.info("selectMenusByLoginNo---1======"+JSON.toJSONString(roleIds));
		if(roleIds!= null ){
			/*根据角色集合查询所有的菜单id*/
			List<String> menuIds = roleMenuService.selectMenuIdsByRoleIds(roleIds);
			log.info("selectMenusByLoginNo---2======"+JSON.toJSONString(menuIds));
			/*根据菜单id集合查询对应的菜单*/
			return selectMenusByIds(menuIds);
		} else {
			return new ArrayList<Menu>();
		}

	}

	/**
	 * 根据菜单id集合获取对应的菜单集合信息
	 * @param menuIds
	 * @return
	 */
	public List<Menu> selectMenusByIds(List<String> menuIds) {
		return menuDao.selectMenusByIds(menuIds);
	}

}
