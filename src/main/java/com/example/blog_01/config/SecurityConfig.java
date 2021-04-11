package com.example.blog_01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //빈등록(IoC관리)
@EnableWebSecurity //시큐리티 필터가 등록된다.
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정주소로 접근을 하면 권한 및 인증을 미리 체크하겠다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/auth/**")
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/auth/loginForm");
	}//configure()
}//class
