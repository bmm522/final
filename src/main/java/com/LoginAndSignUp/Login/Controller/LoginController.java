package com.LoginAndSignUp.Login.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.Login.DTO.LoginDTO;
import com.LoginAndSignUp.Login.Service.LoginServiceImpl;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class LoginController {
		
	@Autowired
	private LoginServiceImpl loginService;
	
	@PostMapping("/login")
	@ResponseBody
	public Map<String,Object> login(LoginDTO loginDTO){
		HashMap<String,Object> checkResult = new HashMap<String,Object>();
		checkResult.put("loginResult", loginService.login(loginDTO));
		System.out.println(checkResult.get("loginResult"));
		return checkResult;
	}
}
