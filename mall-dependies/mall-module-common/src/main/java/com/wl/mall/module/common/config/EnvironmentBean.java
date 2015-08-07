package com.wl.mall.module.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("environmentBean")
@ConfigurationProperties(locations = {"classpath:environment.yml"},prefix="server")
public class EnvironmentBean {
  private String address;

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
  
}
