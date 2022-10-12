package com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.DTO.CertificationEmailCodeDTO;
import com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.Serivce.CertificationEmailCodeService;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class CertificationEmailCodeController {
	
	@Autowired
	private CertificationEmailCodeService certificationEmailCodeSerivce;
	
	@PostMapping("/change/password/email/certificationEmailCode")
	@ResponseBody
	public Map<String, Object> sendCode(CertificationEmailCodeDTO certificationEmailCodeDTO){
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("randomNumber", certificationEmailCodeSerivce.sendCode( certificationEmailCodeDTO));
		return result;
	}
}
