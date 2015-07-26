package com.wl.mall.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wl.mall.domain.User;
import com.wl.mall.service.UserService;



@Controller
public class UserController {
	@Resource
private UserService userService;
	
	@RequestMapping("/addUser")
	public String addUser(String account, String password) {
		User user = new User(account, password, "1212121");
	    userService.saveUser(user);
		return "test";
	}
}
