package com.revature.michael_mcauliffe_p1.pojos;

public class Employee extends Person implements Personnel, Administrator {
	
	public static final double MAX_EXPENSE = 1000.00;

	private JobTitle jobTitle;
	private Department department;
	private Integer reportsTo;
	private boolean isBenCo;
	
	private int employeeID, adminLevel;
	
	public Employee() {
		
		super("", "", "", "", "", "", "", "");
		this.employeeID = 0;
		this.jobTitle = null;
		this.department = null;
		this.reportsTo = null;
		this.isBenCo = false;
		this.adminLevel = -1;
	}

	public Employee(String firstName, String lastName, String address, String city, String state, String postalCode,
			String phoneNumber, String email, JobTitle jobTitle, Department department, int adminLevel) {
		
		super(firstName, lastName, address, city, state, postalCode, phoneNumber, email);
		this.employeeID = 0;
		this.jobTitle = jobTitle;
		this.department = department;
		this.reportsTo = null;
		this.isBenCo = false;
		this.adminLevel = adminLevel;
	}
	
	public Employee(String firstName, String lastName, String address, String city, String state, String postalCode,
			String phoneNumber, String email, JobTitle jobTitle, Department department, Integer reportsTo, int adminLevel) {
		
		super(firstName, lastName, address, city, state, postalCode, phoneNumber, email);
		this.employeeID = 0;
		this.jobTitle = jobTitle;
		this.department = department;
		this.reportsTo = reportsTo;
		this.isBenCo = false;
		this.adminLevel = adminLevel;
	}
	
	@Override
	public int getAdminLevel() {
		
		return this.adminLevel;
	}

	@Override
	public Department getDepartment() {
		
		return this.department;
	}

	@Override
	public int getEmployeeID() {
		
		return this.employeeID;
	}
	
	@Override
	public JobTitle getJobTitle() {
		
		return this.jobTitle;
	}

	public Double getMaxExpense() {
		
		return MAX_EXPENSE;
	}

	@Override
	public Integer getReportsTo() {
		
		return reportsTo;
	}

	public boolean isBenCo() {
		
		return this.isBenCo;
	}

	@Override
	public void setAdminLevel(int adminLevel) {
		
		this.adminLevel = adminLevel;
	}

	public void setBenCo(boolean isBenCo) {
		
		this.isBenCo = isBenCo;
	}
	
	@Override
	public void setDepartment(Department department) {
		
		this.department = department;
	}
	
	@Override
	public void setEmployeeID(int employeeID) {
		
		this.employeeID = employeeID;
	}

	@Override
	public void setJobTitle(JobTitle jobTitle) {
		
		this.jobTitle = jobTitle;
	}

	@Override
	public void setReportsTo(Integer reportsTo) {
		
		this.reportsTo = reportsTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + adminLevel;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + employeeID;
		result = prime * result + (isBenCo ? 1231 : 1237);
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
		if (adminLevel != other.adminLevel)
			return false;
		if (department != other.department)
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (isBenCo != other.isBenCo)
			return false;
		if (jobTitle != other.jobTitle)
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
		return "Employee [jobTitle=" + jobTitle + ", department=" + department + ", reportsTo=" + reportsTo
				+ ", isBenCo=" + isBenCo + ", employeeID=" + employeeID + ", adminLevel=" + adminLevel
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getEmail()=" + getEmail() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getAddress()=" + getAddress()
				+ ", getCity()=" + getCity() + ", getState()=" + getState() + ", getPostalCode()=" + getPostalCode()
				+ "]";
	}
	
}
