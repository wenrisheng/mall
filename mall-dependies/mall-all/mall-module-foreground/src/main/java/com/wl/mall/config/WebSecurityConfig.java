package com.wl.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

//@Configuration
//@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 设置不拦截规则
		web.ignoring().antMatchers("/static/**", "/**/*.jsp");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 无需认证访问
		http.authorizeRequests().antMatchers("/", "/index**").permitAll()

		// 其他地址访问都要认证
		.anyRequest().authenticated();

		// 指定登陆处理
		http.formLogin().loginPage("/login").failureUrl("/login?error=1")
				.loginProcessingUrl("/login.do").usernameParameter("account")
				.passwordParameter("password").permitAll();

		// 指定注销处理
		http.logout().logoutUrl("/logout").invalidateHttpSession(true)
				.permitAll();
		// 设置拦截规则
		// 自定义accessDecisionManager访问控制器,并开启表达式语言
		// http.authorizeRequests().accessDecisionManager(accessDecisionManager())
		// .expressionHandler(webSecurityExpressionHandler())
		// .antMatchers("/**/*.do*").hasRole("USER")
		// .antMatchers("/**/*.htm").hasRole("ADMIN").and()
		// .exceptionHandling().accessDeniedPage("/login");

		// 开启默认登录页面
		// http.formLogin();

		// 自定义登录页面
		// http.csrf().disable().formLogin().loginPage("/login")
		// .failureUrl("/login?error=1")
		// .loginProcessingUrl("/j_spring_security_check")
		// .usernameParameter("j_username")
		// .passwordParameter("j_password").permitAll();
		//
		// // 自定义注销
		// http.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
		// .invalidateHttpSession(true);
		//
		// // session管理
		// http.sessionManagement().sessionFixation().changeSessionId()
		// .maximumSessions(1).expiredUrl("/");
		//
		// // RemeberMe
		// http.rememberMe().key("webmvc#FD637E6D9C0F1A5A67082AF56CE32485");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}
	
	
}
