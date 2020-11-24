package com.revature.michael_mcauliffe_p1.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.michael_mcauliffe_p1.pojos.Employee;

import io.javalin.http.Context;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@Mock
	private Context ctx;
	
	@Mock
	private Employee employee;
	
	private EmployeeControllerImpl employeeController = new EmployeeControllerImpl();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.employee = new Employee("John", "Doe", "123 Sesame St", "Orlando", "FL", 12345,
				"8005555555", "yes@no.com", "President");
		
		/*Mockito.when(ctx.formParam("firstName")).thenReturn(employee.getFirstName());
		Mockito.when(ctx.formParam("lastName")).thenReturn(employee.getLastName());
		Mockito.when(ctx.formParam("address")).thenReturn(employee.getAddress());
		Mockito.when(ctx.formParam("city")).thenReturn(employee.getCity());
		Mockito.when(ctx.formParam("postalCode")).thenReturn(Integer.toString(employee.getPostalCode()));
		Mockito.when(ctx.formParam("phoneNumer")).thenReturn(employee.getPhoneNumber());
		Mockito.when(ctx.formParam("email")).thenReturn(employee.getEmail());
		Mockito.when(ctx.queryParam("jobTitle")).thenReturn(employee.getJobTitle());
		Mockito.when(ctx.queryParam("reportsTo")).thenReturn(Integer.toString(employee.getReportsTo()));*/
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void postEmployeeTest() {
		
		assertTrue(employeeController.postEmployee(ctx));
	}

}
