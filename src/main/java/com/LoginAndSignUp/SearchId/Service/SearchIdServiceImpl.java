package com.LoginAndSignUp.SearchId.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.SearchId.DAO.SearchIdDAO;
import com.LoginAndSignUp.SearchId.DTO.SearchIdDTO;

@Service
public class SearchIdServiceImpl  implements SearchIdService{
	
	@Autowired
	private SearchIdDAO searchIdDAO;
	
	public String searchId(SearchIdDTO searchIdDTO) {
		return searchIdDAO.searchId(Member.MemberBuilder()
																 .userName(searchIdDTO.getSearchName())
																 .userEmail(searchIdDTO.getSearchEmail())
																 .userBirth(searchIdDTO.getSearchBirth())
																 .build());
	}
}
