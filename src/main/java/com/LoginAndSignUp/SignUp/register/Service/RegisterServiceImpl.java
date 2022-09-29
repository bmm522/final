package com.LoginAndSignUp.SignUp.register.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.CodeEncryption.main.CodeEncryptionOfOneWay;
import com.LoginAndSignUp.SignUp.register.DAO.MemberCodeDAO;
import com.LoginAndSignUp.SignUp.register.DAO.MemberCodeDAOImpl;
import com.LoginAndSignUp.SignUp.register.DAO.MemberDAO;
import com.LoginAndSignUp.SignUp.register.DAO.MemberDAOImpl;
import com.LoginAndSignUp.SignUp.register.entity.RegisterVo;
import com.LoginAndSignUp.SignUp.register.repository.MemberCode;
import com.LoginAndSignUp.SignUp.register.repository.Member;

@Service
public class RegisterServiceImpl  implements RegisterService{
	
	@Autowired
	private MemberDAOImpl memberDAO;
	
	@Autowired
	private MemberCodeDAOImpl memberCodeDAO;
	
	public void registerMember(RegisterVo registerVo) {
		ArrayList<CodeEntity> cdArr =changePwdToHashCode(registerVo.getUserId(), registerVo.getUserPwd());
		memberDAO.registerMember(getMemberDTO(registerVo,cdArr.get(0).getHashCode()));
		memberCodeDAO.registerMemberCode(getMemberCodeDTO(registerVo,cdArr.get(0).getSaltCode()));
		
	}
	
	private Member getMemberDTO(RegisterVo registerVo, String hashCode) {
		return new Member(registerVo.getUserId()
												   ,hashCode
					  							   ,registerVo.getUserName()
												   ,registerVo.getUserEmail()
									               ,registerVo.getUserBirth()
									               ,registerVo.getUserPhone()
								                   ,registerVo.getUserAddress());
	}
	
	private MemberCode getMemberCodeDTO(RegisterVo registerVo, String salt) {
		return new MemberCode(registerVo.getUserId()
															 ,salt
															 ,registerVo.getUserEmail()
															 ,registerVo.getUserPhone());
	}
	
	private ArrayList<CodeEntity> changePwdToHashCode(String userId, String userPwd){
		CodeEncryptionOfOneWay cw = new CodeEncryptionOfOneWay(userId, userPwd);
		return cw.getEncryptingCode();
	}
	
}
