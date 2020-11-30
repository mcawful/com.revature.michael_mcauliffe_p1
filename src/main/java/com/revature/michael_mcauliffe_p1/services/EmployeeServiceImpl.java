package com.revature.michael_mcauliffe_p1.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.revature.michael_mcauliffe_p1.daos.EmployeeDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.Employee;

public class EmployeeServiceImpl implements EmployeeService<Employee> {

	EmployeeDaoPostgres employeeDao;

	@Override
	public boolean addEmployee(Employee employee) {

		if (!checkEmployee(employee))
			return false;

		try {
			employeeDao = new EmployeeDaoPostgres();

			if (employeeDao.insertEmployee(employee) > 0)
				// TODO Add logging
				return true;

			// TODO Add logging
			return false;
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateEmployee(Employee employee) {

		if (!checkEmployee(employee))
			return false;

		try {
			employeeDao = new EmployeeDaoPostgres();
			// TODO Add logging
			return employeeDao.updateEmployee(employee);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteEmployee(int employeeID) {

		try {
			employeeDao = new EmployeeDaoPostgres();
			// TODO Add logging
			return employeeDao.deleteEmployee(employeeID);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Employee getEmployee(int employeeID) {

		try {
			employeeDao = new EmployeeDaoPostgres();
			// TODO Add logging
			return employeeDao.selectEmployee(employeeID);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Employee> getEmployeeList() {

		try {
			employeeDao = new EmployeeDaoPostgres();
			// TODO Add logging
			return employeeDao.selectEmployeeList();
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return new ArrayList<Employee>();
		}
		
	}

	private boolean checkEmployee(Employee employee) {

		if (employee.getFirstName().length() > 50 && employee.getLastName().length() > 50
				&& employee.getAddress().length() > 50 && employee.getCity().length() > 50
				&& employee.getState().length() != 2 && employee.getPostalCode().length() != 5
				&& employee.getEmail().length() > 50 && isValidEmail(employee.getEmail())
				&& employee.getPhoneNumber().length() != 10)
			return false;
		return true;
	}

	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
