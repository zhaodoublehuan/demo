package com.zhh.service;

import com.alibaba.fastjson.JSON;
import com.zhh.base.BaseTest;
import com.zhh.service.base.UserRoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRoleServiceTest extends BaseTest {

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void addUserRole() {
    }

    @Test
    public void deleteUserRole() {
    }

    @Test
    public void selectRolesByLoginNo() {
        List<String> strs = userRoleService.selectRolesIdByLoginNo("zhh");
        System.out.print(JSON.toJSONString(strs)+"####");
    }
}