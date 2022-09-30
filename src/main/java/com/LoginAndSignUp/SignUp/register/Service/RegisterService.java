package com.LoginAndSignUp.SignUp.register.Service;

import java.util.ArrayList;

import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.SignUp.register.DTO.RegisterDTO;
import com.LoginAndSignUp.SignUp.register.Repository.Member;
import com.LoginAndSignUp.SignUp.register.Repository.MemberCode;

public interface RegisterService {
	
	public void registerMember(RegisterDTO registerVo);
	
}
