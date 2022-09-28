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
	
	
	RegisterServiceImpl rs = new RegisterServiceImpl();
	
	@PostMapping("/signup/register")
	@ResponseBody
	public void registerMember(RegisterVo registerVo){
		rs.registerMember(registerVo);
	}
}
