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
	public void getSentDateAndTime(LocalDateTime sentDateAndTime) {
		
		this.sentDateAndTime = sentDateAndTime;
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
	
}
