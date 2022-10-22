package com.loginAPI.config.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loginAPI.config.auth.PrincipalDetails;
import com.loginAPI.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class loginAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("loginAuthenticationFilter 로그인시도중");	
	
		try {
			ObjectMapper om = new ObjectMapper();
			User user = om.readValue(request.getInputStream(), User.class);
			System.out.println(user);
			System.out.println("1");
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			UsernamePasswordAuthenticationToken authenticationToken = 
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
			System.out.println("2");
			Authentication authentication =
					authenticationManager.authenticate(authenticationToken);
			System.out.println("3");
			PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
			System.out.println("4");
			System.out.println(principalDetails.getUser().getUsername());
			System.out.println("로그인 성공 세션에저장완료");
			return authentication;
		} catch (IOException e) {
			e.printStackTrace();
		}
//		try {
//			
//			System.out.println(user);
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		
		
		return null;
	}
}
