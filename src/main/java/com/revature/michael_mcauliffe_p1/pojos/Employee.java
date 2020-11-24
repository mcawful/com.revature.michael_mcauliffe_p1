package com.revature.michael_mcauliffe_p1.pojos;

public class Employee extends Person implements Personnel {
	
	private String jobTitle;

	private int reportsTo, loginID;
	private int employeeID = 0;
	
	public static final double MAX_EXPENSE = 1000.00;
	
	public Employee() {
		
		super("", "", "", "", "", -1, "", "");
		this.jobTitle = "";
		this.reportsTo = 0;
		this.loginID = -1;
	}

	public Employee(String firstName, String lastName, String address, String city, String state, int postalCode,
			String phoneNumber, String email, String jobTitle, int reportsTo) {
		
		super(firstName, lastName, address, city, state, postalCode, phoneNumber, email);
		this.jobTitle = jobTitle;
		this.reportsTo = reportsTo;
		this.loginID = -1;
	}

	public int getLoginID () {
		
		return this.loginID;
	}
	
	@Override
	public int getEmployeeID() {
		
		return this.employeeID;
	}

	@Override
	public String getJobTitle() {
		
		return this.jobTitle;
	}

	@Override
	public int getReportsTo() {
		
		return reportsTo;
	}

	public void setLoginID(int loginID) {
		
		this.loginID = loginID;
	}
	
	@Override
	public void setEmployeeID(int employeeID) {
		
		this.employeeID = employeeID;
	}

	@Override
	public void setJobTitle(String jobTitle) {
		
		this.jobTitle = jobTitle;
	}

	@Override
	public void setReportsTo(int reportsTo) {
		
		this.reportsTo = reportsTo;
	}

	public Double getMaxExpense() {
		
		return MAX_EXPENSE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + employeeID;
		result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime * result + loginID;
		result = prime * result + reportsTo;
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
		Employee other = (Employee) obj;
		if (employeeID != other.employeeID)
			return false;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (loginID != other.loginID)
			return false;
		if (reportsTo != other.reportsTo)
			return false;
		return true;
	}

}
