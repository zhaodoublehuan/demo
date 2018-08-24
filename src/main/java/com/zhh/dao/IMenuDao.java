package com.zhh.dao;

import java.util.List;

import com.zhh.condition.menu.MenuCondition;
import com.zhh.entity.base.Menu;
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

	Menu addMenu(Menu menu);
	
	Menu updateMenu(Menu menu);

	int deleteMenu(String menuId);

	List<Menu> selectPageList(@Param("condition")MenuCondition condition, @Param("page")PageUtil page);

	List<Menu> selectMenusByIds(@Param("menuIds") List<String> ids);

	int selectPageCountByCondition(@Param("condition")MenuCondition condition);

    Menu getMenuById(String menuId);
}
