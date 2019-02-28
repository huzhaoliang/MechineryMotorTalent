package com.mmt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests()每个匹配器按照它们被声明的顺序被考虑。
        http.authorizeRequests()
            // 所有用户均可访问的资源
            .antMatchers("/verify","/main","/static/css/**","/static/js/**","/static/images/**","/static/bootstrap/css/**","/static/bootstrap/js/**").permitAll()
            // ROLE_USER的权限才能访问的资源
            //.antMatchers("/manage/**").hasRole("MANAGE")
            // 任何尚未匹配的URL只需要验证用户即可访问
            .anyRequest().authenticated()
            .and()
            .formLogin()
            // 指定登录页面,授予所有用户访问登录页面
            .loginPage("/login")
            .permitAll()
            .and()
            .headers()
            .frameOptions().sameOrigin();
	}
}
