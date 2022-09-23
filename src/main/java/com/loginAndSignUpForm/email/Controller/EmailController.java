package com.loginAndSignUpForm.email.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {
	
	@GetMapping("/login/email/get")
	public String signUpForm() {
		return "";
	}
}
