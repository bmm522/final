package com.loginAPI.config.strategy;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.loginAPI.model.Provider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoogleLoadStrategy extends SocialLoadStrategy{

	@Override
	protected String sendRequestToSocialSite(HttpEntity<MultiValueMap<String, String>> request) {
		try {
			ResponseEntity<Map<String, Object>> response = restTemplate.exchange(Provider.GOOGLE, getUserInfoUrl(),
					Provider.GOOGLE.getMethod(),
					request,
					RESPONSE_TYPE);
			
			return (response.getBody().get("email")).toString();
		} catch(Exception e) {
			log.error("Error : Exception while using AccessToken to receive GOOGLE user information", e.getMessage());
			throw e;
		}

	}

	
}
