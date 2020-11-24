package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;

public interface Form {

	public double getCost();
	
	public String getDescription();
	
	public int getEmployeeID();
	
	public LocalDateTime getEventDate();
	
	public String getEventType();
	
	public String getFormID();
	
	public String getGrade();
	
	public GradeFormat getGradeFormat();
	
	public String getLocation();
	
	public String getOtherGradeFormat();
	
	public LocalDateTime getPostingDateAndTime();
	
	public Boolean isPassing();
	
	public void setCost(double cost);
	
	public void setDecription(String decription);
	
	public void setEmployeeID(int employeeID);
	
	public void setEventDate(LocalDateTime date);
	
	public void setEventType(String eventType);
	
	public void setFormID(String formID);
	
	public void setGrade(String grade);
	
	public void setGradeFormat(GradeFormat gradeFormat);
	
	public void setIsPassing(Boolean isPassing);
	
	public void setLocation(String location);
	
	public void setOtherGradeFormat(String otherGradeFormat);
	
	public void setPostingDateAndTime(LocalDateTime date);
	
}
