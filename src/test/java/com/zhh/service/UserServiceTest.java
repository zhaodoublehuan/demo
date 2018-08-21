package com.zhh.service;

import com.alibaba.fastjson.JSON;
import com.zhh.base.BaseTest;
import com.zhh.entity.UserEntity;
import com.zhh.exception.ZhhException;
import com.zhh.util.UUIDUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest extends BaseTest {
	@Autowired
	private UserService userService;
	@Test
	public void testAdd() {
		UserEntity user = new UserEntity();
		user.setId(UUIDUtils.getUUID());
		user.setLoginNo("admin");
		user.setUserName("赵欢欢");
		user.setPassword("111111");
		try {
			int a = userService.add(user);
			System.out.print(a);

		} catch (ZhhException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		UserEntity user = new UserEntity();
		user.setId("e4a283af541f4b3e89a6fb5d0ba0d403");
		user.setUserName("zhh");
		user.setEmail("702324140@qq.com");
		int a = userService.update(user);
		System.out.print(a);
	}

	@Test
	public void testDelete() {
		List<String> ids = new ArrayList<String>();
		ids.add("ebe461553fc0430cb332bcb7fee2d6d9");
		int a = userService.delete(ids);
		System.out.print(a);
	}
	
	@Test
	public void testSelectUsers() {
		UserEntity user = new UserEntity();
		user.setId(UUIDUtils.getUUID());
		user.setUserName("zhh");

	}
	
	@Test
	public void testFindUserByUsername(){

		UserEntity user = userService.findUserByLoginNo("admin");

		System.out.print("####"+JSON.toJSON(user));
	}
}
