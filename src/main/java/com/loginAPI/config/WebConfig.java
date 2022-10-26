//package com.loginAPI.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@EnableWebMvc
//@Configuration
//@ComponentScan
//public class WebConfig implements WebMvcConfigurer{
//	
//	@Bean
//	public ViewResolver setViewResolver() {
//		InternalResourceViewResolver bean = new InternalResourceViewResolver();
//		bean.setContentType("text/html; charset=UTF-8");
//		bean.setPrefix("classpath:/templates/");
//		bean.setSuffix(".html");
//		
//		return bean;
//	}		
//
//}
