package com.LoginAndSignUp.SearchId.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.MemberRepository;
import com.LoginAndSignUp.SearchId.DTO.SearchIdDTO;

@Component
public class SearchIdDAOImpl implements SearchIdDAO{
	
	@Autowired
	MemberRepository memberReposiotry;
	
	public String searchId(SearchIdDTO searchIdDTO) {
		if(!memberReposiotry.existsByUserName(searchIdDTO.getSearchName())) {
			return "notExist";
		}
		if(!memberReposiotry.existsByUserEamil(searchIdDTO.getSearchEmail())) {
			return "notExist";
		}
		if(!memberReposiotry.existsByUserBirth(searchIdDTO.getSearchBirth())) {
			return "notExist";
		}
		return memberReposiotry.getUserIdByUserEmail(searchIdDTO.getSearchEmail());
	}
}
