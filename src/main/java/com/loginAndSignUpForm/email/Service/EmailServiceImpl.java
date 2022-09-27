package com.loginAndSignUpForm.email.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.loginAndSignUpForm.email.EmailAuthenticationCode;
import com.loginAndSignUpForm.email.EmailVo;
import com.loginAndSignUpForm.email.RandomNumber;

@Service
public class EmailServiceImpl implements EamilService {
	
	public String sendEamil(EmailVo emailVo) {
		RandomNumber cr= new RandomNumber();
		String randomNumber = cr.makeRandomNumber();
		EmailAuthenticationCode.sendMail("테스트", randomNumber, emailVo.getEmail());
		return randomNumber;
	}

	
}
