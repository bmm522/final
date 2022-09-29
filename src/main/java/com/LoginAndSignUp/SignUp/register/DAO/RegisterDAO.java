package com.LoginAndSignUp.SignUp.register.DAO;

import com.LoginAndSignUp.SignUp.register.entity.MemberCodeDTO;
import com.LoginAndSignUp.SignUp.register.entity.MemberDTO;

public interface RegisterDAO {

	public void registerMember(MemberDTO memberDTO);

	public void registerMemberCode(MemberCodeDTO memberCodeDTO);

}
