package com.LoginAndSignUp.SignUp.register.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName="MemberBuilder")
public class Member {
	
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
	
}
