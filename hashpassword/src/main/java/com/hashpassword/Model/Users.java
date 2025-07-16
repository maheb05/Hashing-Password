package com.hashpassword.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private LocalDateTime registeredTimeAndDate;

    // Constructors
    public Users() {}

    public Users(String username, String password, LocalDateTime registeredTimeAndDate) {
        this.username = username;
        this.password = password;
        this.registeredTimeAndDate = registeredTimeAndDate;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getRegisteredTimeAndDate() {
		return registeredTimeAndDate;
	}

	public void setRegisteredTimeAndDate(LocalDateTime registeredTimeAndDate) {
		this.registeredTimeAndDate = registeredTimeAndDate;
	}
}
