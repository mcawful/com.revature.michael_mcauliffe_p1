package com.revature.michael_mcauliffe_p1.controllers;

import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.Manager;
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
		int postalCode = Integer.parseInt(ctx.formParam("postalCode"));
		String phoneNumber = ctx.formParam("phoneNumer");
		String email = ctx.formParam("email");
		String jobTitle = ctx.formParam("jobTitle");
		int reportsTo = Integer.parseInt(ctx.formParam("reportsTo"));
		int adminLevel = Integer.parseInt(ctx.formParam("adminLevel"));
		
		Employee employee = new Employee(firstName, lastName, address, city, state, postalCode, phoneNumber, email, jobTitle);
		
		if(adminLevel < 0) {
			// TODO: call to service class
		}
		else {
			Manager manager = (Manager) employee;
			manager.setAdminLevel(adminLevel);
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
		int postalCode = Integer.parseInt(ctx.formParam("postalCode"));
		String phoneNumber = ctx.formParam("phoneNumer");
		String email = ctx.formParam("email");
		String jobTitle = ctx.formParam("jobTitle");
		int reportsTo = Integer.parseInt(ctx.formParam("reportsTo"));
		int adminLevel = Integer.parseInt(ctx.formParam("adminLevel"));
		
		Employee employee = new Employee(firstName, lastName, address, city, state, postalCode, phoneNumber, email, jobTitle);
		employee.setEmployeeID(employeeID);
		
		if(adminLevel < 0) {
			// TODO call to service class
		}
		else {
			Manager manager = (Manager) employee;
			manager.setAdminLevel(adminLevel);
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
