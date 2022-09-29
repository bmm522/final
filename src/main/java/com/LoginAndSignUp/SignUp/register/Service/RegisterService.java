package com.LoginAndSignUp.SignUp.register.Service;

import java.util.ArrayList;

import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.SignUp.register.entity.RegisterVo;
import com.LoginAndSignUp.SignUp.register.repository.MemberCodeEntity;
import com.LoginAndSignUp.SignUp.register.repository.MemberEntity;

public interface RegisterService {
	
	public void registerMember(RegisterVo registerVo);
	
}
