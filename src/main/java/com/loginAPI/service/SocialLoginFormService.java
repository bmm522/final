package com.loginAPI.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.loginAPI.properties.OAuth2Properties;

import lombok.RequiredArgsConstructor;

@Component
public class SocialLoginFormService {
	
	@Value("${spring.security.oauth2.client.registration.google.client-id}")
	private String googleClientId;
	
	@Value("${spring.security.oauth2.client.registration.google.client-secret}")
	private String googleClientSecret;
	
//	@Value("${spring.security.oauth2.client.registration.google.scope}")
//	private String googleScopes;
	
	public String runGoogleLoginForm() {
		Map<String, Object> params = new HashMap<>();
		params.put("client_id", getGoogleClientId());
		params.put("redirect_uri", getGoogleRedirectUri());
		params.put("response_type", "code");
		params.put("scope", getGoogleScope());
		
		String paramStr = params.entrySet().stream()
						.map(param -> param.getKey() + "="  +param.getValue())
						.collect(Collectors.joining("&"));
		
		return OAuth2Properties.GOOGLE_LOGIN_URL 
					+ "/loginapi/test" 
					+ "?" 
					+ paramStr;
	}
	
	public String getGoogleLoginUrl() {
		return OAuth2Properties.GOOGLE_LOGIN_URL;
	}
	
	
	public String getGoogleClientId() {
		return googleClientId;
	}

	public String getGoogleClientSecret() {
		return googleClientSecret;
	}
	
	public String getGoogleRedirectUri() {
		return OAuth2Properties.GOOGLE_REDIRECT_URI;
	}
	public String getGoogleScope() {
		return OAuth2Properties.GOOGLE_SCOPE.replaceAll(",", "%20");
	}
}
