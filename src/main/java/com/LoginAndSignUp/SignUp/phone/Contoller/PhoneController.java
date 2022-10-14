package com.LoginAndSignUp.SignUp.phone.Contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.SignUp.phone.DTO.PhoneDTO;
import com.LoginAndSignUp.SignUp.phone.Service.PhoneService;
import com.LoginAndSignUp.SignUp.phone.Service.PhoneServiceImpl;

@RestController
public class PhoneController {
	
	
	PhoneService ps =new PhoneServiceImpl();
	
	@PostMapping("/phone/authentication-number")
	@ResponseBody
	public Map<String, Object> sendMessage(PhoneDTO phoneDTO){
		HashMap<String,Object> authenticationNumber = new HashMap<String,Object>();
		authenticationNumber.put("authenticationNumber", ps.sendMessage(phoneDTO));
		return authenticationNumber;
	}
}