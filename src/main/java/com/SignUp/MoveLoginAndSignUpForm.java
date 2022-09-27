package com.SignUp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoveLoginAndSignUpForm {
	
	@GetMapping("/login")
	public String noticeBoardLoginForm() {
		return "SignUpForm";
	}
}
