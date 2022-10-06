package com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DAO;

import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DTO.ChangePwdByEmailFormDTO;
import com.LoginAndSignUp.Repository.Member;

public interface ChangePwdByEmailFormDAO {

	boolean changePwdByEmail(Member member);
	
}
