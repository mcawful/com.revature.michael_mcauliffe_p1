package com.revature.michael_mcauliffe_p1.pojos;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Request implements Form <Employee>, Approver <RequestMessage> {

	private ArrayList<File> attachmentList;
	private ArrayList<String> attachmentsDescriptorList;
	private double cost;
	private String description, eventType, grade, location,  formID;
	private int firstApproval, secondApproval, finalApproval, employeeID;
	private LocalDateTime firstApprovalDateAndTime, secondApprovalDateAndTime, finalApprovalDateAndTime,
				eventDate, postingDateAndTime;
	private ArrayList<RequestMessage> firstApprovalNoteList, secondApprovalNoteList, finalApprovalNoteList;
	private boolean isCompleted, needsDetails;
	GradeFormat gradeFormat;
	private String otherGradeFormat;
	private int isPassing;

	public Request() {
		super();
		this.attachmentList = null;
		this.attachmentsDescriptorList = null;
		this.cost = -1;
		this.description = "";
		this.eventType = "";
		this.grade = "";
		this.location = "";
		this.formID = "";
		this.employeeID = -1;
		this.firstApproval = 0;
		this.secondApproval = 0;
		this.finalApproval = 0;
		this.gradeFormat = null;
		this.firstApprovalDateAndTime = null;
		this.secondApprovalDateAndTime = null;
		this.finalApprovalDateAndTime = null;
		this.eventDate = null;
		this.postingDateAndTime = null;
		this.firstApprovalNoteList = null;
		this.secondApprovalNoteList = null;
		this.finalApprovalNoteList = null;
		this.isCompleted = false;
		this.needsDetails = false;
		this.otherGradeFormat = "";
		this.isPassing = 0;
	}

	public Request(double cost, String description, String eventType, String grade, String location,
			int employeeID, GradeFormat gradeFormat, LocalDateTime eventDate, LocalDateTime postingDateAndTime) {
		
		super();
		this.attachmentList = new ArrayList<File>();
		this.attachmentsDescriptorList = new ArrayList<String>();
		this.cost = cost;
		this.description = description;
		this.eventType = eventType;
		this.grade = "";
		this.location = location;
		this.formID = makeID(employeeID, eventDate);
		this.employeeID = employeeID;
		this.firstApproval = 0;
		this.secondApproval = 0;
		this.finalApproval = 0;
		this.gradeFormat = gradeFormat;
		this.firstApprovalDateAndTime = null;
		this.secondApprovalDateAndTime = null;
		this.finalApprovalDateAndTime = null;
		this.eventDate = eventDate;
		this.postingDateAndTime = postingDateAndTime;
		this.firstApprovalNoteList = new ArrayList<RequestMessage>();
		this.secondApprovalNoteList = new ArrayList<RequestMessage>();
		this.finalApprovalNoteList = new ArrayList<RequestMessage>();
		this.isCompleted = false;
		this.needsDetails = false;
		this.otherGradeFormat = "";
		this.isPassing = 0;
	}

	private String makeID(int employeeID, LocalDateTime eventDate) {
		
		String formID = "";
		
		DateFormat simple = new SimpleDateFormat("yyMMdd");
		
		formID += Integer.toString(employeeID);
		
		for(int i = 6; i > formID.length() ; ) {
			
			formID += "0" + formID;
		}
		
		formID += "-";
		
		formID += simple.format(eventDate);
		
		return formID;
	}

	@Override
	public void addAttachment(File attachment) {
		
		this.attachmentList.add(attachment);
	}

	@Override
	public void addAttachmentDescriptor(String attachmentDescriptor) {
		
		this.attachmentsDescriptorList.add(attachmentDescriptor);
	}

	@Override
	public void addFinalApprovalNote(RequestMessage note) {
		
		this.finalApprovalNoteList.add(note);
	}

	@Override
	public void addFirstApprovalNote(RequestMessage note) {
		
		this.firstApprovalNoteList.add(note);
	}

	@Override
	public void addsecondApprovalNote(RequestMessage note) {
		
		this.secondApprovalNoteList.add(note);
	}

	@Override
	public List<File> getAttachments() {
		
		return this.attachmentList;
	}

	@Override
	public List<String> getAttachmentsDescriptors() {
		
		return this.attachmentsDescriptorList;
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
	public LocalDateTime getEventDate() {
		
		return this.eventDate;
	}

	@Override
	public String getEventType() {
		
		return this.eventType;
	}

	@Override
	public int getFinalApproval() {
		
		return this.finalApproval;
	}

	@Override
	public LocalDateTime getFinalApprovalDateAndTime() {
		
		return this.finalApprovalDateAndTime;
	}

	@Override
	public List<RequestMessage> getFinalApprovalNotes() {
		
		return this.finalApprovalNoteList;
	}

	@Override
	public int getFirstApproval() {
		
		return this.firstApproval;
	}

	@Override
	public LocalDateTime getFirstApprovalDateAndTime() {
		
		return this.firstApprovalDateAndTime;
	}

	@Override
	public List<RequestMessage> getFirstApprovalNotes() {
		
		return this.firstApprovalNoteList;
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
	public boolean getIsCompleted() {
		
		return this.isCompleted;
	}

	@Override
	public String getLocation() {
		
		return this.location;
	}

	@Override
	public LocalDateTime getPostingDateAndTime() {
		
		return this.postingDateAndTime;
	}

	@Override
	public int getSecondApproval() {
		
		return this.secondApproval;
	}

	@Override
	public LocalDateTime getSecondApprovalDateAndTime() {
		
		return this.secondApprovalDateAndTime;
	}

	@Override
	public List<RequestMessage> getSecondApprovalNotes() {
		
		return this.secondApprovalNoteList;
	}

	@Override
	public boolean needsMoreDetails() {
		
		return this.needsDetails;
	}

	@Override
	public void setCost(double cost) {
		
		this.cost = cost;
	}

	@Override
	public void setCurrentDateAndTime(LocalDateTime date) {
		
		this.postingDateAndTime = date;
	}

	@Override
	public void setDecription(String description) {
		
		this.description = description;
	}

	@Override
	public void setEventDate(LocalDateTime date) {
		
		this.eventDate = date;
	}

	@Override
	public void setEventType(String eventType) {
		
		this.eventType = eventType;
	}

	@Override
	public void setFinalApproval(int approval) {
		
		this.finalApproval = approval;
	}

	@Override
	public void setFinalApprovalDateAndTime(LocalDateTime date) {
		
		this.finalApprovalDateAndTime = date;
	}

	@Override
	public void setFirstApprovalDateAndTime(LocalDateTime date) {
		
		this.firstApprovalDateAndTime = date;
	}

	@Override
	public void setFirstApproval(int approval) {
		
		this.firstApproval = approval;
	}

	@Override
	public String getFormID() {
		
		return this.formID;
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
	public void setIsCompleted(boolean isCompleted) {
		
		this.isCompleted = isCompleted;
	}

	@Override
	public void setLocation(String location) {
		
		this.location = location;
	}

	@Override
	public void setNeedsMoreDetails(boolean needsDetails) {
		
		this.needsDetails = needsDetails;
	}

	@Override
	public void setSecondApprovalDateAndTime(LocalDateTime date) {
		
		this.secondApprovalDateAndTime = date;
	}

	@Override
	public void setSecondApproval(int approval) {
		
		this.secondApproval = approval;
	}

	@Override
	public String getOtherGradeFormat() {
		
		return this.otherGradeFormat;
	}

	@Override
	public int isPassing() {
		
		return this.isPassing;
	}

	@Override
	public void setIsPassing(int isPassing) {
		
		this.isPassing = isPassing;
	}

	@Override
	public void setOtherGradeFormat(String otherGradeFormat) {
		
		this.otherGradeFormat = otherGradeFormat;
	}

	@Override
	public void addFinalApprovalNoteList(List<RequestMessage> noteList) {
		
		this.finalApprovalNoteList = (ArrayList<RequestMessage>) noteList;
	}

	@Override
	public void addFirstApprovalNoteList(List<RequestMessage> noteList) {
		
		this.firstApprovalNoteList = (ArrayList<RequestMessage>) noteList;
	}

	@Override
	public void addSecondApprovalNoteList(List<RequestMessage> noteList) {
		
		this.secondApprovalNoteList = (ArrayList<RequestMessage>) noteList;
	}

	@Override
	public int getEmployeeID() {
		
		return this.employeeID;
	}

	@Override
	public void setEmployeeID(int employeeID) {
		
		this.employeeID = employeeID;
	}
}