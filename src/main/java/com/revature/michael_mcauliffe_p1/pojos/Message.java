package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;

public interface Message<T> {

	public String getMessage();
	
	public T getRecipient();
	
	public T getSender();
	
	public LocalDateTime getSentDateAndTime();
	
	public void getSentDateAndTime(LocalDateTime date);
	
	public boolean isRead();
	
	public void setIsRead(boolean isRead);
	
	public void setMessage(String message);
	
	public void setRecipient(T obj);
	
	public void setSender(T obj);
}
