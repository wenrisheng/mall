package com.wl.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ImportResource("classpath:application-service.xml")
@SpringBootApplication
@EnableJpaRepositories ( entityManagerFactoryRef = "managerFactory", transactionManagerRef = "transactionManager", basePackages = { "com.wl.mall.repository" })
public class ApplicationTest {


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication springApplication = new SpringApplication(ApplicationTest.class);
		springApplication.setWebEnvironment(true);
		springApplication.run(args);
//    SpringApplication.run(Application.class, args);
	}

}
