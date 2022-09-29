package com.LoginAndSignUp.SignUp.register.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.CodeEncryption.main.CodeEncryptionOfOneWay;
import com.LoginAndSignUp.SignUp.register.DAO.RegisterDAO;
import com.LoginAndSignUp.SignUp.register.DAO.RegisterDAOImpl;
import com.LoginAndSignUp.SignUp.register.entity.MemberCodeDTO;
import com.LoginAndSignUp.SignUp.register.entity.MemberDTO;
import com.LoginAndSignUp.SignUp.register.entity.RegisterVo;

@Service
public class RegisterServiceImpl  implements RegisterService{
	
	RegisterDAO registerDAO = new RegisterDAOImpl();
	
	public void registerMember(RegisterVo registerVo) {
		ArrayList<CodeEntity> cdArr =changePwdToHashCode(registerVo.getUserId(), registerVo.getUserPwd());
		registerDAO.registerMember(getMemberDTO(registerVo,cdArr.get(0).getHashCode()));
		 registerDAO.registerMemberCode(getMemberCodeDTO(registerVo,cdArr.get(0).getSaltCode()));
		
	}
	
	private MemberDTO getMemberDTO(RegisterVo registerVo, String hashCode) {
		return new MemberDTO(registerVo.getUserId()
												   ,hashCode
					  							   ,registerVo.getUserName()
												   ,registerVo.getUserEmail()
									               ,registerVo.getUserBirth()
									               ,registerVo.getUserPhone()
								                   ,registerVo.getUserAddress());
	}
	
	private MemberCodeDTO getMemberCodeDTO(RegisterVo registerVo, String salt) {
		return new MemberCodeDTO(registerVo.getUserId()
															 ,salt
															 ,registerVo.getUserEmail()
															 ,registerVo.getUserPhone());
	}
	
	private ArrayList<CodeEntity> changePwdToHashCode(String userId, String userPwd){
		CodeEncryptionOfOneWay cw = new CodeEncryptionOfOneWay(userId, userPwd);
		return cw.getEncryptingCode();
	}
	
}
