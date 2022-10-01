package com.LoginAndSignUp.Login.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.MemberRepository;

@Component
public class LoginHashCodeDAOImpl  implements LoginHashCode{
	
	@Autowired
	MemberRepository memberRepository;
	
	public String getHashCode(String userId) {
			return memberRepository.getHashCode(userId);
	}
}
