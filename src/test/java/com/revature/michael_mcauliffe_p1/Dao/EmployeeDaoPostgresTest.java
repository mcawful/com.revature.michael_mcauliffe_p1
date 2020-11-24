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
import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.Manager;

public class EmployeeDaoPostgresTest {

	private static EmployeeDaoPostgres employeeDao;
	
	private static Employee employee;
	
	private static Manager manager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		employeeDao = new EmployeeDaoPostgres();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		manager = new Manager("Don", "Juan", "5643 Alf Rd", "Savannah", "GA", 54796, "5687576447",
				"don.juan@anotheremail.com", "President", 0);
		
		employee = new Employee("Jane", "Doe", "123 Test St", "Austin", "TX", 10654, "1234567890",
				"jane.doe@email.com", "Foreman");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertEmployeeTest() {
		
		assertTrue("Insert should return non-zero number.", employeeDao.insertEmployee(employee) > 0);
	}
	
	@Test
	public void insertManagerTest() {
		
		assertTrue("Insert should return non-zero number.", employeeDao.insertEmployee(manager) > 0);
	}
	
	@Test
	public void selectExistingEmployeeTest() {
		
		int employeeID = 1;
		
		employee.setEmployeeID(employeeID);
		Employee selectedEmployee = employeeDao.selectEmployee(employeeID);
		
		assertTrue("Objects should be equal.", employee.equals(selectedEmployee));
	}
	
	@Test
	public void selectNonexistantEmployeeTest() {
		
		int employeeID = 0;
		
		Employee selectedEmployee = employeeDao.selectEmployee(employeeID);
		
		assertFalse("Objects should be not be equal.", employee.equals(selectedEmployee));
	}
	
	@Test
	public void updateExistingEmployeeTest() {
		
		employee.setEmployeeID(employeeDao.insertEmployee(employee));
		
		employee.setLastName("Smith");
		
		employeeDao.updateEmployee(employee);
		
		assertEquals("Employee objects should match.", employee, employeeDao.selectEmployee(employee.getEmployeeID()));
	}
	
	@Test
	public void updateNonExistingEmpoyeeTest() {
		
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
		
		employeeDao.insertEmployee(employee);
		empList = employeeDao.selectEmployeeList();
		
		assertFalse("List should not be empty.", empList.isEmpty());
	}
}
