package com.zu.entity;

public class User {
	
	private int id;
	private String userName;
	private String email; 
	private String password;
	private String rePassword;
	private int isAdmin = 0;
	
	
	


	public User () {
			
	}
	
	
	public User(int idP, String usernameP, String emailP, String passwordP, String rePasswordP) {
		this.id = idP;
		this.userName = usernameP;
		this.email = emailP;
		this.password = passwordP;
		this.rePassword = rePasswordP;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
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
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
