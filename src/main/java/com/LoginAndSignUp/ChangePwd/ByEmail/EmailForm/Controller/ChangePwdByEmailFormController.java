package com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DTO.ChangePwdByEmailFormDTO;
import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.Service.ChangePwdByEmailFormService;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class ChangePwdByEmailFormController {
	
	@Autowired
	private ChangePwdByEmailFormService changePwdByEmailFormService;
	
	@PostMapping("/change/password/email")
	@ResponseBody
	public Map<String, Object> changePwdByEmail(ChangePwdByEmailFormDTO changePwdByEmailFormDTO){
		HashMap<String,Object> checkDB = new HashMap<String,Object>();
		checkDB.put("checkDB",changePwdByEmailFormService.changePwdByEmail(changePwdByEmailFormDTO));
		return checkDB;
	}
}
