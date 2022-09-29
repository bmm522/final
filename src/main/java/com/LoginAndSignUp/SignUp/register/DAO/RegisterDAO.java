package com.LoginAndSignUp.SignUp.register.DAO;

import com.LoginAndSignUp.SignUp.register.repository.MemberCodeEntity;
import com.LoginAndSignUp.SignUp.register.repository.MemberEntity;

public interface RegisterDAO {

	public void registerMember(MemberEntity memberDTO);

	public void registerMemberCode(MemberCodeEntity memberCodeDTO);

}
