package com.revature.michael_mcauliffe_p1.pojos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Request implements Form {

	private double cost, reimbursement;
	private String description, location, formID;
	private EventType eventType;
	private String otherEventType;
	private int employeeID;
	private LocalDateTime eventDateStart, eventDateEnd, postingDateAndTime;
	private GradeFormat gradeFormat;
	private String otherGradeFormat, passingGradeOther;
	private byte[] grade;
	private boolean isUrgent, isComplete;
	private Boolean isPassing;

	public Request() {

		super();
		this.cost = 0.00;
		this.reimbursement = 0.00;
		this.description = "";
		this.eventType = null;
		this.otherEventType = "";
		this.location = "";
		this.employeeID = -1;
		this.eventDateStart = null;
		this.eventDateEnd = null;
		this.postingDateAndTime = null;
		this.gradeFormat = null;
		this.otherGradeFormat = "";
		this.passingGradeOther = "";
		this.grade = null;
		this.formID = "";
		this.isPassing = null;
		this.isUrgent = false;
		this.isComplete = false;
	}

	public Request(double cost, String description, EventType eventType, String location, int employeeID,
			LocalDateTime eventDateStart, LocalDateTime eventDateEnd, LocalDateTime postingDateAndTime,
			GradeFormat gradeFormat, String otherGradeFormat, String passingGradeOther, boolean isUrgent) {

		super();
		this.cost = cost;
		this.reimbursement = calculateReimbursement(cost, eventType);
		this.description = description;
		this.eventType = eventType;
		this.otherEventType = "";
		this.location = location;
		this.employeeID = employeeID;
		this.eventDateStart = eventDateStart.truncatedTo(ChronoUnit.MILLIS);
		this.eventDateEnd = eventDateEnd.truncatedTo(ChronoUnit.MILLIS);
		this.postingDateAndTime = postingDateAndTime.truncatedTo(ChronoUnit.MILLIS);
		this.gradeFormat = gradeFormat;
		this.otherGradeFormat = otherGradeFormat;
		this.passingGradeOther = passingGradeOther;
		this.grade = null;
		this.formID = makeID(employeeID, eventDateStart);
		this.isPassing = null;
		this.isUrgent = isUrgent;
		this.isComplete = false;
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
	public LocalDateTime getEventDateEnd() {

		return this.eventDateEnd;
	}

	@Override
	public LocalDateTime getEventDateStart() {

		return this.eventDateStart;
	}

	@Override
	public EventType getEventType() {

		return this.eventType;
	}

	@Override
	public String getFormID() {

		return this.formID;
	}

	@Override
	public byte[] getGrade() {

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

	public String getOtherEventType() {
		return otherEventType;
	}

	@Override
	public String getOtherGradeFormat() {

		return this.otherGradeFormat;
	}

	@Override
	public String getPassingGradeOther() {

		return this.passingGradeOther;
	}

	@Override
	public LocalDateTime getPostingDateAndTime() {

		return this.postingDateAndTime;
	}

	@Override
	public double getReimbursement() {

		return this.reimbursement;
	}

	@Override
	public boolean isComplete() {

		return this.isComplete;
	}

	@Override
	public Boolean isPassing() {

		return this.isPassing;
	}

	@Override
	public boolean isUrgent() {

		return this.isUrgent;
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
	public void setEventDateStart(LocalDateTime eventDateStart) {

		this.eventDateStart = eventDateStart.truncatedTo(ChronoUnit.MILLIS);
	}

	@Override
	public void setEventType(EventType eventType) {

		this.eventType = eventType;
	}

	@Override
	public void setFormID(String formID) {

		this.formID = formID;
	}

	@Override
	public void setGrade(byte[] grade) {

		this.grade = grade;
	}

	@Override
	public void setGradeFormat(GradeFormat gradeFormat) {

		this.gradeFormat = gradeFormat;
	}

	@Override
	public void setIsComplete(boolean isComplete) {

		this.isComplete = isComplete;
	}

	@Override
	public void setIsPassing(Boolean isPassing) {

		this.isPassing = isPassing;
	}

	@Override
	public void setIsUrgent(boolean isUrgent) {

		this.isUrgent = isUrgent;
	}

	@Override
	public void setLocalDateEnd(LocalDateTime eventDateEnd) {

		this.eventDateEnd = eventDateEnd.truncatedTo(ChronoUnit.MILLIS);
	}

	@Override
	public void setLocation(String location) {

		this.location = location;
	}

	public void setOtherEventType(String otherEventType) {
		this.otherEventType = otherEventType;
	}

	@Override
	public void setOtherGradeFormat(String otherGradeFormat) {

		this.otherGradeFormat = otherGradeFormat;
	}

	@Override
	public void setPassingGradeOther(String passingGradeOther) {

		this.passingGradeOther = passingGradeOther;
	}

	@Override
	public void setPostingDateAndTime(LocalDateTime postingDateAndTime) {

		this.postingDateAndTime = postingDateAndTime.truncatedTo(ChronoUnit.MILLIS);
	}

	@Override
	public void setReimbursement(double reimbursement) {

		this.reimbursement = reimbursement;
	}

	private double calculateReimbursement(double cost, EventType eventType) {

		switch (eventType) {

		case CERTIFICATION:
			return round(cost, 2);

		case TECHNICAL_TRAINING:
			return round(cost * 0.9, 2);

		case UNIVERSITY_COURSE:
			return round(cost * 0.8, 2);

		case PREPERATION_CLASS:
			return round(cost * 0.75, 2);

		case SEMINAR:
			return round(cost * 0.6, 2);

		default:
			return round(cost * 0.3, 2);
		}
	}

	private String makeID(int employeeID, LocalDateTime eventDate) {

		String formID = "";

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd");

		formID += Integer.toString(employeeID);

		for (int i = 6; i > formID.length();) {

			formID = "0" + formID;
		}

		formID += "-";

		formID += dtf.format(eventDate);

		formID += "-" + (int) (Math.random() * 99);

		return formID;
	}

	private double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
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
		return "Request [cost=" + cost + ", reimbursement=" + reimbursement + ", description=" + description
				+ ", location=" + location + ", formID=" + formID + ", eventType=" + eventType + ", otherEventType="
				+ otherEventType + ", employeeID=" + employeeID + ", eventDateStart=" + eventDateStart
				+ ", eventDateEnd=" + eventDateEnd + ", postingDateAndTime=" + postingDateAndTime + ", gradeFormat="
				+ gradeFormat + ", otherGradeFormat=" + otherGradeFormat + ", passingGradeOther=" + passingGradeOther
				+ ", grade=" + Arrays.toString(grade) + ", isUrgent=" + isUrgent + ", isComplete=" + isComplete
				+ ", isPassing=" + isPassing + "]";
	}
	
}