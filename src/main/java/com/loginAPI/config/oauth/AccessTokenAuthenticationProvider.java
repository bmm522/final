//package com.loginAPI.config.oauth;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//import com.loginAPI.model.User;
//import com.loginAPI.repository.UserRepository;
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//
///*
//@RequiredArgsConstructor
//@Component*/
//public class AccessTokenAuthenticationProvider implements AuthenticationProvider{
//
//	private final LoadUserService loadUserService; // restTemplate를 통해서 AccessToken을 가지고 회원의 정보를 가져오는 역할을 한다.
//	private final UserRepository userRepository;
//
//	
//	@SneakyThrows // 예외 클래스를 파라미터로 입력받음.
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		
//		OAuth2UserDetails oAuth2User = loadUserService.getOAuth2UserDetails((AccessTokenProviderToken)authentication);
//		
//		User user = saveOrGet(oAuth2User);//받아온 식별자 값과 social로그인 방식을 통해 회원을 DB에서 조회 후 없다면 새로 등록해주고, 있다면 그대로 반환한다.
//	    oAuth2User.setRoles(user.getRole().name());//우리의 Role의 name은 ADMIN, USER, GUEST로 ROLE_을 붙여주는 과정이 필요하다. setRolse가 담당한다.
//
//		
//		return AccessTokenProviderToken.builder().principal(oAuth2User).authorities(oAuth2User.getAuthorities()).build();
//	}
//	
//	
//	private User saveOrGet(OAuth2UserDetails oAuth2User) {
//		return userRepository.findByProviderAndProviderId(oAuth2User.getProvider(), 
//																										oAuth2User.getProviderId())
//				.orElseGet(() -> userRepository.save(User.builder()
//						.provider(oAuth2User.getProvider())
//						.providerId(oAuth2User.getProviderId())
//						).build());
//		return null;
//	}
//
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
