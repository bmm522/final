package com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.Serivce;

import com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.DTO.CertificationEmailCodeDTO;

public interface CertificationEmailCodeService {

	String sendCode(CertificationEmailCodeDTO certificationEmailCodeDTO);
	
}
