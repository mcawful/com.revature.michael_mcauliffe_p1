package com.revature.michael_mcauliffe_p1.pojos;

public final class Manager extends Employee implements Administrator {

	private int adminLevel;
	
	public Manager() {
		
		super("", "", "", "", "", -1, "", "", "", 0);
		this.adminLevel = -1;
	}

	public Manager(String firstName, String lastName, String address, String city, String state, int postalCode,
			String phoneNumber, String email, String jobTitle, int reportsTo, int adminLevel) {
		
		super(firstName, lastName, address, city, state, postalCode, phoneNumber, email, jobTitle, reportsTo);
		this.adminLevel = adminLevel;
	}

	@Override
	public void setAdminLevel(int adminLevel) {
		
		this.adminLevel = adminLevel;
	}

	@Override
	public int getAdminLevel() {
		
		return this.adminLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + adminLevel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (adminLevel != other.adminLevel)
			return false;
		return true;
	}

}
