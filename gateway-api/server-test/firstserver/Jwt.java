package com.firstserver;

import org.springframework.stereotype.Component;

@Component
public class Jwt {
	
	private final String securityKey = "hello world";
	private final Long expiredTime = 1000*60L*60L*3L;
}
