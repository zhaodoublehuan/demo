package com.zhh.controller.base;

import com.zhh.entity.base.Menu;
import com.zhh.service.base.MenuService;
import com.zhh.util.ReturnResult;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;

import javax.annotation.Resource;
import java.util.List;

/**
* @ClassName: HomeController
* @Description: 登录--首页控制层
* @author zhh
* @date 2016年8月12日 下午7:41:06
* 
*/

public class BaseController {
	
	private static final Logger LOGGER = Logger.getLogger(BaseController.class);
	
	@Resource
	private MenuService menuService;

	/**
	 * 获取当前登录人菜单权限集合
	 * @return
	 */
	public List<Menu> getUserMenus(){
        String  login_no = (String)SecurityUtils.getSubject().getPrincipal();
        LOGGER.error(login_no+"当前登录人");
        List<Menu> menuList = menuService.selectMenusByLoginNo(login_no);
	    return menuList;
    }

	protected ReturnResult getReturnResult(int count) {
		ReturnResult returnResult = new ReturnResult();
		returnResult.setStatus(0);
		if (count > 0) {
			returnResult.setMsg("操作成功");
		} else {
			returnResult.setMsg("操作失败");
		}
		return returnResult;
	}
}
