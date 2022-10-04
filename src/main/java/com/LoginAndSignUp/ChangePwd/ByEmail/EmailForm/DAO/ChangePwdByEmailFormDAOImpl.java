package com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberRepository;


@Component
public class ChangePwdByEmailFormDAOImpl implements ChangePwdByEmailFormDAO {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public String changePwdByEmail(Member member) {
		if(!memberRepository.existsByUserId(member.getUserId())) {
			return "notExist";
		}
		if(!memberRepository.existsByUserEmail(member.getUserEmail())) {
			return "notExist";
		}
		return "exist";
	}

}
