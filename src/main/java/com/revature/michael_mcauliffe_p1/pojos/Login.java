package com.revature.michael_mcauliffe_p1.pojos;

public class Login implements Credentials {

	private String username, password;
	private int loginID;
	
	@Override
	public int getID() {
		
		return this.loginID;
	}

	@Override
	public String getUsername() {
		
		return this.username;
	}

	@Override
	public String getPassword() {
		
		return this.password;
	}

	@Override
	public void setID(int loginID) {
		
		this.loginID = loginID;
	}

	@Override
	public void setUsername(String username) {
		
		this.username = username;
	}

	// Using this method to store passwords in plain text is NOT recommended
	// Strongly suggest using up to date hashing algorithms for password storage
	@Override
	public void setPassword(String password) {
		
		this.password = password;
	}

}
