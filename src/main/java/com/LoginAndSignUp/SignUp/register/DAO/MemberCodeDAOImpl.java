package com.LoginAndSignUp.SignUp.register.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.SignUp.register.repository.MemberCode;
import com.LoginAndSignUp.SignUp.register.repository.MemberCodeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MemberCodeDAOImpl implements MemberCodeDAO{
	
	@Autowired
	final MemberCodeRepository memberCodeRepository;
	
	@Override
	public void registerMemberCode(MemberCode memberCodeEntity) {
				memberCodeRepository.save(memberCodeEntity);
	}


}
