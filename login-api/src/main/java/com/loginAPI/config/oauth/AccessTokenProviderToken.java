//package com.loginAPI.config.oauth;
//
//import java.util.Collection;
//
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//
//import com.loginAPI.model.Provider;
//
//import lombok.Builder;
//
///*@Builder*/
//public class AccessTokenProviderToken extends AbstractAuthenticationToken{
//	private Object principal; //OAuth2USerDetails 타입
//	
//	private String accessToken;
//	private Provider provider;
//	
//	public AccessTokenProviderToken(String accessToken, Provider provider) {
//		super(null);
//		this.accessToken = accessToken;
//		this.provider = provider;
//		setAuthenticated(false);
//	}
//	
//	
//	public AccessTokenProviderToken(Collection<? extends GrantedAuthority> authorities) {
//		super(authorities);
//		this.principal = principal;
//		super.setAuthenticated(true);
//		
//	}
//	
//	public String getAccessToken() {
//		return accessToken;
//	}
//	
//	public Provider getProvider() {
//		return provider;
//	}
//	
//	
//
//	@Override
//	public Object getCredentials() {
//		return null;
//	}
//
//
//	@Override
//	public Object getPrincipal() {
//		return this.principal;
//	}
//
//}
