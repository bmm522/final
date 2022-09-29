package com.LoginAndSignUp.SignUp.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LoginAndSignUp.SignUp.register.entity.MemberCodeDTO;
import com.LoginAndSignUp.SignUp.register.entity.MemberDTO;

@Repository
public interface MemberRepository extends JpaRepository<MemberDTO, Integer>{

	

}
