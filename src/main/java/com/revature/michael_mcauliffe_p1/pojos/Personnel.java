package com.revature.michael_mcauliffe_p1.pojos;

public interface Personnel {

	public Department getDepartment();

	public int getEmployeeID();

	public JobTitle getJobTitle();

	public Integer getReportsTo();

	public void setDepartment(Department department);

	public void setEmployeeID(int employeeID);

	public void setJobTitle(JobTitle jobTitle);

	public void setReportsTo(Integer reportsTo);
}
