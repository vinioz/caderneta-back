package com.ufpb.dsc.caderneta.dtos;

public class LoginDTO {

	
	
	private String username;
	
	private String password;
	
	private String description;

	private boolean status_error;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus_error() {
		return status_error;
	}

	public void setStatus_error(boolean status_error) {
		this.status_error = status_error;
	}
	
	
	
	public LoginDTO() {
		
	}
	
	public LoginDTO(String username,String description) {
		setUsername(username);
		setDescription(description);
	}
	
	
	public LoginDTO(String username, String description , boolean status) {
		setUsername(username);
		setDescription(description);
		setStatus_error(status);
	}
}
