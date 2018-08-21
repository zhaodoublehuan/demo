package com.zhh.controller.base;

import com.zhh.service.MenuService;
import com.zhh.service.UserService;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
@Log4j
public class MenuController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private MenuService menuService;
	

}
