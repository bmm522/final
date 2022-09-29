package com.LoginAndSignUp.SignUp.phone.API;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class PhoneAPI {
	
//	@Value("${apiKey}")
	private String apiKey = "NCS0FCUMH1GYP77P";

//	@Value("${apiSecret}")
	private String apiSecret = "JK7R0PYOF9EPUTLXHOCGBCDAJ5DT0SWF";

//	@Value("${fromNumber}")
	private String fromNumber = "01020575015";

	public void sendMessage(String phoneNumber, String  authenticationNumber) {
		System.out.println("phoneapi");
		Message coolsms = new Message(apiKey, apiSecret);

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phoneNumber);
		params.put("from", fromNumber);
		params.put("type", "SMS");
		params.put("text", "[grabMe] 인증번호 "+authenticationNumber+" 를 입력하세요.");
		params.put("LoginAndSingUpForm", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println("api실행");
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println("api에러");
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}
