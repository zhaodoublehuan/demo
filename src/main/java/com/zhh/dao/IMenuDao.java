package com.zhh.dao;

import java.util.List;

import com.zhh.entity.Menu;
import com.zhh.util.PageUtil;
import org.apache.ibatis.annotations.Param;

/**
* @ClassName: IMenuDao
* @Description: 菜单管理dao层
* @author zhh
* @date 2016-8-13 上午10:34:15
* 
*/

public interface IMenuDao {
	
	/** 
	* @Title: addMenu 
	* @Description: 添加菜单
	* @param @param menu
	* @param @return    设定文件 
	* @return Menu    返回类型 
	* @throws 
	*/ 
	
	Menu addMenu(Menu menu);
	
	/** 
	* @Title: updateMenu 
	* @Description: 修改菜单 
	* @param @param menu
	* @param @return    设定文件 
	* @return Menu    返回类型 
	* @throws 
	*/ 
	
	Menu updateMenu(Menu menu);
	
	/** 
	* @Title: deleteMenu 
	* @Description: 删除菜单
	* @param @param menuId
	* @param @return    设定文件 
	* @return Menu    返回类型 
	* @throws 
	*/ 
	
	boolean deleteMenu(String menuId);
	
	/** 
	* @Title: selectMenus 
	* @Description: 查询菜单集合，根据查询条件
	* @param @param menu
	* @param @return    设定文件 
	* @return List<Menu>    返回类型 
	* @throws 
	*/ 
	
	List<Menu> selectMenus(Menu menu, PageUtil page);
	
	/** 
	* @Title: selectMenusByIds 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @return    设定文件 
	* @return List<Menu>    返回类型 
	* @throws 
	*/ 
	
	List<Menu> selectMenusByIds(@Param("menuIds") List<String> ids);
}
