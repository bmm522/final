package com.LoginAndSignUp.ChangePwd.ByEmail.CertificationEmailCode.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificationEmailCodeDTO {
	private String userEmail;
	private String certificationEmailCode;
	private String checkCertificationEmailCode;
}
