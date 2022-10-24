package com.loginAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginAPI.repository.UserRepository;

@Service
public class UserNameDuplicateCheckServiceImpl implements UserNameDuplicateCheckService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String duplicateCheck(String username) {
		if(userRepository.existsByUsername(username)) {
			return "exists";
		}
		return "available";
	}

}
