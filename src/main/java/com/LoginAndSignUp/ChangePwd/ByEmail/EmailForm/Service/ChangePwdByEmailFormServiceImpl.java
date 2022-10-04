package com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DTO.ChangePwdByEmailFormDTO;
import com.LoginAndSignUp.Repository.Member;

public class ChangePwdByEmailFormServiceImpl  implements ChangePwdByEmailFormService{
	@Autowired
	private ChangePwdByEmailFormDAO changePwdByEmailFormDAO;
	
	@Override
	public String changePwdByEmail(ChangePwdByEmailFormDTO changePwdByEmailFormDTO) {
		return changePwdByEmailFormDAO.changePwdByEmail(Member.MemberBuilder()
																										  .userId(changePwdByEmailFormDTO.getUserId())
																										  .userEmail(changePwdByEmailFormDTO.getUserEmail()))
		
	}

	
}
