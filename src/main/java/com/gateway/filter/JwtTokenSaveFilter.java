package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import com.gateway.token.JwtToken;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenSaveFilter extends AbstractGatewayFilterFactory<JwtTokenSaveFilter.JwtTokenSaveConfig>{
	
	public JwtTokenSaveFilter() {
		super(JwtTokenSaveConfig.class);
	}
	
	@Override
	public GatewayFilter apply(JwtTokenSaveConfig config) {
		return ((exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest(); // Pre Filter로 적용
			ServerHttpResponse response = exchange.getResponse(); 
			System.out.println(request.getHeaders());
			System.out.println(response.getHeaders());
			
//			ServerHttpResponse response=exchange.getResponse();
//			JwtToken jwtToken = new JwtToken();
//			String authorication  = response.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//			String token = authorication.replace("Bearer", "").trim();
//			jwtToken.setToken(token);
//			System.out.println(jwtToken.getToken());
			return chain.filter(exchange);
		});
	}
	
	public static class JwtTokenSaveConfig{
		
	}

	
	
}
