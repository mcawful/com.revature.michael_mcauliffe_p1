package com.revature.michael_mcauliffe_p1.services;

import java.util.List;

public interface EmployeeService<T> {

	public boolean addEmployee(T t);
	
	public boolean updateEmployee(T t, int ID);
	
	public boolean deleteEmployee(int ID);
	
	public T getEmployee(int ID);
	
	public List<T> getEmployeeList();
	
}
