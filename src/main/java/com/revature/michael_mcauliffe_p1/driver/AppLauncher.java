package com.revature.michael_mcauliffe_p1.driver;

import com.revature.michael_mcauliffe_p1.controllers.EmployeeControllerImpl;
import com.revature.michael_mcauliffe_p1.controllers.LoginControllerImpl;

import io.javalin.Javalin;

public class AppLauncher {

	private static EmployeeControllerImpl employeeController = new EmployeeControllerImpl();
	private static LoginControllerImpl loginController = new LoginControllerImpl();
	
	final static String EMPLOYEE_PATH = "/employee";
	final static String LOGIN_PATH = "/login";
	
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(9090);
		
		employeeEndPoints(app);
		loginEndPoints(app);

	}

	private static void employeeEndPoints(Javalin app) {
		
		app.post(EMPLOYEE_PATH, ctx -> employeeController.postEmployee(ctx));
		app.put(EMPLOYEE_PATH, ctx -> employeeController.updateEmployee(ctx));
		app.get(EMPLOYEE_PATH, ctx -> employeeController.getEmployee(ctx));
		app.delete(EMPLOYEE_PATH, ctx -> employeeController.deleteEmployee(ctx));
	}
	
	private static void loginEndPoints(Javalin app) {
		
		app.post(LOGIN_PATH, ctx -> loginController.postLogin(ctx));
		app.put(LOGIN_PATH, ctx -> loginController.updateLogin(ctx));
		app.get(LOGIN_PATH, ctx -> loginController.getVerifyLogin(ctx));
		app.delete(LOGIN_PATH, ctx -> loginController.deleteLogin(ctx));
	}
	
}
