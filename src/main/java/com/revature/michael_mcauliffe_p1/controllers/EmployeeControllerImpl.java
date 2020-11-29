package com.revature.michael_mcauliffe_p1.controllers;

import java.sql.SQLException;
import java.util.List;

import com.revature.michael_mcauliffe_p1.daos.EmployeeDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.Department;
import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.JobTitle;
import com.revature.michael_mcauliffe_p1.services.EmployeeServiceImpl;

import io.javalin.http.Context;

public class EmployeeControllerImpl implements EmployeeController<Employee> {

	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

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

		Employee employee = new Employee(firstName, lastName, address, city, state, postalCode, phoneNumber, email,
				jobTitle, department, reportsTo, adminLevel);

		if (employeeService.addEmployee(employee))
			return true;

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

		Employee employee = new Employee(firstName, lastName, address, city, state, postalCode, phoneNumber, email,
				jobTitle, department, reportsTo, adminLevel);
		employee.setEmployeeID(employeeID);

		if (employeeService.updateEmployee(employee))
			return true;
		
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
