package com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.Serivce;

import org.springframework.stereotype.Service;

import com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.DTO.CertificationEmailCodeDTO;
import com.LoginAndSignUp.SignUp.RandomNumber;
import com.LoginAndSignUp.SignUp.email.API.NaverMailAPI;

@Service
public class CertificationEmailCodeServiceImpl  implements CertificationEmailCodeService{

	@Override
	public String sendCode(CertificationEmailCodeDTO certificationEmailCodeDTO) {
		RandomNumber cr = new RandomNumber();
		String randomNumber = cr.makeRandomNumber();
		NaverMailAPI.sendMail("이메일 인증 코드",
																			randomNumber, 
																			certificationEmailCodeDTO.getUserEmail());
		return randomNumber;
	}
	
	
}
