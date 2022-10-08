package com.LoginAndSignUp.ChangePwd.NewPwd.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LoginAndSignUp.Repository.MemberCode;
import com.LoginAndSignUp.Repository.MemberCodeRepository;

@Component
public class NewPwdMemberCodeDAOImpl implements NewPwdMemberCodeDAO{
	
	@Autowired
	MemberCodeRepository memberCodeRepository;
	
	@Override
	public void updateMemberCodeSalt(MemberCode memberCode) {
		memberCodeRepository.updatePwd(memberCode.getSalt(), memberCode.getUserId());
		
	}

}
