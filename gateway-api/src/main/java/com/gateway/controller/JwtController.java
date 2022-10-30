package com.gateway.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwtsave")
public class JwtController extends HttpHeaders{

	public void jwtSave(@RequestHeader("Authorization") String Authorization) {
		System.out.println(Authorization);
	}
}
