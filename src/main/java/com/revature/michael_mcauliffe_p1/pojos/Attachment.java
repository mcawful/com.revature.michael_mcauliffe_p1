package com.revature.michael_mcauliffe_p1.pojos;

import java.io.File;

public interface Attachment {

	public void setAttachment(File attachment);
	
	public void setAttachmentDescriptor(String attachmentDescriptor);
	
	public File getAttachment();
	
	public String getAttachmentDescriptor();
	
}
