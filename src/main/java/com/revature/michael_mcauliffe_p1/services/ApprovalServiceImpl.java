package com.revature.michael_mcauliffe_p1.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.michael_mcauliffe_p1.daos.ApprovalDaoPostgres;
import com.revature.michael_mcauliffe_p1.daos.EmployeeDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.JobTitle;
import com.revature.michael_mcauliffe_p1.pojos.Request;
import com.revature.michael_mcauliffe_p1.pojos.RequestApproval;

public class ApprovalServiceImpl implements ApprovalService<RequestApproval> {

	ApprovalDaoPostgres approvalDao;
	

	public RequestApproval makeApproval(Request request, Employee employee) {

		Employee approver1, approver2, benCo = null;
		List<Employee> benCoList;
		
		EmployeeDaoPostgres employeeDao;
		
		try {
			employeeDao = new EmployeeDaoPostgres();
			approver1 = employeeDao.selectEmployee(employee.getReportsTo());
			approver2 = employeeDao.selectEmployee(approver1.getReportsTo());
			benCoList = employeeDao.selectBenCoList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

		if (employee.getJobTitle() == JobTitle.SUPERVISOR || employee.getJobTitle() == JobTitle.DEPARTMENT_HEAD) {

			approver2 = approver1;
		}

		for (Employee tempEmployee : benCoList) {

			if (tempEmployee.getDepartment() == employee.getDepartment() && !employee.isBenCo()) {

				benCo = tempEmployee;
				break;
			} else
				benCo = tempEmployee;
		}
		
		// sets approval to the employee if the employee is the highest possible
		// in the hierarchy
		if(employee.getReportsTo() == null) {
			approver1 = employee;
			approver2 = employee;
			benCo = employee;
		}

		RequestApproval approval = new RequestApproval(approver1.getEmployeeID(), approver2.getEmployeeID(),
				benCo.getEmployeeID(), request.getFormID());

		return approval;
	}

	@Override
	public boolean addApproval(RequestApproval approval) {
		try {
			approvalDao = new ApprovalDaoPostgres();
			approvalDao.insertApproval(approval);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean getApproval(int approvalID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateApproval(RequestApproval approval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RequestApproval getApprovalByRequest(String formID) {
		// TODO Auto-generated method stub
		return null;
	}

}
