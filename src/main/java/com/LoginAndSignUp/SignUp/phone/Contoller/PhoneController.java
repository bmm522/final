package com.LoginAndSignUp.SignUp.phone.Contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.SignUp.phone.DTO.PhoneDTO;
import com.LoginAndSignUp.SignUp.phone.Service.PhoneServiceImpl;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class PhoneController {
	
	
	PhoneServiceImpl ps =new PhoneServiceImpl();
	
	@PostMapping("/signup/phone/authenticationNumber")
	@ResponseBody
	public Map<String, Object> sendMessage(PhoneDTO phoneDTO){
		HashMap<String,Object> authenticationNumber = new HashMap<String,Object>();
		authenticationNumber.put("authenticationNumber", ps.sendMessage(phoneDTO));
		return authenticationNumber;
	}
}