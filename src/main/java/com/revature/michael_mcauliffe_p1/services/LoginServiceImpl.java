package com.revature.michael_mcauliffe_p1.services;

import java.sql.SQLException;

import com.revature.michael_mcauliffe_p1.daos.LoginDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.Login;

public class LoginServiceImpl implements LoginService<Login> {

	LoginDaoPostgres loginDao;

	@Override
	public boolean addLogin(Login login) {

		if (!checkLogin(login))
			return false;
		
		try {
			loginDao = new LoginDaoPostgres();
			// TODO Add logging
			return loginDao.insertLogin(login);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateLogin(Login login) {

		if (!checkLogin(login))
			return false;
		
		try {
			loginDao = new LoginDaoPostgres();
			// TODO Add logging
			return loginDao.updateLogin(login);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteLogin(int employeeID) {

		try {
			loginDao = new LoginDaoPostgres();
			// TODO Add logging
			return loginDao.deleteLogin(employeeID);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Login getLoginByID(int employeeID) {

		try {
			loginDao = new LoginDaoPostgres();
			// TODO Add logging
			return loginDao.selectLoginByID(employeeID);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Login getLoginByUsername(String username) {
		try {
			loginDao = new LoginDaoPostgres();
			// TODO Add logging
			return loginDao.selectLoginByUsername(username);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}

	private boolean checkLogin(Login login) {

		return !(login.getUsername().length() > 50);
	}

}
