package com.revature.michael_mcauliffe_p1.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.EventType;
import com.revature.michael_mcauliffe_p1.pojos.GradeFormat;
import com.revature.michael_mcauliffe_p1.pojos.Request;

import io.javalin.http.Context;

public class RequestControllerImpl implements RequestController<Request> {

	@Override
	public boolean postRequest(Context ctx) {

		String description = ctx.formParam("eventDescription");
		EventType eventType = EventType.valueOf(ctx.formParam("eventDropdown"));
		String location = ctx.formParam("location");
		GradeFormat gradeFormat = GradeFormat.valueOf(ctx.formParam("gradeType"));
		LocalDateTime eventDateStart = LocalDate.parse(ctx.formParam("startDateCalendar")).atStartOfDay();
		LocalDateTime eventDateEnd = LocalDate.parse(ctx.formParam("endDateCalendar")).atStartOfDay();
		LocalDateTime postingDateAndTime = LocalDateTime.now();
		String otherEventType = ctx.formParam("otherEventType");
		String otherGradeFormat = ctx.formParam("otherGradeType");
		String passingGradeOther = ctx.formParam("passingGradeOther");
		int employeeID = ctx.cookieStore("auth");
		double cost = Double.parseDouble(ctx.formParam("eventCost").replaceAll("[$,]", ""));
		boolean isUrgent;
		if(postingDateAndTime.plusWeeks(2).isAfter(eventDateStart)) {
			isUrgent = true;
		}
		else isUrgent = false;

		Request request = new Request(cost, description, eventType, location, employeeID, eventDateStart, eventDateEnd,
				postingDateAndTime, gradeFormat, otherGradeFormat, passingGradeOther, isUrgent);
		request.setOtherEventType(otherEventType);
		System.out.println(request.toString());
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
	public boolean getRequest(Context ctx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllRequests() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRequestsBySearch(Context ctx) {
		// TODO Auto-generated method stub
		return false;
	}


}
