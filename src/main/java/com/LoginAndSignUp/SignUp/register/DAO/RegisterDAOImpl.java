package com.LoginAndSignUp.SignUp.register.DAO;

import org.springframework.beans.factory.annotation.Autowired;

import com.LoginAndSignUp.SignUp.register.entity.MemberCodeDTO;
import com.LoginAndSignUp.SignUp.register.entity.MemberDTO;
import com.LoginAndSignUp.SignUp.register.repository.MemberCodeRepository;
import com.LoginAndSignUp.SignUp.register.repository.MemberRepository;

public class RegisterDAOImpl implements RegisterDAO{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberCodeRepository memberCodeRepository;
	
	@Override
	public void registerMember(MemberDTO memberDTO) {
		memberRepository.save(memberDTO);
	}

	@Override
	public void registerMemberCode(MemberCodeDTO memberCodeDTO) {
		memberCodeRepository.save(memberCodeDTO);	
	}
	
}
