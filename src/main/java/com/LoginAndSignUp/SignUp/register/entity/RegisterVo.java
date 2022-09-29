package com.LoginAndSignUp.SignUp.register.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVo {
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	private String userBirth;
	private String userPhone;
	private String userAddress;
	
}
