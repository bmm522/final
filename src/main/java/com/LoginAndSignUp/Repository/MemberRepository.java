package com.LoginAndSignUp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

	boolean existsByUserId(String userId);

	@Query("SELECT USERPWD FROM MEMBER FROM WHERE USERID = :userId")
	String getHashCode(@Param("userId")String userId);
	

}
