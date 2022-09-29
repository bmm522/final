package com.LoginAndSignUp.SignUp.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="USERID")
	private String userId;
	@Column(name="USERPWD")
	private String userPwd;
	@Column(name="USERNAME")
	private String userName;
	@Column(name="USEREMAIL")
	private String userEmail;
	@Column(name="USERBIRTH")
	private String userBirth;
	@Column(name="USERPHONE")
	private String userPhone;
	@Column(name="USERADDRESS")
	private String userAddress;
	
	public MemberDTO(String userId, String userPwd, String userName, String userEmail, String userBirth,
			String userPhone, String userAddress) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}
	
	
	
}
