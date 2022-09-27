package com.SignUp.phone.Contoller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SignUp.phone.VO.PhoneVo;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class PhoneController {
	
	@PostMapping("/signup/phone/authenticationNumber")
	@ResponseBody
	public Map<String, Object> sendMessage(PhoneVo phoneVo){
		
	}
}
