package com.LoginAndSignUp.Login.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.MemberCodeRepository;

@Component
public class LoginSaltDAOImpl implements LoginSaltDAO{
	
	@Autowired
	MemberCodeRepository memberCodeRepository;
	
	public String getSalt(String userId) {
		return memberCodeRepository.getSalt(userId);
	}
}
