package com.wl.mall.module.user.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.wl.mall.entity.User;
import com.wl.mall.module.test.BaseViewTest;
import com.wl.mall.service.UserService;

public class TestUserService extends BaseViewTest{
	@Resource
	UserService userService;
	
	@Test
	public void testSaveUser() {
		userService.saveUser(new User("ymldev", "aaa"));

	}

}
