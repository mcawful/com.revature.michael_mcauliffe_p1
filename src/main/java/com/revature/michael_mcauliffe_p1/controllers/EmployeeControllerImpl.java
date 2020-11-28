package com.revature.michael_mcauliffe_p1.controllers;

import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.Department;
import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.JobTitle;
import com.revature.michael_mcauliffe_p1.services.EmployeeService;

import io.javalin.http.Context;

public class EmployeeControllerImpl implements EmployeeController<Employee> {
	
	@Override
	public boolean postEmployee(Context ctx) {

		String firstName = ctx.formParam("firstName");
		String lastName = ctx.formParam("lastName");
		String address = ctx.formParam("address");
		String city = ctx.formParam("city");
		String state = ctx.formParam("state");
		String postalCode = ctx.formParam("postalCode");
		String phoneNumber = ctx.formParam("phoneNumer");
		String email = ctx.formParam("email");
		JobTitle jobTitle = JobTitle.valueOf(ctx.formParam("jobTitle"));
		Department department = Department.valueOf(ctx.formParam("department"));
		int reportsTo = Integer.parseInt(ctx.formParam("reportsTo"));
		int adminLevel = Integer.parseInt(ctx.formParam("adminLevel"));
		
		Employee employee = new Employee(firstName, lastName, address, city, state, postalCode, phoneNumber, email, jobTitle, department, reportsTo);
		
		if(adminLevel < 0) {
			
			// TODO: call to service class
		}
		else {

			// TODO: call to service class
		}
		
		return false;
	}

	@Override
	public boolean updateEmployee(Context ctx) {

		int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
		String firstName = ctx.formParam("firstName");
		String lastName = ctx.formParam("lastName");
		String address = ctx.formParam("address");
		String city = ctx.formParam("city");
		String state = ctx.formParam("state");
		String postalCode = ctx.formParam("postalCode");
		String phoneNumber = ctx.formParam("phoneNumer");
		String email = ctx.formParam("email");
		JobTitle jobTitle = JobTitle.valueOf(ctx.formParam("jobTitle"));
		Department department = Department.valueOf(ctx.formParam("department"));
		int reportsTo = Integer.parseInt(ctx.formParam("reportsTo"));
		int adminLevel = Integer.parseInt(ctx.formParam("adminLevel"));
		
		Employee employee = new Employee(firstName, lastName, address, city, state, postalCode, phoneNumber, email, jobTitle, department, reportsTo);
		employee.setEmployeeID(employeeID);
		
		if(adminLevel < 0) {
			// TODO call to service class
		}
		else {

			// TODO call to service class
		}
		
		return false;
	}

	@Override
	public boolean deleteEmployee(Context ctx) {

		int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
		
		// TODO call to service class
		return false;
	}

	@Override
	public Employee getEmployee(Context ctx) {

		int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
		
		// TODO call to service class
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		// TODO call to service class
		return null;
	}

}
