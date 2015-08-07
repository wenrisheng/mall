package com.wl.mall.module.foreground.test;

import javax.annotation.Resource;

import org.junit.Test;
import com.wl.mall.module.common.config.EnvironmentBean;
import com.wl.mall.module.test.BaseViewTest;
import com.wl.mall.service.UserService;

public class TestUserService extends BaseViewTest{
	@Resource
	UserService userService;

	@Resource(name = "environmentBean")
	EnvironmentBean environment;
	@Test
	public void testSaveUser() {
		String address = environment.getAddress();
		System.out.print(address);
	}

}
