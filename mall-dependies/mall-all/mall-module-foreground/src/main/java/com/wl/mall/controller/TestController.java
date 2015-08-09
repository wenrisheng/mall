package com.wl.mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/add")
    public Map<Object, Object> add(){
    	Map<Object, Object> resultMap = new HashMap<Object, Object>();
    	resultMap.put("add", "succ");
  return resultMap;
    	
    }
}
