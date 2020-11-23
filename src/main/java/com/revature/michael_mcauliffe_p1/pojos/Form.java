package com.revature.michael_mcauliffe_p1.pojos;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public interface Form<T> {

	public void addAttachment(File attachment);
	
	public void addAttachmentDescriptor(String attachmentDescriptor);
	
	public List<File> getAttachments();
	
	public List<String> getAttachmentsDescriptors();
	
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
	
	public int isPassing();
	
	public void setCost(double cost);
	
	public void setCurrentDateAndTime(LocalDateTime date);
	
	public void setDecription(String decription);
	
	public void setEmployeeID(int employeeID);
	
	public void setEventDate(LocalDateTime date);
	
	public void setEventType(String eventType);
	
	public void setFormID(String formID);
	
	public void setGrade(String grade);
	
	public void setGradeFormat(GradeFormat gradeFormat);
	
	public void setIsPassing(int isPassing);
	
	public void setLocation(String location);
	
	public void setOtherGradeFormat(String otherGradeFormat);
	
}
