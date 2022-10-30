//package com.gateway.config;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.gateway.filter.TestFilter;
//
//@Configuration
//public class FilterConfig {
//	 
//	@Bean
//	    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder, TestFilter testFilter){
//	        return builder.routes()
//	                .route(r -> r.path("/login/**") //라우터 등록
//	                		.filters(f->f.filter((GatewayFilter) testFilter))
//	                        .uri("http://localhost:8080/login")
//	                ).route(r -> r.path("/register/**")
//	                        .uri("http://localhost:8080/register")
//	                )
//	                .build();
//	    }
//}
