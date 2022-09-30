package com.LoginAndSignUp.SignUp.register.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCodeRepository  extends JpaRepository<MemberCode, Integer>{

}
