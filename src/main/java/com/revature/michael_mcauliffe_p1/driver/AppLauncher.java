package com.revature.michael_mcauliffe_p1.driver;

import com.revature.michael_mcauliffe_p1.controllers.EmployeeControllerImpl;
import com.revature.michael_mcauliffe_p1.controllers.LoginControllerImpl;
import com.revature.michael_mcauliffe_p1.controllers.RequestControllerImpl;

import io.javalin.Javalin;

public class AppLauncher {

	private static EmployeeControllerImpl employeeController = new EmployeeControllerImpl();
	private static LoginControllerImpl loginController = new LoginControllerImpl();
	private static RequestControllerImpl requestController = new RequestControllerImpl();
	
	final static String EMPLOYEE_PATH = "/employee";
	final static String LOGIN_PATH = "/login";
	final static String REQUEST_PATH = "/request";
	final static String DASHBOARD_PATH = "/dashboard";
	
	public static void main(String[] args) {
		Javalin app = Javalin.create( config -> {
			config.addStaticFiles("/public");
		}).start(9090);
		
		app.get(LOGIN_PATH, ctx -> ctx.redirect("login.html"));
		app.get(DASHBOARD_PATH, ctx -> ctx.redirect("dashboard.html"));
		app.get("/logout", ctx -> ctx.redirect("login.html"));
		
		employeeEndPoints(app);
		loginEndPoints(app);
		requestEndPoints(app);

	}

	private static void employeeEndPoints(Javalin app) {
		
		app.post(EMPLOYEE_PATH, ctx -> employeeController.postEmployee(ctx));
		app.put(EMPLOYEE_PATH, ctx -> employeeController.updateEmployee(ctx));
		app.get(EMPLOYEE_PATH, ctx -> employeeController.getEmployee(ctx));
		app.delete(EMPLOYEE_PATH, ctx -> employeeController.deleteEmployee(ctx));
	}
	
	private static void loginEndPoints(Javalin app) {
		app.put(LOGIN_PATH, ctx -> loginController.updateLogin(ctx));
		app.post(LOGIN_PATH, ctx -> loginController.getVerifyLogin(ctx));
		app.post(LOGIN_PATH + "/add", ctx -> loginController.postLogin(ctx));
		app.delete(LOGIN_PATH, ctx -> loginController.deleteLogin(ctx));
	}
	
	private static void requestEndPoints(Javalin app) {
		app.get(REQUEST_PATH, ctx -> ctx.redirect("make-request.html"));
		app.post(REQUEST_PATH + "/make", ctx -> requestController.postRequest(ctx));
	}
	
}
