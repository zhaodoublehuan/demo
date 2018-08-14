package com.zhh.controller.base;

import com.zhh.entity.Menu;
import com.zhh.entity.UserEntity;
import com.zhh.exception.UserException;
import com.zhh.service.MenuService;
import com.zhh.service.UserService;
import com.zhh.util.PageReturnParam;
import com.zhh.util.PageUtil;
import com.zhh.util.ReturnResult;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	
	private static final Logger LOGGER = Logger.getLogger(MenuController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private MenuService menuService;
	

}
