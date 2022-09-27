package com.SignUp.email.Service;

import org.springframework.stereotype.Service;

import com.SignUp.RandomNumber;
import com.SignUp.email.API.EmailAuthenticationCode;
import com.SignUp.email.VO.EmailVo;

@Service
public class EmailServiceImpl implements EamilService {
	
	public String sendEamil(EmailVo emailVo) {
		RandomNumber cr= new RandomNumber();
		String randomNumber = cr.makeRandomNumber();
		EmailAuthenticationCode.sendMail("테스트", randomNumber, emailVo.getEmail());
		return randomNumber;
	}

	
}
