package com.LoginAndSignUp.ChangePwd.NewPwd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewPwdServiceImpl implements NewPwdService{

	@Autowired
	NewPwdDAO newPwdDAO;
	
	@Override
	public void changeNewPwd(String userId , String newPwd) {
		
		
	}
	
}
