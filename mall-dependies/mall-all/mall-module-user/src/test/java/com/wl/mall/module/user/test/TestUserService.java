package com.wl.mall.module.user.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

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
	}

}
