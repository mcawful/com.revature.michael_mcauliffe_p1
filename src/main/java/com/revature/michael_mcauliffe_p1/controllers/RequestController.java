package com.revature.michael_mcauliffe_p1.controllers;

import io.javalin.http.Context;

public interface RequestController<T> {

	public boolean postRequest(Context ctx);
	
	public boolean updateRequest(Context ctx);
	
	public boolean deleteRequest(Context ctx);
	
	public boolean getRequest(Context ctx);
	
	public boolean getAllRequests();
	
	public boolean getRequestsBySearch(Context ctx);
	
}
