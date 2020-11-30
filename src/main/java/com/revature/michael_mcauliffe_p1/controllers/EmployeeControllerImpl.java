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
			if (employeeService.addEmployee(employee)) {
				ctx.html("Employee added successfully");
				ctx.status(201);
				return true;
			}
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
			return false;
		}

		ctx.html("Could not add employee");
		ctx.status(400);
		return false;

	}

	@Override
	public boolean updateEmployee(Context ctx) {

		try {
			Employee employee = makeEmployee(ctx);
			if (employeeService.updateEmployee(employee)) {
				ctx.html("Employee updated successfully");
				ctx.status(200);
				return true;
			}
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
			return false;
		}
		ctx.html("Could not update employee");
		ctx.status(400);
		return false;
	}

	@Override
	public boolean deleteEmployee(Context ctx) {

		try {
			int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
			if (employeeService.deleteEmployee(employeeID)) {
				ctx.html("Employee deleted successfully");
				ctx.status(200);
				return true;
			}
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
			return false;
		}

		ctx.html("Could not find selected employee to delete");
		ctx.status(400);
		return false;
	}

	@Override
	public Employee getEmployee(Context ctx) {

		try {
			int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
			Employee employee = employeeService.getEmployee(employeeID);
			if(employee != null) {
				ctx.html("Selected Employee:\n"
						+ "Employee ID: " + employee.getEmployeeID() + "\n"
						+ "Name: " + employee.getFirstName() + " " + employee.getLastName() + "\n"
						+ "Job Title: " + employee.getJobTitle().toString());
				return employee;
			}
			ctx.html("Employee not found");
			ctx.status(400);
			return null;
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
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
