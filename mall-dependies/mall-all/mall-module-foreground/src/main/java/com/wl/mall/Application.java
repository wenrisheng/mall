package com.wl.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ImportResource("classpath:application-service.xml")
@SpringBootApplication
//@EntityScan(basePackages = "com.wl.mall.domain")
@EnableJpaRepositories ( entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = { "com.wl.mall.repository" })

//implements WebApplicationInitializer
public class Application extends SpringBootServletInitializer{

//	@Override
//    public void onStartup(ServletContext container) {
//        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//       appContext.register(WebConfig.class);
//        appContext.setServletContext(container); 
//        appContext.refresh();
//        container.addListener(new ContextLoaderListener(appContext));
//        ServletRegistration.Dynamic dispatcher = container.addServlet(
//                "dispatcher", new DispatcherServlet(appContext));
//        dispatcher.setLoadOnStartup(1);
//       dispatcher.addMapping("/");
//   }
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setWebEnvironment(true);
		springApplication.run(args);
//    SpringApplication.run(Application.class, args);
	}

}
