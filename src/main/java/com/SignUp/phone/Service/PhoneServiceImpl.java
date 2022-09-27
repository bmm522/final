package com.SignUp.phone.Service;

import com.SignUp.RandomNumber;
import com.SignUp.phone.API.PhoneAPI;

public class PhoneServiceImpl implements PhoneService {
	PhoneAPI pa = new PhoneAPI();
	
	public String sendMessage(String phoneNumber) {
		System.out.println("service");
		RandomNumber cr =new RandomNumber();
		String authenticationNumber = cr.makeRandomNumber();
		pa.sendMessage(phoneNumber,authenticationNumber);
		return authenticationNumber;
	}
	
}
