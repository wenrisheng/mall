package com.wl.mall.module.foreground.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wl.mall.Application;
import com.wl.mall.entity.User;
import com.wl.mall.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
//@WebIntegrationTest("server.port:0")
public class TestUserService {
	@Resource
UserService userService;
	@Test
	public void test() {
		userService.saveUser(new User("database", "123", "asdfa", "asdfas", "252747@", "image", "nickName", new Date(), new Date(), "252797991", "127.0.0.1", "广州"));
	}

}
