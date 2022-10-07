package com.LoginAndSignUp.ChangePwd.NewPwd.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.ChangePwd.NewPwd.DTO.NewPwdDTO;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class NewPwdContoller {
	
	@PostMapping("/change/password")
	@ResponseBody
	public void changeNewPwd(NewPwdDTO newPwdDTO) {
		
		System.out.println(newPwdDTO.getNewPwd());
		System.out.println(newPwdDTO.getCheckNewPwd());
	}
	
}
