package com.LoginAndSignUp.ChangePwd.NewPwd.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberRepository;

@Component
public class NewPwdMemberDAOImpl implements NewPwdMemberDAO{

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	@Transactional
	public void updateMemberPwd(Member member) {
		memberRepository.updatePwd(member.getUserPwd(), member.getUserId());
		
		
	}
	
	
}
