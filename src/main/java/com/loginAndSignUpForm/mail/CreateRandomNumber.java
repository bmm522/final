package com.loginAndSignUpForm.mail;

import java.util.Random;

public class CreateRandomNumber {
	
	public String makeRandomNumber() {
		String randomNumber = "";
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		for(int i = 0 ; i < 6 ; i ++) {
			randomNumber += random.nextInt(10);
		}
		return randomNumber;
	}
}
