package com.LoginAndSignUp.Login.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.Login.DTO.LoginDTO;
import com.LoginAndSignUp.Login.Service.LoginService;

@RestController
public class LoginController {
		
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	@ResponseBody
	public Map<String,Object> login(LoginDTO loginDTO){
		HashMap<String,Object> checkResult = new HashMap<String,Object>();
		checkResult.put("loginResult", loginService.login(loginDTO));
		return checkResult;
	}
}
