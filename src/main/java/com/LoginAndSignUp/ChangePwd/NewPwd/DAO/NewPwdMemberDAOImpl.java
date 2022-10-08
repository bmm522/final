package com.LoginAndSignUp.ChangePwd.NewPwd.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberCode;
import com.LoginAndSignUp.Repository.MemberCodeRepository;
import com.LoginAndSignUp.Repository.MemberRepository;

@Component
public class NewPwdMemberDAOImpl implements NewPwdMemberDAO{

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public void updateMemberPwd(Member member) {
		System.out.println(member.getUserId());
		System.out.println(member.getUserPwd());
		memberRepository.updatePwd( member.getUserPwd(), member.getUserId());
		
	}
	
	
}
