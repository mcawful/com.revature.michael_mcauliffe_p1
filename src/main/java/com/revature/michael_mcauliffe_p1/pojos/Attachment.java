package com.revature.michael_mcauliffe_p1.pojos;

public interface Attachment {

	public void setFile(byte[] file);

	public void setDescription(String attachmentDescriptor);

	public byte[] getFile();

	public String getDescription();

}
