package com.LoginAndSignUp.SearchId.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberRepository;

@Component
public class SearchIdDAOImpl implements SearchIdDAO{
	
	@Autowired
	MemberRepository memberRepository;
	
	public String searchId(Member member) {
		if(!memberRepository.existsByUserName(member.getUserName())) {
			return "notExist";
		}
		if(!memberRepository.existsByUserEmail(member.getUserEmail())) {
			return "notExist";
		}
		if(!memberRepository.existsByUserBirth(member.getUserBirth())) {
			return "notExist";
		}
		return memberRepository.getUserIdByUserEmail(member.getUserEmail());
	}
}
