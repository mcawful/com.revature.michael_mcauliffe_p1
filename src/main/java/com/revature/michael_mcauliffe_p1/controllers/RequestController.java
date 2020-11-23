package com.revature.michael_mcauliffe_p1.controllers;

import java.util.List;

import io.javalin.http.Context;

public interface RequestController<T> {

	public boolean postRequest(Context ctx);
	
	public boolean updateRequest(Context ctx);
	
	public boolean deleteRequest(Context ctx);
	
	public T getRequest(Context ctx);
	
	public List<T> getAllRequest();
	
	public List<T> getRequestsBySearch(Context ctx);
	
}
