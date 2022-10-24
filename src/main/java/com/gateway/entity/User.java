package com.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName="UserBuilder")
public class User {

	private String username;
	private String nickname;
	private String email;
	private String birth;
	private String phone;
	private String address;
	private String roles;
	private String provider;
	private String providerId;
	private String createDate;
}
