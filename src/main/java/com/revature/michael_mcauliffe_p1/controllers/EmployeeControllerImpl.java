package com.revature.michael_mcauliffe_p1.controllers;

import java.util.ArrayList;
import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.Department;
import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.JobTitle;
import com.revature.michael_mcauliffe_p1.services.EmployeeServiceImpl;

import io.javalin.http.Context;

public class EmployeeControllerImpl implements EmployeeController<Employee> {

	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	@Override
	public boolean postEmployee(Context ctx) {

		try {
			Employee employee = makeEmployee(ctx);
			if (employeeService.addEmployee(employee))
				return true;
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

		return false;

	}

	@Override
	public boolean updateEmployee(Context ctx) {

		try {
			Employee employee = makeEmployee(ctx);
			if (employeeService.updateEmployee(employee))
				return true;
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

		return false;
	}

	@Override
	public boolean deleteEmployee(Context ctx) {

		try {
			int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
			if (employeeService.deleteEmployee(employeeID))
				return true;
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

		return false;
	}

	@Override
	public Employee getEmployee(Context ctx) {

		try {
			int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
			return employeeService.getEmployee(employeeID);
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Employee> getAllEmployees() {

		try {
			return employeeService.getEmployeeList();

		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			return new ArrayList<Employee>();
		}
	}

	private Employee makeEmployee(Context ctx) {

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

		return employee;
	}

}
