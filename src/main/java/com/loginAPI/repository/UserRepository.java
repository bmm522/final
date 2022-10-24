package com.loginAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginAPI.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{


	public User findByUsername(String username);

	public boolean existsByUsername(String username);

}
