package com.SignUp.register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SignUp.register.VO.RegisterVo;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterVo, Integer>{

}
