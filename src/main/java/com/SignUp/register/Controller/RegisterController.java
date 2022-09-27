package com.SignUp.register.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SignUp.register.Service.RegisterServiceImpl;
import com.SignUp.register.VO.RegisterVo;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class RegisterController {
	
	@Autowired
	private RegisterServiceImpl rs ;
	
	@PostMapping("/signup/register")
	@ResponseBody
	public void registerMember(RegisterVo registerVo){
		rs.registerMember(registerVo);
	}
}
