package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

public interface ApprovalDao<T> {

	public int insertApproval(T t);
	
	public boolean updateApproval(T t);
	
	public boolean deleteApproval(T t);
	
	public T selectApproval(String ID);
	
	public List<T> selectAllApprovals();
	
	public List<T> selectApprovalsByApprover(int ID);
	
	public List<T> selectApprovalsbyReport(String ID);
	
}
