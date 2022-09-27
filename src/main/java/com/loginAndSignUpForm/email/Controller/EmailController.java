package com.loginAndSignUpForm.email.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginAndSignUpForm.email.EmailVo;
import com.loginAndSignUpForm.email.Service.EmailServiceImpl;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class EmailController {
	EmailServiceImpl es = new EmailServiceImpl();
	
	@PostMapping("/signup/email/randomnumber")
	@ResponseBody
	public Map<String, Object> sendEmail(EmailVo emailVo) {
		HashMap<String, Object> randomNumber = new HashMap<String, Object>();
		randomNumber.put("randomNumber", es.sendEamil(emailVo));
		return randomNumber;
		
		
	}
	
	
	
	
	
	
}
