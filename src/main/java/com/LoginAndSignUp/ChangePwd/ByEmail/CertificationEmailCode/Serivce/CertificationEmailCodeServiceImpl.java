package com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.Serivce;

import com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.DTO.CertificationEmailCodeDTO;
import com.LoginAndSignUp.SignUp.RandomNumber;
import com.LoginAndSignUp.SignUp.email.API.EmailAuthenticationCode;

public class CertificationEmailCodeServiceImpl  implements CertificationEmailCodeService{

	@Override
	public String checkEmailCode(CertificationEmailCodeDTO certificationEmailCodeDTO) {
		RandomNumber cr = new RandomNumber();
		String randomNumber = cr.makeRandomNumber();
		EmailAuthenticationCode.sendMail("이메일 인증 코드",
																			cr.makeRandomNumber(), 
																			certificationEmailCodeDTO.getUserEmail());
	}
	
	
}
