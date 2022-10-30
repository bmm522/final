//package com.loginAPI.config.oauth;
//
//import org.springframework.security.oauth2.client.registration.ClientRegistration.ProviderDetails.UserInfoEndpoint;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.util.Assert;
//
//public class CustmomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
//
//	@Override
//	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//		Assert.notNull(userRequest, "userRequest cannot be null");
//		
//		UserInfoEndpoint userInfoEndpoint = userRequest.getClientRegistration().getProviderDetails();
//		
//		String userInfoUri = userInfoEndpoint.getUri();
//		validateUserInfoUri(userRequest, userInfoUri);
//	}
//	
//	
//}
