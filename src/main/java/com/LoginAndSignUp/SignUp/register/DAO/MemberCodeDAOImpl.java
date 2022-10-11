package com.LoginAndSignUp.SignUp.register.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.MemberCode;
import com.LoginAndSignUp.Repository.MemberCodeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MemberCodeDAOImpl implements MemberCodeDAO{
	
	@Autowired
	MemberCodeRepository memberCodeRepository;
	
	@Override
	public void registerMemberCode(MemberCode memberCode) {
		memberCodeRepository.save(memberCode);
	}


}
