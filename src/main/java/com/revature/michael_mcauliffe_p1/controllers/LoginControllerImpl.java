package com.revature.michael_mcauliffe_p1.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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
		ctx.status(400);
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
		ctx.status(406);
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
		ctx.status(406);
		return false;
	}

	@Override
	public boolean getVerifyLogin(Context ctx) {

		try {
			String username = ctx.formParam("username");
			String password = ctx.formParam("password");
			
			Login login = loginService.getLoginByUsername(username);
			
			if(login != null) {
				String storedHash = login.getPassword();

				boolean success = HashAndVerifyUtil.verify(password, storedHash, HashAndVerifyUtil.Strength.HIGH);
				if (success) {
					ctx.cookieStore("auth", login.getID());
					ctx.redirect("/dashboard.html");
					return true;
				}
			}
			
			ctx.redirect("/login.html#badLogin");
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
	public void getLoginByUsername(Context ctx) {

		try {
			String username = ctx.cookieStore("auth");

				ctx.redirect("/dashboard");

		} catch (Exception e) {
			// TODO Add logging
			e.printStackTrace();
			ctx.redirect("/login", 400);
		}
	}

	private Login makeLogin(Context ctx) throws NoSuchAlgorithmException, InvalidKeySpecException {

		int employeeID = Integer.valueOf(ctx.formParam("employeeID"));
		String username = ctx.formParam("username");
		String password = HashAndVerifyUtil.hash(ctx.formParam("password"), HashAndVerifyUtil.Strength.HIGH);
		Login login = new Login(username, password, employeeID);

		return login;
	}

}
