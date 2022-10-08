package com.LoginAndSignUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MemberCodeRepository  extends JpaRepository<MemberCode, Integer>{
	
	
	@Query("select m.salt from MemberCode m where m.userId = :userId")
	String getSalt(@Param("userId")String userId);
	
	@Transactional
	@Modifying
	@Query("update MemberCode m set m.salt = :salt where m.userId= :userId")
	void updatePwd(String salt, String userId);
}
