package com.LoginAndSignUp.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginAndSignUp.CodeEncryption.action.check.CheckMatchingCode;
import com.LoginAndSignUp.Login.DAO.LoginHashCodeDAOImpl;
import com.LoginAndSignUp.Login.DAO.LoginSaltDAOImpl;
import com.LoginAndSignUp.Login.DTO.LoginDTO;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginSaltDAOImpl loginSaltDAO;
	
	@Autowired
	private LoginHashCodeDAOImpl loginHashCodeDAO;
	
	@Override
	public boolean login(LoginDTO loginDTO) {
		return checkLogincheck(loginDTO.getUserId(), 
													  loginDTO.getUserPWd(),
													  getSalt(loginDTO.getUserId()),
													  getHashCode(loginDTO.getUserId()));
		
	}
	private String getSalt(String userId) {
		return loginSaltDAO.getSalt(userId);
	}
	
	private String getHashCode(String userId) {
		return loginHashCodeDAO.getHashCode(userId);
	}
	
	private boolean checkLogincheck(String userId, String userPWd) {
		CheckMatchingCode cmc = new CheckMatchingCode();
		
	}
	
}
