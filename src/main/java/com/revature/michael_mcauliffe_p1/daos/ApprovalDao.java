package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

public interface ApprovalDao<T> {

	public int insertApproval(T t);

	public boolean updateApproval(T t);

	public boolean deleteApproval(int ID);

	public T selectApproval(int ID);

	public List<T> selectAllApprovals();

	public List<T> selectApprovalsByFirstApprover(int ID);

	public List<T> selectApprovalsBySecondApprover(int ID);

	public List<T> selectApprovalsByFinalApprover(int ID);

	public T selectApprovalByRequest(String ID);

}
