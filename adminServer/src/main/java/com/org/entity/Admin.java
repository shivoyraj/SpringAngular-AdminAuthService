package com.org.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String email;
	private String password;
	private LocalDateTime dateTime;
	
	public Admin() {
		super();
	}

	
	
	public Admin(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.dateTime = LocalDateTime.now();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", dateTime=" + dateTime + "]";
	}
	
}
