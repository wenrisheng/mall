package com.wl.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.wl.mall.repository")
@EntityScan(basePackages = "com.wl.mall.domain")
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.setWebEnvironment(true);
SpringApplication.run(Application.class, args);
	}

}
