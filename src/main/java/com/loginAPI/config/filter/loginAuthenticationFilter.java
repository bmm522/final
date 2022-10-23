package com.loginAPI.config.filter;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loginAPI.config.auth.PrincipalDetails;
import com.loginAPI.config.auth.ServerAuthCode;
import com.loginAPI.model.User;
import com.loginAPI.properties.JwtProperties;
import com.loginAPI.properties.LoginStatusProperties;

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
			System.out.println(1);
			UsernamePasswordAuthenticationToken authenticationToken = 
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
			System.out.println(2);
			
			Authentication authentication = null;
			try {
				authentication = authenticationManager.authenticate(authenticationToken);
			} catch(Exception e) {
				response.addHeader(LoginStatusProperties.STATUS, "Not found userId or userPassword");
				logger.error("Not found userId or userPassword");
				return authentication;
			}
					
					
			System.out.println(3);
			PrincipalDetails principalDetails = null;
			try {
				principalDetails = (PrincipalDetails) authentication.getPrincipal();
			} catch(Exception e) {
				response.addHeader(LoginStatusProperties.STATUS, "Fail Login");
				logger.error("Fail Login");
				return authentication;
			}
			System.out.println(4);
			return authentication;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();
		String serverAuthCode = new ServerAuthCode().actionOfMakeServerAuthCode();
		String createDate = getCreateDate(principalDetails.getUser().getCreateDate());
		String jwtToken = JWT.create()
				.withSubject(principalDetails.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRATION_TIME))
				.withClaim("id", principalDetails.getUser().getId())
				.withClaim("username",principalDetails.getUser().getUsername())
				.withClaim("nickname",principalDetails.getUser().getNickname())
				.withClaim("email",principalDetails.getUser().getEmail())
				.withClaim("birth",principalDetails.getUser().getBirth())
				.withClaim("phone",principalDetails.getUser().getPhone())
				.withClaim("address",principalDetails.getUser().getAddress())
				.withClaim("roles",principalDetails.getUser().getRoles())
				.withClaim("provider",principalDetails.getUser().getProvider())
				.withClaim("providerId",principalDetails.getUser().getProviderId())
				.withClaim("createDate",createDate)
				.sign(Algorithm.HMAC512(JwtProperties.SECRET+serverAuthCode));
		
		response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX+jwtToken);
		response.addHeader("Server_Authorization : ", "Server_Authorization "+serverAuthCode);
 
	}

	private String getCreateDate(Timestamp createDate) {
		  java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(createDate);
	}
	
	
}
