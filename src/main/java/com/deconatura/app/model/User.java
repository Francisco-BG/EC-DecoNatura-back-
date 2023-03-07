package com.deconatura.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId; 
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique=true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String password;
	
	public User() {	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return "id: "+ userId +" nombre: " + name + " password: " + password + " tel: " + phone;
	}
	
}
