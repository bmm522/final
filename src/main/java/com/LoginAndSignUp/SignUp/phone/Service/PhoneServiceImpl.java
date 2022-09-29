package com.LoginAndSignUp.SignUp.phone.Service;

import com.LoginAndSignUp.SignUp.RandomNumber;
import com.LoginAndSignUp.SignUp.phone.API.PhoneAPI;
import com.LoginAndSignUp.SignUp.phone.entity.PhoneVo;

public class PhoneServiceImpl implements PhoneService {
	PhoneAPI pa = new PhoneAPI();
	
	public String sendMessage(PhoneVo phoneVo) {
		System.out.println("service");
		RandomNumber cr =new RandomNumber();
		String authenticationNumber = cr.makeRandomNumber();
		pa.sendMessage(phoneVo.getPhoneNumber(),authenticationNumber);
		return authenticationNumber;
	}
	
}