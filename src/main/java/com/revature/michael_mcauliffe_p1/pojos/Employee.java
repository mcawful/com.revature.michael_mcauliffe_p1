package com.revature.michael_mcauliffe_p1.pojos;

public class Employee extends Person implements Personnel {
	
	private String jobTitle;

	private Integer reportsTo;
	private int employeeID = 0;
	
	public static final double MAX_EXPENSE = 1000.00;
	
	public Employee() {
		
		super("", "", "", "", "", -1, "", "");
		this.jobTitle = "";
		this.reportsTo = null;
	}

	public Employee(String firstName, String lastName, String address, String city, String state, int postalCode,
			String phoneNumber, String email, String jobTitle) {
		
		super(firstName, lastName, address, city, state, postalCode, phoneNumber, email);
		this.jobTitle = jobTitle;
		this.reportsTo = null;
	}
	
	public Employee(String firstName, String lastName, String address, String city, String state, int postalCode,
			String phoneNumber, String email, String jobTitle, Integer reportsTo) {
		
		super(firstName, lastName, address, city, state, postalCode, phoneNumber, email);
		this.jobTitle = jobTitle;
		this.reportsTo = reportsTo;
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
	public Integer getReportsTo() {
		
		return reportsTo;
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
	public void setReportsTo(Integer reportsTo) {
		
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
		result = prime * result + ((reportsTo == null) ? 0 : reportsTo.hashCode());
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
		if (reportsTo == null) {
			if (other.reportsTo != null)
				return false;
		} else if (!reportsTo.equals(other.reportsTo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [jobTitle=" + jobTitle + ", reportsTo=" + reportsTo + ", employeeID=" + employeeID
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getEmail()=" + getEmail() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getAddress()=" + getAddress()
				+ ", getCity()=" + getCity() + ", getState()=" + getState() + ", getPostalCode()=" + getPostalCode()
				+ "]";
	}

}
