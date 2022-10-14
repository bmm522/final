package com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DTO.ChangePwdByEmailFormDTO;
import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.Service.ChangePwdByEmailFormService;
import com.LoginAndSignUp.SignUp.email.API.GmailAPI;


@RestController
public class ChangePwdByEmailFormController {
	
	@Autowired
	private ChangePwdByEmailFormService changePwdByEmailFormService;
	
	@PostMapping("/password/new/email/authentication-number")
	@ResponseBody
	public Map<String, Object> changePwdByEmail(ChangePwdByEmailFormDTO changePwdByEmailFormDTO){
		HashMap<String,Object> checkArr = new HashMap<String,Object>();
		checkArr.put("authenticationNumber",changePwdByEmailFormService.changePwdByEmail(changePwdByEmailFormDTO));
		return checkArr;
	}
}
