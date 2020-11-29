package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;

public interface Message {

	public String getMessage();
	
	public int getRecipientID();
	
	public int getSenderID();
	
	public LocalDateTime getSentDateAndTime();
	
	public boolean isRead();
	
	public void setIsRead(boolean isRead);
	
	public void setMessage(String message);
	
	public void setRecipient(int recipientID);
	
	public void setSender(int senderID);
	
	public void setSentDateAndTime(LocalDateTime date);
}
