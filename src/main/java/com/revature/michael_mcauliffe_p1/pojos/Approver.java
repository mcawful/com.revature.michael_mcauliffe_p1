package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;
import java.util.List;

public interface Approver<T> {

	public void addFinalApprovalNote(T t);
	
	public void addFinalApprovalNoteList(List<T> t);

	public void addFirstApprovalNote(T t);
	
	public void addFirstApprovalNoteList(List<T> t);

	public void addsecondApprovalNote(T t);

	public void addSecondApprovalNoteList(List<T> t);
	
	public int getFinalApproval();

	public LocalDateTime getFinalApprovalDateAndTime();

	public List<T> getFinalApprovalNotes();

	public int getFirstApproval();

	public LocalDateTime getFirstApprovalDateAndTime();

	public List<T> getFirstApprovalNotes();

	public boolean getIsCompleted();

	public int getSecondApproval();

	public LocalDateTime getSecondApprovalDateAndTime();

	public List<T> getSecondApprovalNotes();

	public boolean needsMoreDetails();

	public void setFinalApproval(int approval);

	public void setFinalApprovalDateAndTime(LocalDateTime date);

	public void setFirstApprovalDateAndTime(LocalDateTime date);

	public void setFirstApproval(int approval);

	public void setIsCompleted(boolean isCompleted);

	public void setNeedsMoreDetails(boolean needsDetails);

	public void setSecondApprovalDateAndTime(LocalDateTime date);

	public void setSecondApproval(int approval);

}
