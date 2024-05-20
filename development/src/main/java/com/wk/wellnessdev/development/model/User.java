package com.wk.wellnessdev.development.model;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String name;
	//@Range(min=1000000000L,max=9999999999L,message="phoneNumber must be 10 digit number")
	private String phoneNumber;
	private String role;
	private String email;
	private String username;
	private String password;

	public User() {

	}
	
	public User(String name, String phoneNumber, String role, String email, String username,String password) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	
	
	public Long getId() {
		return userId;
	}

	public void setId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}