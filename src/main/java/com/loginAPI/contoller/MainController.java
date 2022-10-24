package com.loginAPI.contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.loginAPI.model.User;
import com.loginAPI.service.EmailAuthService;
import com.loginAPI.service.PhoneAuthService;
import com.loginAPI.service.RegisterService;
import com.loginAPI.service.UserNameDuplicateCheckService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	@Autowired
	private RegisterService registerService;
	@Autowired
	private EmailAuthService emailAuthService;
	@Autowired
	private PhoneAuthService phoneAuthService;
	@Autowired
	private UserNameDuplicateCheckService userNameDuplicateCheckService;
	
	
	@PostMapping("loginapi/register")
	public void register(User user) {
		registerService.register(user);
	}
	
	@ResponseBody
	@PostMapping("loginapi/username/inspection")
	public Map<String, Object> duplicateCheck(@RequestBody String username){
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
		String result = userNameDuplicateCheckService.duplicateCheck(asString(username,"username"));
		resultMap.put("result", result);
		return resultMap;
	}
	
	@ResponseBody
	@PostMapping("loginapi/email_auth")
	public Map<String, Object> emailAuth(@RequestBody String email) {
		HashMap<String, Object> authCodeMap = new HashMap<String,Object>();
		String authCode = emailAuthService.emailAuth(asString(email,"email"));
		authCodeMap.put("authCode" , authCode);
		return authCodeMap;
	}
	
	@ResponseBody
	@PostMapping("loginapi/phone_auth")
	public Map<String, Object> phoneAuth(@RequestBody String phone){
		HashMap<String, Object> authCodeMap = new HashMap<String, Object>();
		String authCode = phoneAuthService.phoneAuth(asString(phone,"phone"));
		authCodeMap.put("authCode", authCode);
		return authCodeMap;
	}
	
	private String asString(String data,String dataname) {
		try{
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(data);
			return element.getAsJsonObject().get(dataname).getAsString();
		} catch(Exception e) {
			log.error("not JsonObject");
		}
		return "not JsonObject";
	}
}
