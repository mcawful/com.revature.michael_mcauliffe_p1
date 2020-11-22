package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;

public class RequestMessage implements Message <Employee> {

	int ID;
	String message;
	Employee sender, recipient;
	LocalDateTime sentDateAndTime;
	boolean isRead;
	
	public void setMessageID(int ID) {
		
		this.ID = ID;
	}
	
	@Override
	public void setMessage(String message) {
		
		this.message = message;
	}

	@Override
	public void setSender(Employee employee) {
		
		this.sender = employee;
	}

	@Override
	public void setRecipient(Employee employee) {
		
		this.recipient = employee;
	}

	@Override
	public void getSentDateAndTime(LocalDateTime date) {
		
		this.sentDateAndTime = date;
	}

	@Override
	public void setIsRead(boolean isRead) {
		
		this.isRead = isRead;
	}

	public int getMessageID() {
		
		return this.ID;
	}
	
	@Override
	public String getMessage() {
		
		return this.message;
	}

	@Override
	public Employee getSender() {
		
		return this.sender;
	}

	@Override
	public Employee getRecipient() {
		
		return this.recipient;
	}

	@Override
	public LocalDateTime getSentDateAndTime() {
		
		return this.sentDateAndTime;
	}

	@Override
	public boolean isRead() {
		
		return this.isRead;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + (isRead ? 1231 : 1237);
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((sentDateAndTime == null) ? 0 : sentDateAndTime.hashCode());
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
		RequestMessage other = (RequestMessage) obj;
		if (ID != other.ID)
			return false;
		if (isRead != other.isRead)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (sentDateAndTime == null) {
			if (other.sentDateAndTime != null)
				return false;
		} else if (!sentDateAndTime.equals(other.sentDateAndTime))
			return false;
		return true;
	}

}
