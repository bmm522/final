package com.LoginAndSignUp.ChangePwd.NewPwd.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginAndSignUp.ChangePwd.NewPwd.DAO.NewPwdDAO;
import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberCode;
import com.LoginAndSignUp.SignUp.register.Service.RegisterService;
import com.LoginAndSignUp.SignUp.register.Service.RegisterServiceImpl;

@Service
public class NewPwdServiceImpl implements NewPwdService{
	
	ArrayList<CodeEntity> hashCodeArr = new ArrayList<CodeEntity>();
	
	@Autowired
	NewPwdDAO newPwdDAO;
	
	@Override
	public void changeNewPwd(String userId , String newPwd) {
		RegisterService registerService = new RegisterServiceImpl();
		hashCodeArr = registerService.changePwdToHashCode(userId, newPwd);
		newPwdDAO.updateMemberPwd(getMember(userId, hashCodeArr.get(0).getHashCode()),
																		getMemberCode(userId, hashCodeArr.get(0).getSaltCode()));
		
	}
	
	private Member getMember(String userId, String hashCode) {
		return Member.MemberBuilder()
					.userId(userId)
					.userPwd(hashCode)
					.build();
	}
	
	private MemberCode getMemberCode(String userId, String salt) {
		return MemberCode.MemberCodeBuilder()
					.userId(userId)
					.salt(salt)
					.build();
	}
	
}
