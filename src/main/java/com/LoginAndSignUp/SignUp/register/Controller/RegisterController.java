package com.LoginAndSignUp.SignUp.register.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.SignUp.register.Service.RegisterServiceImpl;
import com.LoginAndSignUp.SignUp.register.entity.RegisterVo;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class RegisterController {
	
	@Autowired
	private RegisterServiceImpl rs;
	
	@PostMapping("/signup/register")
	@ResponseBody
	public void registerMember(RegisterVo registerVo){
		System.out.println(registerVo.getUserId());
		System.out.println(registerVo.getUserPwd());
		System.out.println(registerVo.getUserName());
		System.out.println(registerVo.getUserBirth());
		System.out.println(registerVo.getUserAddress());
		System.out.println(registerVo.getUserEmail());
		System.out.println(registerVo.getUserPhone());
		rs.registerMember(registerVo);
	}
}
