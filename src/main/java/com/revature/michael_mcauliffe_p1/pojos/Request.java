package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Request implements Form {

	private double cost;
	private String description, eventType, grade, location,  formID;
	private int employeeID;
	private LocalDateTime eventDate, postingDateAndTime;
	private GradeFormat gradeFormat;
	private String otherGradeFormat;
	private Boolean isPassing;
	
	public Request() {
		
		super();
		this.cost = 0.00;
		this.description = "";
		this.eventType = "";
		this.location = "";
		this.employeeID = -1;
		this.eventDate = null;
		this.postingDateAndTime = null;
		this.gradeFormat = null;
		this.otherGradeFormat = "";
		this.formID = "";
	}
	
	public Request(double cost, String description, String eventType, String location, int employeeID,
			LocalDateTime eventDate, LocalDateTime postingDateAndTime, GradeFormat gradeFormat,
			String otherGradeFormat) {
		
		super();
		this.cost = cost;
		this.description = description;
		this.eventType = eventType;
		this.location = location;
		this.employeeID = employeeID;
		this.eventDate = eventDate;
		this.postingDateAndTime = postingDateAndTime;
		this.gradeFormat = gradeFormat;
		this.otherGradeFormat = otherGradeFormat;
		this.formID = makeID(employeeID, eventDate);
	}
	
	@Override
	public double getCost() {
		
		return this.cost;
	}
	@Override
	public String getDescription() {
		
		return this.description;
	}
	@Override
	public int getEmployeeID() {
		
		return this.employeeID;
	}
	@Override
	public LocalDateTime getEventDate() {
		
		return this.eventDate;
	}
	@Override
	public String getEventType() {
		
		return this.eventType;
	}
	@Override
	public String getFormID() {
		
		return this.formID;
	}
	@Override
	public String getGrade() {
		
		return this.grade;
	}
	@Override
	public GradeFormat getGradeFormat() {
		
		return this.gradeFormat;
	}
	@Override
	public String getLocation() {
		
		return this.location;
	}
	@Override
	public String getOtherGradeFormat() {
		
		return this.otherGradeFormat;
	}
	@Override
	public LocalDateTime getPostingDateAndTime() {
		
		return this.postingDateAndTime;
	}
	@Override
	public Boolean isPassing() {
		
		return this.isPassing();
	}
	@Override
	public void setCost(double cost) {
		
		this.cost = cost;
	}
	@Override
	public void setDecription(String decription) {
		
		this.description = decription;
	}
	@Override
	public void setEmployeeID(int employeeID) {
		
		this.employeeID = employeeID;
	}
	@Override
	public void setEventDate(LocalDateTime eventDate) {
		
		this.eventDate = eventDate;
	}
	@Override
	public void setEventType(String eventType) {
		
		this.eventType = eventType;
	}
	@Override
	public void setFormID(String formID) {
		
		this.formID = formID;
	}
	@Override
	public void setGrade(String grade) {
		
		this.grade = grade;
	}
	@Override
	public void setGradeFormat(GradeFormat gradeFormat) {
		
		this.gradeFormat = gradeFormat;
	}
	@Override
	public void setIsPassing(Boolean isPassing) {
		
		this.isPassing = isPassing;
	}
	@Override
	public void setLocation(String location) {
		
		this.location = location;
	}
	@Override
	public void setOtherGradeFormat(String otherGradeFormat) {
		
		this.otherGradeFormat = otherGradeFormat;
	}
	@Override
	public void setPostingDateAndTime(LocalDateTime postingDateAndTime) {
		
		this.postingDateAndTime = postingDateAndTime;
	}

	private String makeID(int employeeID, LocalDateTime eventDate) {
		
		String formID = "";
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd");
		
		formID += Integer.toString(employeeID);
		
		for(int i = 6; i > formID.length() ; ) {
			
			formID = "0" + formID;
		}
		
		formID += "-";
		
		formID += dtf.format(eventDate);
		
		formID += "-" + (int)(Math.random() * 99);
		
		return formID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employeeID;
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((formID == null) ? 0 : formID.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((gradeFormat == null) ? 0 : gradeFormat.hashCode());
		result = prime * result + ((isPassing == null) ? 0 : isPassing.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((otherGradeFormat == null) ? 0 : otherGradeFormat.hashCode());
		result = prime * result + ((postingDateAndTime == null) ? 0 : postingDateAndTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (formID == null) {
			if (other.formID != null)
				return false;
		} else if (!formID.equals(other.formID))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (gradeFormat != other.gradeFormat)
			return false;
		if (isPassing == null) {
			if (other.isPassing != null)
				return false;
		} else if (!isPassing.equals(other.isPassing))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (otherGradeFormat == null) {
			if (other.otherGradeFormat != null)
				return false;
		} else if (!otherGradeFormat.equals(other.otherGradeFormat))
			return false;
		if (postingDateAndTime == null) {
			if (other.postingDateAndTime != null)
				return false;
		} else if (!postingDateAndTime.equals(other.postingDateAndTime))
			return false;
		return true;
	}
	
}