package com.revature.michael_mcauliffe_p1.Dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p1.daos.LoginDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.Login;

public class LoginDaoPostgresTest {

	private static LoginDaoPostgres loginDao;

	private static Login login, badLogin, existingLogin;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		loginDao = new LoginDaoPostgres();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		login = new Login("newguy",
				"oHlHodsz5oe5dcyzbPVRFw==SAnFN6QkHp3JSzjgUvARW8TdQVotC7OOVslu2ZWNu9ewm8FQc40xAHenoaGyPf/N+9doTpp4Ouj0oq2Yw/C7CA==",
				9);
		badLogin = new Login("Test", "BadWolf", 0);
		existingLogin = new Login("el_pres",
				"XgNJ6iDaZ0sYGfaHsmmLpg==EqxvBuLfgmaTFX6OiP3JkmGgfo6f5+6MZ5GcD1V3VAdJ4bDv2H7HKVw6E5XVZr3gqtArWlq4HHnQTKq0HD6sIA==",
				1);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void insertLoginTest() {

		assertTrue("Should return true if added.", loginDao.insertLogin(login));
		loginDao.deleteLogin(login.getID());
	}

	@Test
	public void insertExistingLoginByEmployeeIDTest() {

		assertFalse("Should return false if an entry exists.", loginDao.insertLogin(existingLogin));
	}

	@Test
	public void checkForExistingUsernameTest() {

		String username = existingLogin.getUsername();
		assertTrue("Should return true if username exists.", loginDao.checkIfUsernameExists(username));
	}

	@Test
	public void testForNonExistingUsernameTest() {

		String username = "butterball";
		assertFalse("Should return false if username does not exist.", loginDao.checkIfUsernameExists(username));
	}

	@Test
	public void updateExistingLoginTest() {

		loginDao.insertLogin(login);
		login.setPassword("be77er_pa55w0rd?");
		assertTrue("Should return true if updated.", loginDao.updateLogin(login));
		loginDao.deleteLogin(login.getID());
	}

	@Test
	public void updateNonExistingLoginTest() {

		assertFalse("Should return false if no entry exists.", loginDao.updateLogin(badLogin));
	}

	@Test
	public void deleteExistingLoginTest() {

		loginDao.insertLogin(login);
		assertTrue("Should return true if entry was deleted.", loginDao.deleteLogin(login.getID()));
	}

	@Test
	public void deleteNonExistingLoginTest() {

		assertFalse("Should return false if no entry was found.", loginDao.deleteLogin(badLogin.getID()));
	}

	@Test
	public void selectExistingLoginByIDTest() {

		loginDao.insertLogin(login);
		Login selectedLogin = loginDao.selectLoginByID(login.getID());
		loginDao.deleteLogin(login.getID());

		assertEquals("Objects should be equal.", login, selectedLogin);
	}

	@Test
	public void selectNonExistingLoginByIDTest() {

		Login selectedLogin = loginDao.selectLoginByID(badLogin.getID());

		assertEquals("Returned object should be null.", null, selectedLogin);

	}

	@Test
	public void selectExistingLoginByUsernameTest() {

		loginDao.insertLogin(login);
		Login selectedLogin = loginDao.selectLoginByUsername(login.getUsername());
		loginDao.deleteLogin(login.getID());
		assertEquals("Objects should be equal.", login, selectedLogin);
	}

	@Test
	public void selectNonExistingLoginByUsernameTest() {

		Login selectedLogin = loginDao.selectLoginByUsername(badLogin.getUsername());

		assertEquals("Returned object should be null.", null, selectedLogin);

	}

	@Test
	public void selectLoginListTest() {

		List<Login> loginList = new ArrayList<>();

		loginList = loginDao.selectLoginList();

		assertFalse("List should not be empty.", loginList.isEmpty());
	}

}
