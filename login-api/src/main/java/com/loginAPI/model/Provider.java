package com.loginAPI.model;

import org.springframework.http.HttpMethod;

public enum Provider {
	
	KAKAO(
			"kakao",
			"https://kapi.kakao.com/v2/user/me",
			HttpMethod.GET
			),
	GOOGLE(
			"google",
			"https://www.googleapis.com/oauth2/v3/userinfo",
			HttpMethod.GET
			),
	NAVER(
			"naver",
			"https://www.openapi.naver.com/v1/nid/me",
			HttpMethod.GET
			);

	
	private String providerName;
	private String userInfoUrl;
	private HttpMethod method;
	
	Provider(String providerName, String userInfoUrl, HttpMethod method) {
		this.providerName = providerName;
		this.userInfoUrl = userInfoUrl;
		this.method = method;
	}
			
	public HttpMethod getMethod() {
		return method;
	}
	
	public String getProviderName() {
		return providerName;
	}
	
	public String getUserInfoUrl() {
		return userInfoUrl;
	}
			
}
