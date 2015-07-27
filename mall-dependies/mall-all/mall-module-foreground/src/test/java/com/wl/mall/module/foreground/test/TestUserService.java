package com.wl.mall.module.foreground.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wl.mall.Application;
import com.wl.mall.domain.User;
import com.wl.mall.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
@WebIntegrationTest("server.port:0")
public class TestUserService {
	@Resource
UserService userService;
	@Test
	public void test() {
		userService.saveUser(new User("test", "test", "adsfa"));
	}

}
