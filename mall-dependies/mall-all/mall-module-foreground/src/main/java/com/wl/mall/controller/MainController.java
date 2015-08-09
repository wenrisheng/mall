package com.wl.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value = { "/","/index*", "/main/index*" })
	String toIndexPage() {
		return "index";
	}
	
	@RequestMapping("/login")
	String toLoginPage() {
		return "login";
	}
}
