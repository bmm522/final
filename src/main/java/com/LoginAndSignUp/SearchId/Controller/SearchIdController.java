package com.LoginAndSignUp.SearchId.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.SearchId.DTO.SearchIdDTO;
import com.LoginAndSignUp.SearchId.Service.SearchIdService;

@RestController
public class SearchIdController {
	
	@Autowired
	private SearchIdService searchIdService;
	
	@PostMapping("/search-id/result")
	@ResponseBody
	public Map<String, Object> searchId(SearchIdDTO searchIdDTO){
		HashMap<String, Object> searchIdResult = new HashMap<String,Object>();
		searchIdResult.put("searchIdResult",searchIdService.searchId(searchIdDTO) );
		return searchIdResult;
	}

}
