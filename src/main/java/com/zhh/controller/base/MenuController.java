package com.zhh.controller.base;

import com.zhh.service.MenuService;
import com.zhh.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	
	private static final Logger LOGGER = Logger.getLogger(MenuController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private MenuService menuService;
	

}
