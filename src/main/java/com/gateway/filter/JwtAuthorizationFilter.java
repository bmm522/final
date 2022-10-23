package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerWebExchange;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gateway.properties.HttpStatusProperties;
import com.gateway.properties.JwtProperties;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


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
			String serverHeader = request.getHeaders().get("Server_Authorization").get(0);
			System.out.println(jwtHeader);
			
			//JWT 토큰을 검증을 해서 정상적인 사용자인지 확인
			if(jwtHeader == null || !jwtHeader.startsWith(JwtProperties.JWT_PREFIX)) {
				return notiStatus(exchange, "Not found authorization header", HttpStatus.UNAUTHORIZED);
			}
			
			//정상적인 로그인서버에서 접근한 사용자인지 확인
			if(serverHeader == null || !serverHeader.startsWith(JwtProperties.SERVER_PREFIX)) {
				
				return notiStatus(exchange, "Not found server_authorization header", HttpStatus.UNAUTHORIZED);
			}
			
			//JWT 토큰을 검증을 해서 정상적인 사용자인지 확인
			String jwtToken = jwtHeader.replace(JwtProperties.JWT_PREFIX, "");
			String serverToken = serverHeader.replace(JwtProperties.SERVER_PREFIX, "");
			String username = 
					JWT.require(Algorithm.HMAC512(JwtProperties.SECRET+serverToken)).build().verify(jwtToken).getClaim("username").asString();
			System.out.println(username);
			// 서명이 정상적으로 됨
		
			return chain.filter(exchange);
		});
	}
	
	private Mono<Void> notiStatus(ServerWebExchange exchange,String e, HttpStatus status){
		exchange.getResponse().getHeaders().set(HttpStatusProperties.STATUS, e);
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(status);
		log.error(e);
		return response.setComplete();
	}
	
	public static class JwtAuthrizaionConfig{
		
	}

	
	
}
