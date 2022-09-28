package com.LoginAndSignUp.SignUp.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MemberCodeDao {
	
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
}
