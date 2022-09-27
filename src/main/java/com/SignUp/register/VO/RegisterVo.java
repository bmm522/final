package com.SignUp.register.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterVo {
	private Integer id;
	private String userId;
	private String userPwd;
	private String salt;
	private String hashCode;
	private String userName;
	private String userEmail;
	private String userBirth;
	private String userPhone;
	private String userAdress;
	
}
