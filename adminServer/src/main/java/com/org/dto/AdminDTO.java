package com.org.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class AdminDTO {

	@Size (min = 8, message ="{USERNAME_FORMAT_INVALID}")
	private String userName;

	@Email (message = "{EMAIL_FORMAT_INVALID}")
	@NotEmpty(message = "{EMAIL_NULL}")
	private String email;

	@Size(min = 8,message = "{PASSWORD_FORMAT_INVALID}")
	private String password;

	public AdminDTO() {
		super();
	}

	public AdminDTO(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "AdminDTO [userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}

}
