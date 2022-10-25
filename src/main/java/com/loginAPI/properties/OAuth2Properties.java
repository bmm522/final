package com.loginAPI.properties;

public interface OAuth2Properties {
	String DEFAULT_OAUTH2_LOGIN_REQUEST_URL_PREFIX = "/login/oauth2/";
	String HTTP_METHOD = "GET";
	String ACCESS_TOKEN_HEADER_NAME = "Authorization";
	String REFRESH_TOKEN_HEADER_NAME = "RefreshToken";
}
