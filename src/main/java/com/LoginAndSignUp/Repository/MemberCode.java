package com.LoginAndSignUp.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName="MemberCodeBuilder")
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
	
	
}
