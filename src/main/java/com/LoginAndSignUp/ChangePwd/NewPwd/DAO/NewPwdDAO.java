package com.LoginAndSignUp.ChangePwd.NewPwd.DAO;

import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberCode;

public interface NewPwdDAO {

	void updateMemberPwd(Member member, MemberCode memberCode);
	
}
