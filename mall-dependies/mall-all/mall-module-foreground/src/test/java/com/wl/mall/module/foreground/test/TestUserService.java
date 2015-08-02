package com.wl.mall.module.foreground.test;


import javax.annotation.Resource;

import org.junit.Test;

import com.wl.mall.entity.User;
import com.wl.mall.module.test.BaseServiceTest;
import com.wl.mall.module.test.BaseViewTest;
import com.wl.mall.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//@WebIntegrationTest("server.port:0")
public class TestUserService extends BaseViewTest{
	@Resource
UserService userService;
	@Test
	public void testSaveUser() {
	}

}
