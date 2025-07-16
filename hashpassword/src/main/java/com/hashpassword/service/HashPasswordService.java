package com.hashpassword.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hashpassword.Model.Users;
import com.hashpassword.repo.PasswordRepo;

@Service
public class HashPasswordService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private PasswordRepo passwordRepo;
	
	public boolean saveUser(String username, String password) {
		
		String hashedPasswrod = encoder.encode(password);
		Users user = new Users(username, hashedPasswrod, LocalDateTime.now());
		
		Users savedUser = passwordRepo.save(user);
		
		return savedUser != null && savedUser.getId() != null;
	}
	
	public boolean getUserandValidate(String username, String password) {
		
		Optional<Users> byUsername = passwordRepo.findByUsername(username);
		
		if(byUsername.isPresent()) {
			Users user = byUsername.get();
			return encoder.matches(password, user.getPassword());
		}
		return false;
	}
	
}
