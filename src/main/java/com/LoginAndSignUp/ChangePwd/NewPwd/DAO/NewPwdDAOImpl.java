package com.LoginAndSignUp.ChangePwd.NewPwd.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberCode;
import com.LoginAndSignUp.Repository.MemberCodeRepository;
import com.LoginAndSignUp.Repository.MemberRepository;

@Component
public class NewPwdDAOImpl implements NewPwdDAO{

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberCodeRepository memberCodeRepository;
	
	@Override
	public void updateMemberPwd(Member member, MemberCode memberCode) {
		memberRepository.updatePwd(member.getUserId(), member.getUserPwd());
		memberCodeRepository.updatePwd(memberCode.getUserId(), memberCode.getSalt());
		
	}
	
	
}
