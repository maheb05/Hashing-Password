package com.hashpassword.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashpassword.Model.Users;

public interface PasswordRepo extends JpaRepository<Users, Long> {
	
	public Optional<Users> findByUsername(String username);
}
