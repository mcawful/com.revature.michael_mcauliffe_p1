package com.revature.michael_mcauliffe_p1.controllers;

import java.util.List;

import io.javalin.http.Context;

public interface EmployeeController<T> {

	public boolean postEmployee(Context ctx);
	
	public boolean updateEmployee(Context ctx);
	
	public boolean deleteEmployee(Context ctx);
	
	public T getEmployee(Context ctx);
	
	public List<T> getAllEmployees();
	
}
