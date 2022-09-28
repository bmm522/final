package com.LoginAndSignUp.SignUp.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LoginAndSignUp.SignUp.register.entity.MemberCodeDao;

@Repository
public interface MemberCodeRepository  extends JpaRepository<MemberCodeDao, Integer>{

}
