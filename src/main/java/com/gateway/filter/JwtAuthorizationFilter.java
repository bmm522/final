package com.gateway.filter;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class JwtAuthorizationFilter extends AbstractGatewayFilterFactory<JwtAuthorizationFilter.JwtAuthrizaionConfig>{
	
	public JwtAuthorizationFilter() {
		super(JwtAuthrizaionConfig.class);
	}
	
	@Override
	public GatewayFilter apply(JwtAuthrizaionConfig config) {
		return ((exchange, chain) -> {
			
			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse response = exchange.getResponse();
			
			String jwtHeader = request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			System.out.println(jwtHeader);
			
			//JWT 토큰을 검증을 해서 정상적인 사용자인지 확인
			if(jwtHeader == null || !jwtHeader.startsWith("Bearer")) {
				return chain.filter(exchange);
			}
			
			//JWT 토큰을 검증을 해서 정상적인 사용자인지 확인
			String jwtToken = jwtHeader.replace("Bearer ", "");
			String username = 
					JWT.require(Algorithm.HMAC512("secret1234")).build().verify(jwtToken).getClaim("username").asString();
			System.out.println(username);
			// 서명이 정상적으로 됨
		
			return chain.filter(exchange);
		});
	}
	
	public static class JwtAuthrizaionConfig{
		
	}

	
}
