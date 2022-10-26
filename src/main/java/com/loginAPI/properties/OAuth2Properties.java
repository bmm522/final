package com.loginAPI.properties;

public interface OAuth2Properties {
//	String DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX = "/login/oauth2/";
//	String HTTP_METHOD = "GET";
//	String ACCESS_TOKEN_HEADER_NAME = "Authorization";
//	String REFRESH_TOKEN_HEADER_NAME = "RefreshToken";
	
	String GOOGLE_AUTH_URL = "https://oauth2.googleapis.com";
	String GOOGLE_LOGIN_URL = "https://accounts.google.com";
	String GOOGLE_REDIRECT_URI = "http://localhost:8080/loginapi/test";
	String GOOGLE_SCOPE = "email,profile";
}
