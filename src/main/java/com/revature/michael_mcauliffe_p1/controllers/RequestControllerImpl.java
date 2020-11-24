package com.revature.michael_mcauliffe_p1.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.GradeFormat;
import com.revature.michael_mcauliffe_p1.pojos.Request;

import io.javalin.http.Context;

public class RequestControllerImpl implements RequestController<Request> {

	@Override
	public boolean postRequest(Context ctx) {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		double cost = Double.parseDouble(ctx.formParam("cost"));
		String description = ctx.formParam("description");
		String eventType = ctx.formParam("EventType");
		String location = ctx.formParam("locations");
		int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
		GradeFormat gradeFormat = GradeFormat.valueOf(ctx.formParam("gradeFormat"));
		String otherGradeFormat = ctx.formParam("otherGradeFormat");
		LocalDateTime eventDate = LocalDateTime.parse(ctx.formParam("eventDate"), formatter);
		LocalDateTime postingDateAndTime = LocalDateTime.parse(ctx.formParam("requestDate"), formatter);		
		
		Request request = new Request(cost, description, eventType, location, employeeID, eventDate, postingDateAndTime, gradeFormat, otherGradeFormat);
	
		return false;
	}

	@Override
	public boolean updateRequest(Context ctx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRequest(Context ctx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Request getRequest(Context ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getRequestsBySearch(Context ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
