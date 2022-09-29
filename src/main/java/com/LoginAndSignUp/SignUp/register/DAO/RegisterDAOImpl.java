package com.LoginAndSignUp.SignUp.register.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginAndSignUp.SignUp.register.repository.MemberCodeEntity;
import com.LoginAndSignUp.SignUp.register.repository.MemberCodeRepository;
import com.LoginAndSignUp.SignUp.register.repository.MemberEntity;
import com.LoginAndSignUp.SignUp.register.repository.MemberRepository;


@Service
public class RegisterDAOImpl implements RegisterDAO{

	private final MemberRepository memberRepository;
	
	private final MemberCodeRepository memberCodeRepository;
	
	@Autowired
	public RegisterDAOImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Autowired
	public RegisterDAOImpl(MemberCodeRepository memberCodeRepository) {
		this.memberCodeRepository=memberCodeRepository;
	}
	
	@Override
	public void registerMember(MemberEntity memberDTO) {
		memberRepository.save(memberDTO);
	}

	@Override
	public void registerMemberCode(MemberCodeEntity memberCodeDTO) {
		memberCodeRepository.save(memberCodeDTO);	
	}
	
}
