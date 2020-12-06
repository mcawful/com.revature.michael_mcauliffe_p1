package com.revature.michael_mcauliffe_p1.services;

import java.util.List;

public interface RequestService<T> {

	public boolean addRequest(T t);
	
	public boolean updateRequest(T t);
	
	public List<T> getRequestsByRequester(int ID);
	
	public List<T> getRequestsByApprover(int ID);
	
}
