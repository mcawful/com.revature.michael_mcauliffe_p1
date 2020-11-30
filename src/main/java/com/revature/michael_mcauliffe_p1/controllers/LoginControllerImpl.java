package com.revature.michael_mcauliffe_p1.controllers;

import com.revature.michael_mcauliffe_p1.pojos.Login;
import com.revature.michael_mcauliffe_p1.services.LoginServiceImpl;
import com.revature.michael_mcauliffe_p1.utils.HashAndVerifyUtil;

import io.javalin.http.Context;

public class LoginControllerImpl implements LoginController<Login> {

	LoginServiceImpl loginService = new LoginServiceImpl();

	@Override
	public boolean postLogin(Context ctx) {

		try {
			Login login = makeLogin(ctx);
			if (loginService.addLogin(login)) {
				ctx.html("New login creation successful");
				ctx.status(201);
				return true;
			}
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
			return false;
		}
		
		ctx.html("Username already exists");
		ctx.status(200);
		return false;
	}

	@Override
	public boolean updateLogin(Context ctx) {

		try {
			Login login = makeLogin(ctx);
			if (loginService.updateLogin(login)) {
				
				ctx.html("Login information updated");
				ctx.status(200);
				return true;
			}
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
			return false;
		}
		
		ctx.html("Login information cound not be updated");
		ctx.status(200);
		return false;
	}

	@Override
	public boolean deleteLogin(Context ctx) {

		try {
			int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
			if (loginService.deleteLogin(employeeID)) {
				ctx.html("Login information deleted");
				ctx.status(200);
				return true;
			}
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
			return false;
		}
		ctx.html("Login information not found for that employee");
		ctx.status(200);
		return false;
	}

	@Override
	public boolean getVerifyLogin(Context ctx) {

		try {
			String username = ctx.formParam("username");
			String password = ctx.formParam("password");
			String storedHash = loginService.getLoginByUsername(username).getPassword();

			boolean success = HashAndVerifyUtil.verify(password, storedHash);
			if (success) {
				ctx.html("Login successful");
				ctx.status(200);
				return true;
			}
			ctx.html("Incorrect login");
			ctx.status(401);
			return false;

		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
			return false;
		}
	}

	@Override
	public Login getLoginByID(Context ctx) {

		try {
			int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
			return loginService.getLoginByID(employeeID);
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
			return null;
		}
	}

	@Override
	public Login getLoginByUsername(Context ctx) {

		try {
			String username = ctx.formParam("username");
			return loginService.getLoginByUsername(username);
		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.status(400);
			return null;
		}
	}

	private Login makeLogin(Context ctx) {

		int employeeID = Integer.valueOf(ctx.formParam("employeeID"));
		String username = ctx.formParam("username");
		String password = HashAndVerifyUtil.hash(ctx.formParam("password"));

		Login login = new Login(username, password, employeeID);

		return login;
	}

}
