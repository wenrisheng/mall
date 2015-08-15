package com.wl.mall.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	 private static final Logger logger = Logger  
	            .getLogger(WebMvcConfig.class); 
	/**
	 * <mvc:default-servlet-handler/>
	 */
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		 logger.info("<mvc:default-servlet-handler/>");
	        configurer.enable();
	    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		super.addInterceptors(registry);
		RequestInterceptor requestInterceptor = new RequestInterceptor();
		
		InterceptorRegistration interceptorReg = registry.addInterceptor(requestInterceptor);
		interceptorReg.addPathPatterns("/");
	}

//	@Bean
//	public UrlBasedViewResolver setupViewResolver() {
//		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//		resolver.setPrefix("/WEB-INF/jsp/");
//		resolver.setSuffix(".jsp");
//		resolver.setViewClass(JstlView.class);
//		return resolver;
//	}

	
	
	@Bean
    public ViewResolver viewResolver() {
		logger.info("ViewResolver");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		 logger.info("addResourceHandlers");  
	      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/**");  
	}
}
