package com.revature.michael_mcauliffe_p1.pojos;

public class Login implements Credentials {

	private String username, password;
	private int employeeID;
	
	@Override
	public int getID() {
		
		return this.employeeID;
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
	public void setID(int employeeID) {
		
		this.employeeID = employeeID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (employeeID != other.employeeID)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
