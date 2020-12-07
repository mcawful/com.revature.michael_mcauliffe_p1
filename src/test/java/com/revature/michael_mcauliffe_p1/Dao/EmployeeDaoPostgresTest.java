package com.revature.michael_mcauliffe_p1.Dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p1.daos.EmployeeDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.Department;
import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.JobTitle;

public class EmployeeDaoPostgresTest {

	private static EmployeeDaoPostgres employeeDao;

	private static Employee employee;

	private static Employee manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		employeeDao = new EmployeeDaoPostgres();
		manager = new Employee("Don", "Juan", "5643 Alf Rd", "Savannah", "GA", "54796", "5687576447",
				"don.juan@anotheremail.com", JobTitle.PRESIDENT, Department.ADMINISTRATION, 0);

		employee = new Employee("Jane", "Doe", "123 Test St", "Austin", "TX", "10654", "1234567890",
				"jane.doe@email.com", JobTitle.EMPLOYEE, Department.SALES, -1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertEmployeeTest() {

		int employeeID = employeeDao.insertEmployee(employee);
		employee.setEmployeeID(employeeID);
		assertTrue("Insert should return non-zero number.", employeeID > 0);
		employeeDao.deleteEmployee(employee.getEmployeeID());
	}

	@Test
	public void insertManagerTest() {
		int employeeID = employeeDao.insertEmployee(manager);
		manager.setEmployeeID(employeeID);
		assertTrue("Insert should return non-zero number.", employeeID > 0);
		employeeDao.deleteEmployee(manager.getEmployeeID());
	}

	/*@Test
	public void selectExistingEmployeeTest() {

		int employeeID = employeeDao.insertEmployee(employee);

		employee.setEmployeeID(employeeID);
		Employee selectedEmployee = employeeDao.selectEmployee(employeeID);

		assertTrue("Objects should be equal.", employee.equals(selectedEmployee));
		employeeDao.deleteEmployee(employee.getEmployeeID());
	}*/

	@Test
	public void selectNonexistantEmployeeTest() {

		int employeeID = 0;

		Employee selectedEmployee = employeeDao.selectEmployee(employeeID);

		assertFalse("Objects should be not be equal.", employee.equals(selectedEmployee));
	}

	/*@Test
	public void updateExistingEmployeeTest() {

		employee.setEmployeeID(employeeDao.insertEmployee(employee));

		employee.setLastName("Smith");

		employeeDao.updateEmployee(employee);

		assertEquals("Employee objects should match.", employee, employeeDao.selectEmployee(employee.getEmployeeID()));
		employeeDao.deleteEmployee(employee.getEmployeeID());
	}*/

	@Test
	public void updateNonExistingEmployeeTest() {

		assertFalse("No update should occur.", employeeDao.updateEmployee(employee));
	}

	@Test
	public void deleteExistingEmployeeTest() {

		int employeeID = employeeDao.insertEmployee(employee);

		assertTrue("Should return true if entry was deleted.", employeeDao.deleteEmployee(employeeID));
	}

	@Test
	public void deleteNonExistantEmployeeTest() {

		int employeeID = 0;

		assertFalse("Should return false if entry wasn't found.", employeeDao.deleteEmployee(employeeID));
	}

	@Test
	public void selectAllEmployeesTest() {

		List<Employee> empList = new ArrayList<>();

		employee.setEmployeeID(employeeDao.insertEmployee(employee));
		empList = employeeDao.selectEmployeeList();

		assertFalse("List should not be empty.", empList.isEmpty());
		employeeDao.deleteEmployee(employee.getEmployeeID());
	}
}
