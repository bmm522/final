package com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DTO.ChangePwdByEmailFormDTO;
import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberRepository;


@Component
public class ChangePwdByEmailFormDAOImpl implements ChangePwdByEmailFormDAO {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public boolean changePwdByEmail(Member member) {
		System.out.println();
		
		if(!memberRepository.existsByUserId(member.getUserId())) {
			return false;
		}
		if(!memberRepository.existsByUserEmail(member.getUserEmail())) {
			return false;
		}
		return true;
	}

}
