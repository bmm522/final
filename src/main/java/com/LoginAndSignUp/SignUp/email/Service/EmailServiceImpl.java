package com.LoginAndSignUp.SignUp.email.Service;

import org.springframework.stereotype.Service;

import com.LoginAndSignUp.SignUp.RandomNumber;
import com.LoginAndSignUp.SignUp.email.API.EmailAuthenticationCode;
import com.LoginAndSignUp.SignUp.email.DTO.EmailDTO;

@Service
public class EmailServiceImpl implements EamilService {
	
	public String sendEamil(EmailDTO emailDTO) {
		RandomNumber cr= new RandomNumber();
		String randomNumber = cr.makeRandomNumber();
		EmailAuthenticationCode.sendMail("테스트", randomNumber, emailDTO.getEmail());
		return randomNumber;
	}

	
}
