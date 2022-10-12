package com.LoginAndSignUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

	boolean existsByUserId(String userId);

	@Query("select m.userPwd from Member m where m.userId = :userId")
	String getHashCode(@Param("userId")String userId);

	@Query("select m.userId from Member m where m.userEmail = :userEmail")
	String getUserIdByUserEmail(@Param("userEmail")String userEmail);

	boolean existsByUserName(String userName);
	
	boolean existsByUserEmail(String userEmail);
	
	boolean existsByUserBirth(String userBirth);
	
	@Modifying
	@Query("UPDATE Member m SET m.userPwd = :userPwd WHERE m.userId = :userId")
	void updatePwd(String userPwd, String userId);


}
