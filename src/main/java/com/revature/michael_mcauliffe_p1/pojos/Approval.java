package com.revature.michael_mcauliffe_p1.pojos;

import java.time.LocalDateTime;

public interface Approval {

	public Boolean getFinalApproval();

	public LocalDateTime getFinalApprovalDateAndTime();

	public int getFinalApproverID();

	public Boolean getFirstApproval();

	public LocalDateTime getFirstApprovalDateAndTime();

	public int getFirstApproverID();

	public Boolean getSecondApproval();

	public LocalDateTime getSecondApprovalDateAndTime();

	public int getSecondApproverID();

	public void setFinalApproval(Boolean approval);

	public void setFinalApprovalDateAndTime(LocalDateTime date);

	public void setFinalApproverID(int ID);

	public void setFirstApproval(Boolean approval);

	public void setFirstApprovalDateAndTime(LocalDateTime date);

	public void setFirstApproverID(int ID);

	public void setSecondApproval(Boolean approval);

	public void setSecondApprovalDateAndTime(LocalDateTime date);

	public void setSecondApproverID(int ID);

}
