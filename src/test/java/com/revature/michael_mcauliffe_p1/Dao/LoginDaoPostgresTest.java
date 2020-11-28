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
import com.revature.michael_mcauliffe_p1.daos.LoginDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.Department;
import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.JobTitle;
import com.revature.michael_mcauliffe_p1.pojos.Login;

public class LoginDaoPostgresTest {

	private static LoginDaoPostgres loginDao;
	
	private static EmployeeDaoPostgres employeeDao;
	
	private static Login login, secondLogin, badLogin;
	
	private static Employee employee, employee2, manager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		employee = new Employee("Test", "Test", null, null, null, null, null, "",
				JobTitle.EMPLOYEE, Department.MARKETING, -1);
		
		manager = new Employee("Test", "Test", null, null, null, null, null, "",
				JobTitle.PRESIDENT, Department.ADMINISTRATION, 1);
		
		employee2 = new Employee("Test", "Test", null, null, null, null, null, "",
				JobTitle.EMPLOYEE, Department.MARKETING, -1);
		
		employeeDao = new EmployeeDaoPostgres();
		loginDao = new LoginDaoPostgres();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		employee.setEmployeeID(employeeDao.insertEmployee(employee));
		manager.setEmployeeID(employeeDao.insertEmployee(manager));
		employee2.setEmployeeID(employeeDao.insertEmployee(employee2));
		
		login = new Login("el_pres", "badpassword", manager.getEmployeeID());
		secondLogin = new Login("beans", "rice", employee.getEmployeeID());
		badLogin = new Login("Test", "BadWolf", 0);

		loginDao.insertLogin(login);
		loginDao.insertLogin(secondLogin);
	}

	@After
	public void tearDown() throws Exception {
		
		loginDao.deleteLogin(login.getID());
		loginDao.deleteLogin(secondLogin.getID());
		employeeDao.deleteEmployee(employee.getEmployeeID());
		employeeDao.deleteEmployee(manager.getEmployeeID());
		employeeDao.deleteEmployee(employee2.getEmployeeID());
	}

	@Test
	public void insertLoginTest() {
		
		Login thirdLogin = new Login("neo", "pants", employee2.getEmployeeID());
		
		assertTrue("Should return true if added.", loginDao.insertLogin(thirdLogin));
		loginDao.deleteLogin(thirdLogin.getID());
	}
	
	@Test
	public void insertExistingLoginByEmployeeIDTest() {

		assertFalse("Should return false if an entry exists.", loginDao.insertLogin(login));
	}

	@Test
	public void checkForExistingUsernameTest() {

		String username = login.getUsername();
		assertTrue("Should return true if username exists.", loginDao.checkIfUsernameExists(username));
	}
	
	@Test
	public void testForNonExistingUsernameTest() {
		
		String username = "butterball";
		assertFalse("Should return false if username does not exist.", loginDao.checkIfUsernameExists(username));
	}
	
	@Test
	public void updateExistingLoginTest() {

		login.setPassword("be77er_pa55w0rd?");
		assertTrue("Should return true if updated.", loginDao.updateLogin(login));
	}

	@Test
	public void updateNonExistingLoginTest() {
		
		assertFalse("Should return false if no entry exists.", loginDao.updateLogin(badLogin));
	}
	
	@Test
	public void deleteExistingLoginTest() {
		
		assertTrue("Should return true if entry was deleted.", loginDao.deleteLogin(secondLogin.getID()));
	}
	
	@Test
	public void deleteNonExistingLoginTest() {
		
		assertFalse("Should return false if no entry was found.", loginDao.deleteLogin(badLogin.getID()));
	}
	
	@Test
	public void selectExistingLoginTest() {
		
		Login selectedLogin = loginDao.selectLogin(login.getID());
		
		assertTrue("Objects should be equal.", login.equals(selectedLogin));
	}
	
	@Test
	public void selectNonExistingLoginTest() {
		
		Login selectedLogin = loginDao.selectLogin(badLogin.getID());
		
		assertEquals("Returned object should be null.", null, selectedLogin);

	}
	
	@Test
	public void selectLoginListTest() {
		
		List<Login> loginList = new ArrayList<>();
		
		loginDao.insertLogin(login);
		loginList = loginDao.selectLoginList();
		
		assertFalse("List should not be empty.", loginList.isEmpty());
	}
	
}
