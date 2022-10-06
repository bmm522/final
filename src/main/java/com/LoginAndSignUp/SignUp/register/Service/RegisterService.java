package com.LoginAndSignUp.SignUp.register.Service;

import java.util.ArrayList;

import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberCode;
import com.LoginAndSignUp.SignUp.register.DTO.RegisterDTO;

public interface RegisterService {
	
	public void registerMember(RegisterDTO registerVo);
	
}
