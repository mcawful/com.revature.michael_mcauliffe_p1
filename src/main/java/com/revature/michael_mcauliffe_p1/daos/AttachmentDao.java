package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

public interface AttachmentDao<T> {

	public int insertAttachment(T t);
	
	public boolean updateAttachment(T t);
	
	public boolean deleteAttachment(int ID);
	
	public T selectAttachment(int ID);
	
	public List<T> selectAllAttachments();
	
	public List<T> selectAttachmentsByRequest(String ID);
	
}
