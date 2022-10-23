package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j	
public class TestFilter extends AbstractGatewayFilterFactory<TestFilter.TestConfig> {
	
	public TestFilter() {
		super(TestConfig.class);
	}
	
	@Override
	public GatewayFilter apply(TestConfig config) {
		return ((exchange, chain) -> {
			System.out.println("test필터 실행됨");
			return chain.filter(exchange);
		});
	}
	
	
	public static class TestConfig{
		
	}





}
