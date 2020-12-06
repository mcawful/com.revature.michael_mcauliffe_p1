package com.revature.michael_mcauliffe_p1.controllers;

import io.javalin.http.Context;

public interface RequestController<T> {

	public void postRequest(Context ctx);
	
	public void updateRequest(Context ctx);
	
	public void deleteRequest(Context ctx);
	
	public void getRequest(Context ctx);
	
	public void getAllRequests();
	
	public void getRequestsBySearch(Context ctx);
	
}
