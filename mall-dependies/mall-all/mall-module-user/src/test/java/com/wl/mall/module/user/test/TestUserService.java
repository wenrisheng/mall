package com.wl.mall.module.user.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.wl.mall.entity.User;
import com.wl.mall.module.test.BaseServiceTest;
import com.wl.mall.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//@WebIntegrationTest("server.port:0")
public class TestUserService extends BaseServiceTest{
	@Resource
UserService userService;
	@Test
	public void testSaveUser() {
		userService.saveUser(new User("hibernate33333", "123", "asdfa", "asdfas", "252747@", "image", "nickName", new Date(), new Date(), "252797991", "127.0.0.1", "广州"));
	}

}
