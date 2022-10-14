package com.LoginAndSignUp.SignUp.register.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.SignUp.register.DTO.RegisterDTO;
import com.LoginAndSignUp.SignUp.register.Service.RegisterService;

@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping("/signup")
	@ResponseBody
	public void registerMember(RegisterDTO registerDTO){
		registerService.registerMember(registerDTO);
	}
}
