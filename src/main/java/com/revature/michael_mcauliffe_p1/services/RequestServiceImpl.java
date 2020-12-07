package com.revature.michael_mcauliffe_p1.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.michael_mcauliffe_p1.daos.RequestDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.Request;

public class RequestServiceImpl implements RequestService<Request> {

	RequestDaoPostgres requestDao;

	@Override
	public boolean addRequest(Request request) {

		try {
			requestDao = new RequestDaoPostgres();
			return requestDao.insertRequest(request);
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRequest(Request request) {
		// TODO Add logging
		return false;
	}

	@Override
	public List<Request> getRequestsByRequester(int employeeID) {
		
		try {
			requestDao = new RequestDaoPostgres();
			return requestDao.selectRequestsByRequester(employeeID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getRequestsByApprover(int employeeID) {
		// TODO Add logging
		return null;
	}

}
