package com.LoginAndSignUp.SignUp.checkDuplicateOfId.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoginAndSignUp.SignUp.checkDuplicateOfId.DAO.CheckDuplicateOfIdDAO;
import com.LoginAndSignUp.SignUp.checkDuplicateOfId.DTO.CheckIdDTO;

@RestController
public class CheckDuplicateOfIdController {
	
	@Autowired
	private CheckDuplicateOfIdDAO checkDuplicateOfIdDAO;
	
	@PostMapping("/id/checkresult")
	@ResponseBody
	public Map<String,Object> checkDuplicateOfId(CheckIdDTO checkIdDTO ){
		HashMap<String, Object> checkResult =  new HashMap<String, Object>();
		checkResult.put("checkIdResult", checkDuplicateOfIdDAO.getCheckIdResult(checkIdDTO.getUserId()));
		return checkResult;
	}
}
