package com.LoginAndSignUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCodeRepository  extends JpaRepository<MemberCode, Integer>{
	
	
	@Query("SELECT SALT FROM MEMBER_CODE FROM WHERE USERID = :userId")
	String getSalt(@Param("userId")String userId);
}
