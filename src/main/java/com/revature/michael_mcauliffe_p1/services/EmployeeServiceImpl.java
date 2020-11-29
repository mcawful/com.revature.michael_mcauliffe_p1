package com.revature.michael_mcauliffe_p1.services;

import java.sql.SQLException;
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

			employeeDao.insertEmployee(employee);
			return true;
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

			return employeeDao.updateEmployee(employee);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteEmployee(int employeeID) {

		return employeeDao.deleteEmployee(employeeID);
	}

	@Override
	public Employee getEmployee(int employeeID) {
		
		return employeeDao.selectEmployee(employeeID);
	}

	@Override
	public List<Employee> getEmployeeList() {
		
		return employeeDao.selectEmployeeList();
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
