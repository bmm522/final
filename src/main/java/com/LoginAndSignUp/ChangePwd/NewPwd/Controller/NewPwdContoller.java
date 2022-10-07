package com.LoginAndSignUp.ChangePwd.NewPwd.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.ChangePwd.NewPwd.Service.NewPwdService;
import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
public class NewPwdContoller {
	ArrayList<CodeEntity> hashCodeArr = new ArrayList<CodeEntity>();
	
	@Autowired
	NewPwdService newPwdService;
	
	@PostMapping("/change/password")
	@ResponseBody
	public void changeNewPwd(@RequestBody String data) {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(data);
		newPwdService.changeNewPwd(element.getAsJsonObject().get("userId").getAsString(),
																	   element.getAsJsonObject().get("newPwd").getAsString());
		
		
	}
	
}
