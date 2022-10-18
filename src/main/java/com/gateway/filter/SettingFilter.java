package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
public class SettingFilter extends AbstractGatewayFilterFactory<SettingFilter.Config>{
	
	public SettingFilter() {
		super(Config.class);
	}
	
	@Override
	public GatewayFilter apply(Config config) {

		return null;
	}
	
	public static class Config{
		
	}


	
}
