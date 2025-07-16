package com.hashpassword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hashpassword.Model.Users;
import com.hashpassword.service.HashPasswordService;

@RestController
public class passwordController {
	
	@Autowired
	private HashPasswordService passwordService;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody Users user) {
		
		boolean saved = passwordService.saveUser(user.getUsername(), user.getPassword());
		
		return saved ? "Register Successfull" : "Failed To Register. Please try again";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password) {
		
		boolean validUser = passwordService.getUserandValidate(username, password);
		
		return validUser ? "Login Successfull" : "Invalid Credentials";
	}
	
}
