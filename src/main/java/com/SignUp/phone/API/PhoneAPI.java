package com.SignUp.phone.API;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import com.SignUp.RandomNumber;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class PhoneAPI {
	
	@Value("${apiKey}")
	private String apiKey;

	@Value("${apiSecret}")
	private String apiSecret;

	@Value("${fromNumber}")
	private String fromNumber;

	public void sendMessage(String toNumber) {
		RandomNumber rn = new RandomNumber();
		Message coolsms = new Message(apiKey, apiSecret);

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", toNumber);
		params.put("from", fromNumber);
		params.put("type", "SMS");
		params.put("text", "[grabMe] 인증번호 "+rn.makeRandomNumber()+" 를 입력하세요.");
		params.put("LoginAndSingUpForm", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}
