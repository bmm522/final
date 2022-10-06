package com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.Service;

import com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.DTO.CertificationEmailCodeDTO;
import com.LoginAndSignUp.ChangePwd.ByEmail.EmailForm.DTO.ChangePwdByEmailFormDTO;

public interface ChangePwdByEmailFormService {
	public String changePwdByEmail(ChangePwdByEmailFormDTO changePwdByEmailFormDTO) ;

	public String sendCode(ChangePwdByEmailFormDTO changePwdByEmailFormDTO);
}
