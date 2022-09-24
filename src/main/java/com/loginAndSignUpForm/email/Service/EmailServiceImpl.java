package com.loginAndSignUpForm.email.Service;

import org.springframework.stereotype.Service;

import com.loginAndSignUpForm.email.CreateRandomNumber;
import com.loginAndSignUpForm.email.EmailAuthenticationCode;

@Service
public class EmailServiceImpl implements EamilService {
	
	private String randomNumber = ""; 
	
	
	public void checkEamil(Object obj) {
		CreateRandomNumber cr= new CreateRandomNumber();
		String randomNumber = cr.makeRandomNumber();
		EmailAuthenticationCode.sendMail("테스트", randomNumber, obj);
		this.randomNumber = randomNumber;
	}
	
	public String getRandomNumber() {
		return randomNumber;
	}
	
}
