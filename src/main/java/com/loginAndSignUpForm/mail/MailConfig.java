package com.loginAndSignUpForm.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
	public static JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost("smtp.naver.com");
		mailSender.setUsername("bmm522@naver.com");
		mailSender.setPassword("dlquf!2tkfkd!2");
		
		return mailSender;
	}
}
