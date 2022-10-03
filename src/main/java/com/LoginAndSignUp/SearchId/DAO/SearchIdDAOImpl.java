package com.LoginAndSignUp.SearchId.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberRepository;

@Component
public class SearchIdDAOImpl implements SearchIdDAO{
	
	@Autowired
	MemberRepository memberReposiotry;
	
	public String searchId(Member member) {
		if(!memberReposiotry.existsByUserName(member.getUserName())) {
			return "notExist";
		}
		if(!memberReposiotry.existsByUserEmail(member.getUserEmail())) {
			return "notExist";
		}
		if(!memberReposiotry.existsByUserBirth(member.getUserBirth())) {
			return "notExist";
		}
		return memberReposiotry.getUserIdByUserEmail(member.getUserEmail());
	}
}
