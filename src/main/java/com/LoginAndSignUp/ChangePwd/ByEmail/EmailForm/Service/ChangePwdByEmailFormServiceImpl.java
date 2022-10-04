package com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DAO.ChangePwdByEmailFormDAO;
import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DTO.ChangePwdByEmailFormDTO;
import com.LoginAndSignUp.Repository.Member;

@Service
public class ChangePwdByEmailFormServiceImpl  implements ChangePwdByEmailFormService{
	@Autowired
	private ChangePwdByEmailFormDAO changePwdByEmailFormDAO;
	
	@Override
	public String changePwdByEmail(ChangePwdByEmailFormDTO changePwdByEmailFormDTO) {
		return changePwdByEmailFormDAO.changePwdByEmail(Member.MemberBuilder()
																										  .userId(changePwdByEmailFormDTO.getUserId())
																										  .userEmail(changePwdByEmailFormDTO.getUserEmail())
																										  .build());
		
	}

	
}
