package com.revature.michael_mcauliffe_p1.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.revature.michael_mcauliffe_p1.dtos.RequestDto;
import com.revature.michael_mcauliffe_p1.pojos.Approval;
import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.EventType;
import com.revature.michael_mcauliffe_p1.pojos.GradeFormat;
import com.revature.michael_mcauliffe_p1.pojos.Request;
import com.revature.michael_mcauliffe_p1.pojos.RequestApproval;
import com.revature.michael_mcauliffe_p1.services.ApprovalServiceImpl;
import com.revature.michael_mcauliffe_p1.services.EmployeeServiceImpl;
import com.revature.michael_mcauliffe_p1.services.RequestServiceImpl;

import io.javalin.http.Context;

public class RequestControllerImpl implements RequestController<Request> {

	RequestServiceImpl requestService = new RequestServiceImpl();
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	ApprovalServiceImpl approvalService = new ApprovalServiceImpl();

	@Override
	public void postRequest(Context ctx) {

		String description = ctx.formParam("eventDescription");
		EventType eventType = EventType.valueOf(ctx.formParam("eventDropdown"));
		String location = ctx.formParam("location");
		GradeFormat gradeFormat = GradeFormat.valueOf(ctx.formParam("gradeType"));
		LocalDateTime eventDateStart = LocalDate.parse(ctx.formParam("startDateCalendar")).atStartOfDay();
		LocalDateTime eventDateEnd = LocalDate.parse(ctx.formParam("endDateCalendar")).atStartOfDay();
		LocalDateTime postingDateAndTime = LocalDateTime.now();
		String otherEventType = ctx.formParam("otherEventType");
		String otherGradeFormat = ctx.formParam("otherGradeType");
		String passingGradeOther = ctx.formParam("otherPassingGrade");
		int employeeID = ctx.cookieStore("auth");
		double cost = Double.parseDouble(ctx.formParam("eventCost").replaceAll("[$,]", ""));
		boolean isUrgent;
		if (postingDateAndTime.plusWeeks(2).isAfter(eventDateStart)) {
			isUrgent = true;
		} else
			isUrgent = false;

		Request request = new Request(cost, description, eventType, location, employeeID, eventDateStart, eventDateEnd,
				postingDateAndTime, gradeFormat, otherGradeFormat, passingGradeOther, isUrgent);

		request.setOtherEventType(otherEventType);
		Employee employee = employeeService.getEmployee(employeeID);
		RequestApproval approval = approvalService.makeApproval(request, employee);
		
		if (requestService.addRequest(request) && approvalService.addApproval(approval)) {
			
			ctx.redirect("/pending");
		} else {
			ctx.redirect("/request-make.html#error");
		}

	}

	@Override
	public void updateRequest(Context ctx) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteRequest(Context ctx) {
		// TODO Auto-generated method stub
	}

	@Override
	public void getRequest(Context ctx) {
		// TODO Auto-generated method stub
	}

	@Override
	public void getAllRequests(Context ctx) {
		List<RequestDto> requestList = requestService.getRequestsByRequester(ctx.cookieStore("auth"));
		ctx.json(requestList);
	}

	@Override
	public void getRequestsBySearch(Context ctx) {
		// TODO Auto-generated method stub
	}

}
