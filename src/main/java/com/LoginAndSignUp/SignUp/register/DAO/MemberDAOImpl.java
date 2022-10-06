package com.LoginAndSignUp.SignUp.register.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	final MemberRepository memberRepository;

	@Override
	public void registerMember(Member member) {
		memberRepository.save(member);
	}
	
}
