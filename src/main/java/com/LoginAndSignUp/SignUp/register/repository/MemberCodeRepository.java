package com.LoginAndSignUp.SignUp.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCodeRepository  extends JpaRepository<MemberCodeEntity, Integer>{

}
