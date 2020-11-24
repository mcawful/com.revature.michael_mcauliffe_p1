package com.revature.michael_mcauliffe_p1.pojos;

import java.io.File;

public class RequestAttachment implements Attachment {

	private int attachmentID;
	private String requestID, description;
	private File attachment;
	
	public RequestAttachment() {
		
		super();
		this.requestID = "";
		this.attachment = null;
		this.description = "";
		
	}

	public RequestAttachment(String requestID, File attachment, String description) {
		
		super();
		this.requestID = requestID;
		this.attachment = attachment;
		this.description = description;
	}

	@Override
	public File getAttachment() {
		
		return this.attachment;
	}

	@Override
	public String getAttachmentDescriptor() {
		
		return this.description;
	}

	public int getAttachmentID() {
		
		return attachmentID;
	}

	public String getRequestID() {
		
		return requestID;
	}

	@Override
	public void setAttachment(File attachment) {
		
		this.attachment = attachment;
	}

	@Override
	public void setAttachmentDescriptor(String description) {
		
		this.description = description;
	}

	public void setAttachmentID(int attachmentID) {
		
		this.attachmentID = attachmentID;
	}

	public void setRequestID(String requestID) {
		
		this.requestID = requestID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
		result = prime * result + attachmentID;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((requestID == null) ? 0 : requestID.hashCode());
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
		RequestAttachment other = (RequestAttachment) obj;
		if (attachment == null) {
			if (other.attachment != null)
				return false;
		} else if (!attachment.equals(other.attachment))
			return false;
		if (attachmentID != other.attachmentID)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (requestID == null) {
			if (other.requestID != null)
				return false;
		} else if (!requestID.equals(other.requestID))
			return false;
		return true;
	}

}
