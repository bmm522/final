package com.loginAndSignUpForm.email.Service;

import org.springframework.stereotype.Service;

import com.loginAndSignUpForm.email.RandomNumber;
import com.loginAndSignUpForm.email.EmailAuthenticationCode;

@Service
public class EmailServiceImpl implements EamilService {
	
	
	
	
	public String sendEamil(Object obj) {
		RandomNumber cr= new RandomNumber();
		String randomNumber = cr.makeRandomNumber();
		EmailAuthenticationCode.sendMail("테스트", randomNumber, obj);
		return randomNumber;
	}

	
}
