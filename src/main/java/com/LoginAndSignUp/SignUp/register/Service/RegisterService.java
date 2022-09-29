package com.LoginAndSignUp.SignUp.register.Service;

import java.util.ArrayList;

import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.SignUp.register.entity.MemberCodeDTO;
import com.LoginAndSignUp.SignUp.register.entity.MemberDTO;
import com.LoginAndSignUp.SignUp.register.entity.RegisterVo;

public interface RegisterService {
	
	public void registerMember(RegisterVo registerVo);
	
}
