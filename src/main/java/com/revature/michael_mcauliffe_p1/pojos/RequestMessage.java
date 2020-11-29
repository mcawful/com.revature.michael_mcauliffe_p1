package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;

public class RequestMessage implements Message {

	int messageID;
	String message, requestID;

	int senderID, recipientID;
	LocalDateTime sentDateAndTime;
	boolean isRead;
	
	
	
	public RequestMessage() {
		super();
		this.requestID = "";
		this.message = "";
		this.senderID = -1;
		this.recipientID = -1;
		this.sentDateAndTime = null;
		this.isRead = false;
	}

	public RequestMessage(String requestID, String message, int senderID, int recipientID, LocalDateTime sentDateAndTime) {
		
		super();
		this.requestID = requestID;
		this.message = message;
		this.senderID = senderID;
		this.recipientID = recipientID;
		this.sentDateAndTime = sentDateAndTime;
		this.isRead = false;
	}

	@Override
	public String getMessage() {
		
		return this.message;
	}
	
	public int getMessageID() {
		
		return messageID;
	}
	
	@Override
	public int getRecipientID() {
		
		return this.recipientID;
	}
	
	public String getRequestID() {
		
		return this.requestID;
	}
	
	@Override
	public int getSenderID() {
		
		return this.senderID;
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
	public void setIsRead(boolean isRead) {
		
		this.isRead = isRead;
	}
	
	@Override
	public void setMessage(String message) {
		
		this.message = message;
	}
	
	public void setMessageID(int messageID) {
		
		this.messageID = messageID;
	}
	
	@Override
	public void setRecipient(int recipientID) {
		
		this.recipientID = recipientID;
	}
	
	public void setRequestID(String requestID) {
		
		this.requestID = requestID;
	}
	
	@Override
	public void setSender(int senderID) {
		
		this.senderID = senderID;
	}
	
	@Override
	public void setSentDateAndTime(LocalDateTime sentDateAndTime) {
		
		this.sentDateAndTime = sentDateAndTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isRead ? 1231 : 1237);
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + messageID;
		result = prime * result + recipientID;
		result = prime * result + ((requestID == null) ? 0 : requestID.hashCode());
		result = prime * result + senderID;
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
		if (isRead != other.isRead)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (messageID != other.messageID)
			return false;
		if (recipientID != other.recipientID)
			return false;
		if (requestID == null) {
			if (other.requestID != null)
				return false;
		} else if (!requestID.equals(other.requestID))
			return false;
		if (senderID != other.senderID)
			return false;
		if (sentDateAndTime == null) {
			if (other.sentDateAndTime != null)
				return false;
		} else if (!sentDateAndTime.equals(other.sentDateAndTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestMessage [messageID=" + messageID + ", message=" + message + ", requestID=" + requestID
				+ ", senderID=" + senderID + ", recipientID=" + recipientID + ", sentDateAndTime=" + sentDateAndTime
				+ ", isRead=" + isRead + "]";
	}
	
}
