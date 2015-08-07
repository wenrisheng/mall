package com.wl.mall.module.user.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.wl.mall.entity.User;
import com.wl.mall.module.common.config.EnvironmentBean;
import com.wl.mall.module.test.BaseServiceTest;
import com.wl.mall.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//@WebIntegrationTest("server.port:0")
public class TestUserService extends BaseServiceTest {
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
