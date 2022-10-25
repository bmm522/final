package com.loginAPI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.loginAPI.config.filter.loginAuthenticationFilter;
import com.loginAPI.config.oauth.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalOauth2UserService principalOauth2UserService;
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.formLogin().disable()
		.httpBasic().disable()
		.addFilter(new loginAuthenticationFilter(authenticationManager()))
		.authorizeRequests()
		.antMatchers("/user/**")
		.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') ")
		.antMatchers("/admin/**")
		.access("hasRole('ROLE_ADMIN')")
		.anyRequest().permitAll()
		.and()
		.oauth2Login()
		.userInfoEndpoint()
		.userService(principalOauth2UserService);

	}
}
