package com.wl.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wl.mall.entity.User;
import com.wl.mall.service.UserService;

@Controller()
@RequestMapping("/user")
public class UserController {
	@Resource(name = "userServiceImpl")
	UserService userService;

	@ResponseBody
	public Map<String, Object> add(String account, String password) {
		User user = new User(account, password);
		userService.saveUser(user);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("addUser", "Suc");
		return result;

	}
}
