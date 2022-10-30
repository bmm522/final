//package com.loginAPI.config.oauth;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.loginAPI.config.strategy.GoogleLoadStrategy;
//import com.loginAPI.config.strategy.SocialLoadStrategy;
//import com.loginAPI.model.Provider;
//
//import lombok.RequiredArgsConstructor;
//
///*@Service
//@RequiredArgsConstructor*/
//public class LoadUserService {
//	
//	private final RestTemplate restTemplate = new RestTemplate();
//	
//	public OAuth2UserDetails getOAuth2UserDetails(AccessTokenProviderToken authentication) {
//		Provider provider = authentication.getProvider();
//		
//		SocialLoadStrategy socialLoadStrategy = getSocialLoadStrategy(provider); // SocialLoadStrategy 설정
//		
//		String socialPk = socialLoadStrategy.getProviderId(authentication.getAccessToken()); // PK 가져오기
//		
//		return OAuth2UserDetails.builder()
//					.providerId(socialPk)
//					.provider(provider)
//					.build();
//	}
//
//	private SocialLoadStrategy getSocialLoadStrategy(Provider provider) {
//		SocialLoadStrategy socialLoadStrategy= null;
//		if(provider.getProviderName().equals("GOOGLE")) {
//			return new GoogleLoadStrategy();
//		} 
//		return socialLoadStrategy;
//	}
//}
