package com.LoginAndSignUp.SignUp.register.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.CodeEncryption.main.CodeEncryptionOfOneWay;
import com.LoginAndSignUp.SignUp.register.entity.RegisterVo;
import com.LoginAndSignUp.SignUp.register.repository.RegisterRepository;

@Service
public class RegisterServiceImpl  implements RegisterService{
	
	@Autowired
	private RegisterRepository registerRepository;
	
	public void registerMember(RegisterVo registerVo) {
		ArrayList<CodeEntity> cdArr =changePwdToHashCode(registerVo.getUserId(), registerVo.getUserPwd());
		 RegisterVo registerDao = getMemberTableDao(registerVo, cdArr.get(0).getHashCode());
		registerRepository.save(registerDao);
	}
	
	private RegisterVo getMemberTableDao(RegisterVo registerVo, String HashCode) {
		registerVo.setUserPwd(HashCode);
		return registerVo;
		
	}
	
	private ArrayList<CodeEntity> changePwdToHashCode(String userId, String userPwd){
		CodeEncryptionOfOneWay cw = new CodeEncryptionOfOneWay(userId, userPwd);
		return cw.getEncryptingCode();
	}
	
}
