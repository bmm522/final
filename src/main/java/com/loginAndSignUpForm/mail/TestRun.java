package com.loginAndSignUpForm.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class TestRun {
	
	@Autowired 
	private static JavaMailSender mailSender;
	
	public static void main(String[] args) {
		TestMailRun tmr = new TestMailRun();
		try {
			tmr.run(mailSender);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tmr.getRandomNumber());
		
	}
}
