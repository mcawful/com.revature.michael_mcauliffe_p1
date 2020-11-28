package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.RequestApprover;

public class ApprovalDaoPostgres implements ApprovalDao<RequestApprover> {

	@Override
	public int insertApproval(RequestApprover approver) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateApproval(RequestApprover approver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteApproval(RequestApprover approver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RequestApprover selectApproval(String employeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestApprover> selectAllApprovals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestApprover> selectApprovalsByApprover(int employeeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestApprover> selectApprovalsbyReport(String formID) {
		// TODO Auto-generated method stub
		return null;
	}

}
