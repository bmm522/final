package com.loginAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginAPI.model.User;
import com.loginAPI.repository.UserRepository;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void join(User user) {
		user.setRoles("ROLE_USER");
		user.setProvider("LOCAL");
		user.setProviderId("NULL");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}
	
	
}