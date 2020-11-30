package com.revature.michael_mcauliffe_p1.controllers;

import io.javalin.http.Context;

public interface LoginController<T> {

	public boolean postLogin(Context ctx);

	public boolean updateLogin(Context ctx);

	public boolean deleteLogin(Context ctx);
	
	public boolean getVerifyLogin(Context ctx);

	public T getLoginByID(Context ctx);

	public T getLoginByUsername(Context ctx);

}
