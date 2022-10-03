package com.LoginAndSignUp.SearchId.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginAndSignUp.SearchId.DAO.SearchIdDAOImpl;
import com.LoginAndSignUp.SearchId.DTO.SearchIdDTO;

@Service
public class SearchIdServiceImpl  implements SearchIdService{
	
	@Autowired
	private SearchIdDAOImpl searchIdDAO;
	
	public String searchId(SearchIdDTO searchIdDTO) {
		return searchIdDAO.searchId(searchIdDTO);
	}
}
