package com.SignUp.register.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SignUp.register.RegisterRepository;
import com.SignUp.register.VO.RegisterVo;

@Service
public class RegisterServiceImpl  implements RegisterService{
	
	@Autowired
	private RegisterRepository registerRepository; 
	
	public void registerMember(RegisterVo registerVo) {
		registerRepository.save(registerVo);
	}
	
}
