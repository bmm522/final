package com.loginAPI.config.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.loginAPI.config.oauth.AccessTokenProviderToken;
import com.loginAPI.model.Provider;
import com.loginAPI.properties.OAuth2Properties;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OAuth2AccessTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter{
	
	
	// 해당주소 요청에 Get으로 온 요청에 매칭됨.
	private static final AntPathRequestMatcher DEFAULT_OAUTH2_LOGIN_PATH_REQUEST_MATCHER =
			new AntPathRequestMatcher(OAuth2Properties.DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX+"*",
																  OAuth2Properties.HTTP_METHOD); 
	
	public OAuth2AccessTokenAuthenticationFilter(AccessTokenAuthenticationProvider abstractUserDetailsAuthenticationProvider,
																						  AuthenticationSuccessHandler authenticationSuccessHandler, //로그인 성공 시 처리할 핸들러
																						  AuthenticationFailureHandler authenticationFailureHandler) { // 로그인 실패 시 처리할 핸들러
		super(DEFAULT_OAUTH2_LOGIN_PATH_REQUEST_MATCHER);
		
		this.setAuthenticationManager(new ProviderManager(abstractUserDetailsAuthenticationProvider));
		this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		this.setAuthenticationFailureHandler(authenticationFailureHandler);
		
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) 
			throws AuthenticationException, IOException, ServletException { // Authentication 객체를 반환해야함.
		
		Provider provider = extractProvider(request);
		
		String accessToken = request.getHeader(OAuth2Properties.ACCESS_TOKEN_HEADER_NAME); 
		// 헤더의 AccessToken에 해당되는 값을 가져온다.
		log.info("{}",provider.getProviderName());
		
		return this.getAuthenticationManager().authenticate(new AccessTokenProviderToken(accessToken, provider));

	}

	// 요청 처리하는 코드
	private Provider extractProvider(HttpServletRequest request) { 
		return Arrays.stream(Provider.values())  //GOOGLE, KAKAO, NAVER
				.filter(provider ->
						provider.getProviderName()
							.equals(request.getRequestURI().substring(OAuth2Properties.DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX.length())))
											// 해당 이름만 추출
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("잘못된 URL 주소입니다"));
	}
}
