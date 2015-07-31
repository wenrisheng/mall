package com.wl.mall.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.wl.mall.service.UserService;

//@Configuration  
//@EnableWebMvcSecurity  
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	UserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		//auth.userDetailsService(userService);
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(web);
		web.ignoring().antMatchers("/resources/**", "/**/*.js", "/**/*.css", "/**/*.jpg", "/**/*.png", "/main/**", "/getCode", "/test/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
	     // 设置拦截规则  
        // 自定义accessDecisionManager访问控制器,并开启表达式语言  

        http.authorizeRequests().antMatchers("/app.jsp").hasRole("SERVICE")
        .antMatchers("/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasRole("USER")  
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()  
                .exceptionHandling().accessDeniedPage("/login");  
  
        // 开启默认登录页面  
        // http.formLogin();  
  
        // 自定义登录页面  
        http.csrf().disable().formLogin().loginPage("/app/login")  
                .failureUrl("/app/login")  
                .defaultSuccessUrl("/app/index.html")
                .loginProcessingUrl("/j_spring_security_check")  
                .usernameParameter("j_username")  
                .passwordParameter("j_password").permitAll();  
  
//        // 自定义注销  
//        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login")  
//                .invalidateHttpSession(true);  
//  
//        // session管理  
//        http.sessionManagement().sessionFixation().changeSessionId()  
//                .maximumSessions(1).expiredUrl("/");  
//  
//        // RemeberMe  
//        http.rememberMe().key("webmvc#FD637E6D9C0F1A5A67082AF56CE32485");  
	}

}
