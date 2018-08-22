package com.zhh.controller.base;

import com.zhh.entity.Menu;
import com.zhh.exception.ZhhException;
import com.zhh.service.base.MenuService;
import com.zhh.service.base.UserService;
import com.zhh.util.PageReturnParam;
import com.zhh.util.PageUtil;
import com.zhh.util.ReturnResult;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/menu")
@Log4j
public class MenuController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private MenuService menuService;

	/**
	 * 用户信息初始页面，显示所有用户
	 */
	@RequestMapping("/menuList")
	@RequiresRoles("admin")
	public String menuIndex(Model model){
		List<Menu> menuList = getUserMenus();
		model.addAttribute("menuList", menuList);
		return "menu/menuList";
	}

	/**
	 * 添加菜单信息
	 * @return
	 */
	@RequestMapping("addMenu")
	@ResponseBody
	public ReturnResult addMenu(Menu menu) throws ZhhException {
		ReturnResult result = new ReturnResult();
		menuService.addMenu(menu);
		result.setStatus(0);
		result.setMsg("添加菜单成功");
		return result;
	}

	/**
	 * 查询菜单列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/menuPage")
	@ResponseBody
	public PageReturnParam userPage(HttpServletRequest request){

		/*接收前台datatabel传来分页用的参数*/
		String aoData=request.getParameter("aoData");
		log.info("前台分页参数"+aoData);
		/*转换需要的参数*/
		PageUtil page = PageUtil.getPageParams(aoData);
		/*查询总条数*/
		int count = menuService.selectMenusCount(null);

		List<Menu> userList = new ArrayList<Menu>();
		if(count>0){
			/*查询符合条件的用户*/
			userList = menuService.selectMenus(null,page);
		}

		return new PageReturnParam(page.getsEcho(),count,userList);
	}

}
