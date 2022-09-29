package com.LoginAndSignUp.SignUp.register.repository;

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
public class MemberCode {
	
	@Column(name="USERID")
	private String userId;
	@Column(name="SALT")
	private String salt;
	@Column(name="USEREMAIL")
	private String userEmail;
	@Column(name="USERPHONE")
	private String userPhone;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public MemberCode(String userId, String salt, String userEmail, String userPhone) {
		this.userId = userId;
		this.salt = salt;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}
	
	
}
