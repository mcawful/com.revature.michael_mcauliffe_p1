package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;

public class RequestApprover implements Approver {

	private int approvalID, firstApproverID, secondApproverID, finalApproverID;
	private String requestID;
	private LocalDateTime firstApprovalDateAndTime, secondApprovalDateAndTime, finalApprovalDateAndTime;
	private Boolean firstApproval, secondApproval, finalApproval;
	
	public RequestApprover() {
		super();
		this.firstApproverID = -1;
		this.secondApproverID = -1;
		this.finalApproverID = -1;
		this.requestID = "";
		this.approvalID = -1;
		this.firstApprovalDateAndTime = null;
		this.secondApprovalDateAndTime = null;
		this.finalApprovalDateAndTime = null;
		this.firstApproval = null;
		this.secondApproval = null;
		this.finalApproval = null;
	}

	public RequestApprover(int firstApproverID, int secondApproverID, int finalApproverID, String requestID) {
		
		super();
		this.firstApproverID = firstApproverID;
		this.secondApproverID = secondApproverID;
		this.finalApproverID = finalApproverID;
		this.requestID = requestID;
	}

	public int getApprovalID() {
		
		return this.approvalID;
	}
	
	@Override
	public Boolean getFinalApproval() {
		
		return this.finalApproval;
	}
	
	@Override
	public LocalDateTime getFinalApprovalDateAndTime() {
		
		return this.finalApprovalDateAndTime;
	}
	
	@Override
	public int getFinalApproverID() {
		
		return this.finalApproverID;
	}
	
	@Override
	public Boolean getFirstApproval() {
		
		return this.firstApproval;
	}
	
	@Override
	public LocalDateTime getFirstApprovalDateAndTime() {
		
		return this.firstApprovalDateAndTime;
	}
	
	@Override
	public int getFirstApproverID() {
		
		return this.firstApproverID;
	}
	
	public String getRequestID() {
		
		return this.requestID;
	}
	
	@Override
	public Boolean getSecondApproval() {
		
		return this.secondApproval;
	}
	
	@Override
	public LocalDateTime getSecondApprovalDateAndTime() {
		
		return this.secondApprovalDateAndTime;
	}
	
	@Override
	public int getSecondApproverID() {
		
		return this.secondApproverID;
	}
	
	public void setApprovalID(int approvalID ) {
		
		this.approvalID = approvalID;
	}
	
	@Override
	public void setFinalApproval(Boolean finalApproval) {
		
		this.finalApproval = finalApproval;
	}
	
	@Override
	public void setFinalApprovalDateAndTime(LocalDateTime finalApprovalDateAndTime) {
		
		this.finalApprovalDateAndTime = finalApprovalDateAndTime;
	}
	
	@Override
	public void setFinalApproverID(int finalApproverID) {
		
		this.finalApproverID = finalApproverID;
	}
	
	@Override
	public void setFirstApproval(Boolean firstApproval) {
		
		this.firstApproval = firstApproval;
	}

	@Override
	public void setFirstApprovalDateAndTime(LocalDateTime firstApprovalDateAndTime) {
		
		this.firstApprovalDateAndTime = firstApprovalDateAndTime;
	}

	@Override
	public void setFirstApproverID(int firstApproverID) {
		
		this.firstApproverID = firstApproverID;
	}

	public void setRequestID(String requestID) {
		
		this.requestID = requestID;
	}

	@Override
	public void setSecondApproval(Boolean secondApproval) {
		
		this.secondApproval = secondApproval;
	}

	@Override
	public void setSecondApprovalDateAndTime(LocalDateTime secondApprovalDateAndTime) {
		
		this.secondApprovalDateAndTime = secondApprovalDateAndTime;
	}

	@Override
	public void setSecondApproverID(int secondApproverID) {
		
		this.secondApproverID = secondApproverID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + approvalID;
		result = prime * result + ((finalApproval == null) ? 0 : finalApproval.hashCode());
		result = prime * result + ((finalApprovalDateAndTime == null) ? 0 : finalApprovalDateAndTime.hashCode());
		result = prime * result + finalApproverID;
		result = prime * result + ((firstApproval == null) ? 0 : firstApproval.hashCode());
		result = prime * result + ((firstApprovalDateAndTime == null) ? 0 : firstApprovalDateAndTime.hashCode());
		result = prime * result + firstApproverID;
		result = prime * result + ((requestID == null) ? 0 : requestID.hashCode());
		result = prime * result + ((secondApproval == null) ? 0 : secondApproval.hashCode());
		result = prime * result + ((secondApprovalDateAndTime == null) ? 0 : secondApprovalDateAndTime.hashCode());
		result = prime * result + secondApproverID;
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
		RequestApprover other = (RequestApprover) obj;
		if (approvalID != other.approvalID)
			return false;
		if (finalApproval == null) {
			if (other.finalApproval != null)
				return false;
		} else if (!finalApproval.equals(other.finalApproval))
			return false;
		if (finalApprovalDateAndTime == null) {
			if (other.finalApprovalDateAndTime != null)
				return false;
		} else if (!finalApprovalDateAndTime.equals(other.finalApprovalDateAndTime))
			return false;
		if (finalApproverID != other.finalApproverID)
			return false;
		if (firstApproval == null) {
			if (other.firstApproval != null)
				return false;
		} else if (!firstApproval.equals(other.firstApproval))
			return false;
		if (firstApprovalDateAndTime == null) {
			if (other.firstApprovalDateAndTime != null)
				return false;
		} else if (!firstApprovalDateAndTime.equals(other.firstApprovalDateAndTime))
			return false;
		if (firstApproverID != other.firstApproverID)
			return false;
		if (requestID == null) {
			if (other.requestID != null)
				return false;
		} else if (!requestID.equals(other.requestID))
			return false;
		if (secondApproval == null) {
			if (other.secondApproval != null)
				return false;
		} else if (!secondApproval.equals(other.secondApproval))
			return false;
		if (secondApprovalDateAndTime == null) {
			if (other.secondApprovalDateAndTime != null)
				return false;
		} else if (!secondApprovalDateAndTime.equals(other.secondApprovalDateAndTime))
			return false;
		if (secondApproverID != other.secondApproverID)
			return false;
		return true;
	}
	
}
