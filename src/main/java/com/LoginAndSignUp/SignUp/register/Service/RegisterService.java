package com.LoginAndSignUp.SignUp.register.Service;

import java.util.ArrayList;

import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.SignUp.register.repository.MemberCode;
import com.LoginAndSignUp.SignUp.register.DTO.RegisterDTO;
import com.LoginAndSignUp.SignUp.register.repository.Member;

public interface RegisterService {
	
	public void registerMember(RegisterDTO registerVo);
	
}
