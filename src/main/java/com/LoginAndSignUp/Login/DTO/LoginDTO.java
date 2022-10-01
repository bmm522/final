package com.LoginAndSignUp.Login.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	private String userId;
	private String userPwd;
	private boolean loginResult;
}
