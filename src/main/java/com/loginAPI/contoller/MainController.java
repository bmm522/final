package com.loginAPI.contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loginAPI.model.User;
import com.loginAPI.service.EmailAuthService;
import com.loginAPI.service.RegisterService;

@Controller
public class MainController {
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private EmailAuthService emailAuthService;
	
	@PostMapping("/register")
	public void register(User user) {
		registerService.register(user);
	}
	
	@ResponseBody
	@PostMapping("/email_auth")
	public Map<String, Object> emailAuth(@RequestBody String email) {
		HashMap<String, Object> authCodeMap = new HashMap<String,Object>();
		String authCode = emailAuthService.emailAuth(email);
		authCodeMap.put("authCode" , authCode);
		return authCodeMap;
	}
}
