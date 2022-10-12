package com.LoginAndSignUp.SignUp.email.Service;

import com.LoginAndSignUp.SignUp.email.DTO.EmailDTO;

public interface EmailService {
	
	public String sendEamil(EmailDTO emailVo);
}
