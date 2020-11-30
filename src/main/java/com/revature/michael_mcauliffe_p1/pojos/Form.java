package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;

public interface Form {

	public double getCost();

	public String getDescription();

	public int getEmployeeID();

	public LocalDateTime getEventDateStart();

	public EventType getEventType();

	public String getFormID();

	public byte[] getGrade();

	public GradeFormat getGradeFormat();

	public String getLocation();

	public String getOtherGradeFormat();

	public String getPassingGradeOther();

	public LocalDateTime getPostingDateAndTime();

	public double getReimbursement();

	public boolean isComplete();

	public Boolean isPassing();

	public boolean isUrgent();

	public void setCost(double cost);

	public void setDecription(String decription);

	public void setEmployeeID(int employeeID);

	public void setEventDateStart(LocalDateTime date);

	public void setEventType(EventType eventType);

	public void setFormID(String formID);

	public void setGrade(byte[] grade);

	public void setGradeFormat(GradeFormat gradeFormat);

	public void setIsComplete(boolean isComplete);

	public void setIsPassing(Boolean isPassing);

	public void setIsUrgent(boolean isUrgent);

	public void setLocation(String location);

	public void setOtherGradeFormat(String otherGradeFormat);

	public void setPassingGradeOther(String passingGradeOther);

	public void setPostingDateAndTime(LocalDateTime date);

	public void setReimbursement(double reimbursement);

	public LocalDateTime getEventDateEnd();

	public void setLocalDateEnd(LocalDateTime date);
}
