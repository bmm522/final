package com.LoginAndSignUp.SignUp.email.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.SignUp.email.DTO.EmailDTO;
import com.LoginAndSignUp.SignUp.email.Service.EmailService;
import com.LoginAndSignUp.SignUp.email.Service.EmailServiceImpl;

@RestController
public class EmailController {
	
	
	 EmailService emailService = new EmailServiceImpl();
	
	@PostMapping("email/authentication-number")
	@ResponseBody
	public Map<String, Object> sendEmail(EmailDTO emailDTO) {
		HashMap<String, Object> randomNumber = new HashMap<String, Object>();
		randomNumber.put("authenticationNumber", emailService.sendEamil(emailDTO));
		return randomNumber;
		
		
	}
	
	
	
	
	
	
}
