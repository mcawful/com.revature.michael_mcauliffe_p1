package com.revature.michael_mcauliffe_p1.dtos;

import java.util.Arrays;

import com.revature.michael_mcauliffe_p1.pojos.EventType;
import com.revature.michael_mcauliffe_p1.pojos.GradeFormat;
import com.revature.michael_mcauliffe_p1.pojos.Request;

public class RequestDto {

	private double cost, reimbursement;
	private String description, location, formID;
	private EventType eventType;
	private String otherEventType;
	private int employeeID;
	private String eventDateStart, eventDateEnd, postingDateAndTime;
	private GradeFormat gradeFormat;
	private String otherGradeFormat, passingGradeOther;
	private byte[] grade;
	private boolean isUrgent, isComplete;
	private Boolean isPassing;
	
	public RequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDto(double cost, double reimbursement, String description, String location, String formID,
			EventType eventType, String otherEventType, int employeeID, String eventDateStart, String eventDateEnd,
			String postingDateAndTime, GradeFormat gradeFormat, String otherGradeFormat, String passingGradeOther,
			byte[] grade, boolean isUrgent, boolean isComplete, Boolean isPassing) {
		super();
		this.cost = cost;
		this.reimbursement = reimbursement;
		this.description = description;
		this.location = location;
		this.formID = formID;
		this.eventType = eventType;
		this.otherEventType = otherEventType;
		this.employeeID = employeeID;
		this.eventDateStart = eventDateStart;
		this.eventDateEnd = eventDateEnd;
		this.postingDateAndTime = postingDateAndTime;
		this.gradeFormat = gradeFormat;
		this.otherGradeFormat = otherGradeFormat;
		this.passingGradeOther = passingGradeOther;
		this.grade = grade;
		this.isUrgent = isUrgent;
		this.isComplete = isComplete;
		this.isPassing = isPassing;
	}

	public RequestDto(Request request) {
		super();
		this.cost = request.getCost();
		this.reimbursement = request.getReimbursement();
		this.description = request.getDescription();
		this.location = request.getLocation();
		this.formID = request.getFormID();
		this.eventType = request.getEventType();
		this.otherEventType = request.getOtherEventType();
		this.employeeID = request.getEmployeeID();
		this.eventDateStart = request.getEventDateStart().toString();
		this.eventDateEnd = request.getEventDateEnd().toString();
		this.postingDateAndTime = request.getPostingDateAndTime().toString();
		this.gradeFormat = request.getGradeFormat();
		this.otherGradeFormat = request.getOtherGradeFormat();
		this.passingGradeOther = request.getPassingGradeOther();
		this.grade = request.getGrade();
		this.isUrgent = request.isUrgent();
		this.isComplete = request.isComplete();
		this.isPassing = request.isPassing();
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(double reimbursement) {
		this.reimbursement = reimbursement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFormID() {
		return formID;
	}

	public void setFormID(String formID) {
		this.formID = formID;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public String getOtherEventType() {
		return otherEventType;
	}

	public void setOtherEventType(String otherEventType) {
		this.otherEventType = otherEventType;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEventDateStart() {
		return eventDateStart;
	}

	public void setEventDateStart(String eventDateStart) {
		this.eventDateStart = eventDateStart;
	}

	public String getEventDateEnd() {
		return eventDateEnd;
	}

	public void setEventDateEnd(String eventDateEnd) {
		this.eventDateEnd = eventDateEnd;
	}

	public String getPostingDateAndTime() {
		return postingDateAndTime;
	}

	public void setPostingDateAndTime(String postingDateAndTime) {
		this.postingDateAndTime = postingDateAndTime;
	}

	public GradeFormat getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(GradeFormat gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	public String getOtherGradeFormat() {
		return otherGradeFormat;
	}

	public void setOtherGradeFormat(String otherGradeFormat) {
		this.otherGradeFormat = otherGradeFormat;
	}

	public String getPassingGradeOther() {
		return passingGradeOther;
	}

	public void setPassingGradeOther(String passingGradeOther) {
		this.passingGradeOther = passingGradeOther;
	}

	public byte[] getGrade() {
		return grade;
	}

	public void setGrade(byte[] grade) {
		this.grade = grade;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Boolean getIsPassing() {
		return isPassing;
	}

	public void setIsPassing(Boolean isPassing) {
		this.isPassing = isPassing;
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
		result = prime * result + ((eventDateEnd == null) ? 0 : eventDateEnd.hashCode());
		result = prime * result + ((eventDateStart == null) ? 0 : eventDateStart.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((formID == null) ? 0 : formID.hashCode());
		result = prime * result + Arrays.hashCode(grade);
		result = prime * result + ((gradeFormat == null) ? 0 : gradeFormat.hashCode());
		result = prime * result + (isComplete ? 1231 : 1237);
		result = prime * result + ((isPassing == null) ? 0 : isPassing.hashCode());
		result = prime * result + (isUrgent ? 1231 : 1237);
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((otherEventType == null) ? 0 : otherEventType.hashCode());
		result = prime * result + ((otherGradeFormat == null) ? 0 : otherGradeFormat.hashCode());
		result = prime * result + ((passingGradeOther == null) ? 0 : passingGradeOther.hashCode());
		result = prime * result + ((postingDateAndTime == null) ? 0 : postingDateAndTime.hashCode());
		temp = Double.doubleToLongBits(reimbursement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		RequestDto other = (RequestDto) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (eventDateEnd == null) {
			if (other.eventDateEnd != null)
				return false;
		} else if (!eventDateEnd.equals(other.eventDateEnd))
			return false;
		if (eventDateStart == null) {
			if (other.eventDateStart != null)
				return false;
		} else if (!eventDateStart.equals(other.eventDateStart))
			return false;
		if (eventType != other.eventType)
			return false;
		if (formID == null) {
			if (other.formID != null)
				return false;
		} else if (!formID.equals(other.formID))
			return false;
		if (!Arrays.equals(grade, other.grade))
			return false;
		if (gradeFormat != other.gradeFormat)
			return false;
		if (isComplete != other.isComplete)
			return false;
		if (isPassing == null) {
			if (other.isPassing != null)
				return false;
		} else if (!isPassing.equals(other.isPassing))
			return false;
		if (isUrgent != other.isUrgent)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (otherEventType == null) {
			if (other.otherEventType != null)
				return false;
		} else if (!otherEventType.equals(other.otherEventType))
			return false;
		if (otherGradeFormat == null) {
			if (other.otherGradeFormat != null)
				return false;
		} else if (!otherGradeFormat.equals(other.otherGradeFormat))
			return false;
		if (passingGradeOther == null) {
			if (other.passingGradeOther != null)
				return false;
		} else if (!passingGradeOther.equals(other.passingGradeOther))
			return false;
		if (postingDateAndTime == null) {
			if (other.postingDateAndTime != null)
				return false;
		} else if (!postingDateAndTime.equals(other.postingDateAndTime))
			return false;
		if (Double.doubleToLongBits(reimbursement) != Double.doubleToLongBits(other.reimbursement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestDto [cost=" + cost + ", reimbursement=" + reimbursement + ", description=" + description
				+ ", location=" + location + ", formID=" + formID + ", eventType=" + eventType + ", otherEventType="
				+ otherEventType + ", employeeID=" + employeeID + ", eventDateStart=" + eventDateStart
				+ ", eventDateEnd=" + eventDateEnd + ", postingDateAndTime=" + postingDateAndTime + ", gradeFormat="
				+ gradeFormat + ", otherGradeFormat=" + otherGradeFormat + ", passingGradeOther=" + passingGradeOther
				+ ", grade=" + Arrays.toString(grade) + ", isUrgent=" + isUrgent + ", isComplete=" + isComplete
				+ ", isPassing=" + isPassing + "]";
	}
	
}
