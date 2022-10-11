package com.LoginAndSignUp.ChangePwd.NewPwd.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.LoginAndSignUp.Repository.MemberCode;
import com.LoginAndSignUp.Repository.MemberCodeRepository;

@Component
public class NewPwdMemberCodeDAOImpl implements NewPwdMemberCodeDAO{
	
	@Autowired
	MemberCodeRepository memberCodeRepository;
	
	@Override
	@Transactional
	public void updateMemberCodeSalt(MemberCode memberCode) {
		memberCodeRepository.updateSalt(memberCode.getSalt(), memberCode.getUserId());
		
	}

}
