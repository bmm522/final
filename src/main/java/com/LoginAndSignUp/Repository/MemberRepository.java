package com.LoginAndSignUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

	boolean existsByUserId(String userId);

	@Query("select m.userPwd from Member m where m.userId = :userId")
	String getHashCode(@Param("userId")String userId);
	
//	@Query("select m.userId from Member m where m.userName = :userName")
//	String getUserIdByUserName(@Param("userName")String userName);

	@Query("select m.userId from Member m where m.userEmail = :userEmail")
	String getUserIdByUserEmail(@Param("userEmail")String userEmail);
	
//	@Query("select m.userId from Member m where m.userBirth = :userBirth")
//	String getUserIdByUserBirth(@Param("userBirth")String userBirth);

	boolean existsByUserName(String userName);
	
	boolean existsByUserEmail(String userEmail);
	
	boolean existsByUserBirth(String userBirth);
}
