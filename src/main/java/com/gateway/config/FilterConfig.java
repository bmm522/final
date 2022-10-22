package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	 
	@Bean
	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
	        return builder.routes()
	                .route(r -> r.path("/login/**") //라우터 등록
	                        .uri("http://localhost:8080/login")
	                ).route(r -> r.path("/register/**")
	                        .uri("http://localhost:8080/register")
	                )
	                .build();
	    }
}
