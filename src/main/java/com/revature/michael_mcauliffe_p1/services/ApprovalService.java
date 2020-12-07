package com.revature.michael_mcauliffe_p1.services;

public interface ApprovalService<T> {

	public boolean addApproval(T t);

	public boolean getApproval(int ID);

	public boolean updateApproval(T t);
	
	public T getApprovalByRequest(String ID);
}
