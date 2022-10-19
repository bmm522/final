package com.gateway.filter;

import java.util.Objects;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class SettingFilter extends AbstractGatewayFilterFactory<SettingFilter.Config>{
	
	public SettingFilter() {
		super(Config.class);
	}
	
	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) ->{
			ServerHttpRequest request = exchange.getRequest(); // Pre Filter로 적용
			ServerHttpResponse response = exchange.getResponse(); // Post Filter는 Response로 받아오면 된다.
			HttpHeaders requestHeaders = request.getHeaders();
			settingForCors(requestHeaders, response.getHeaders());
			
			if(request.getMethod() == HttpMethod.OPTIONS) {
				response.setStatusCode(HttpStatus.OK);
				return Mono.empty();
			}
			
			if(!requestHeaders.containsKey("token")) { 			//토큰 존재하지 않을때
				return notiUnAuthorized(exchange); 
			}
			String token = Objects.requireNonNull( 
									  request.getHeaders().get("token"))
									  .get(0); // 빠른 오류 확인 위해서 requiredNonNull 사용.
			
			if(!token.equals("A.B.C")) { 			//토큰 일치하지 않을때
				return notiUnAuthorized(exchange);
			}
			
			return chain.filter(exchange);
		});
	}
	


	private void settingForCors(HttpHeaders requestHeaders, HttpHeaders responseHeaders) {
		HttpMethod requestMethod = requestHeaders.getAccessControlRequestMethod();
		responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());
		responseHeaders.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders.getAccessControlRequestHeaders());
		if(requestMethod != null) {
			responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, requestMethod.name());
		}
		responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
		responseHeaders.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "ALL");
		responseHeaders.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "18000L" );
	}

	private Mono<Void> notiUnAuthorized(ServerWebExchange exchange) {
		ServerHttpResponse response = exchange.getResponse();
		
		response.setStatusCode(HttpStatus.UNAUTHORIZED);
		return response.setComplete();
	}
	
	
	
	public static class Config{
		
	}


	
}
