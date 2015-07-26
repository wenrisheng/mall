package com.wl.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	 @RequestMapping(value="/home")//是springmvc中的注解
	    String home(){
	        return "index";
	    }
}
