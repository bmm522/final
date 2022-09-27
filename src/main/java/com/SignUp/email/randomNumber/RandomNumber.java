package com.SignUp.email.randomNumber;

import java.util.Random;

public class RandomNumber {
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
