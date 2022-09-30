package com.LoginAndSignUp.SignUp.checkDuplicateOfId.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.SignUp.register.Repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CheckDuplicateOfIdDAOImpl implements CheckDuplicateOfIdDAO{
	
	@Autowired
	final MemberRepository memberRepository;
	
	public boolean getCheckIdResult(String userId) {
		memberRepository.existsByUserId(userId);
	}
}
