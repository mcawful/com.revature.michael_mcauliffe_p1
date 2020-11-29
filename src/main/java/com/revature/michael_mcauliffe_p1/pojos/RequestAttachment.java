package com.revature.michael_mcauliffe_p1.pojos;

public class RequestAttachment implements Attachment {

	private int attachmentID;
	private String requestID, description;
	private byte[] file;
	
	public RequestAttachment() {
		
		super();
		this.requestID = "";
		this.file = null;
		this.description = "";
		
	}

	public RequestAttachment(String requestID, byte[] file, String description) {
		
		super();
		this.requestID = requestID;
		this.file = file;
		this.description = description;
	}

	@Override
	public byte[] getFile() {
		
		return this.file;
	}

	@Override
	public String getDescription() {
		
		return this.description;
	}

	public int getAttachmentID() {
		
		return attachmentID;
	}

	public String getRequestID() {
		
		return requestID;
	}

	@Override
	public void setFile(byte[] file) {
		
		this.file = file;
	}

	@Override
	public void setDescription(String description) {
		
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

	@Override
	public String toString() {
		return "RequestAttachment [attachmentID=" + attachmentID + ", requestID=" + requestID + ", description="
				+ description + "]";
	}

}
