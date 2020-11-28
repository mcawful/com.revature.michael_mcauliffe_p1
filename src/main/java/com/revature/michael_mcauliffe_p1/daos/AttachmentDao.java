package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

public interface AttachmentDao<T> {

	public int insertattachment(T t);
	
	public boolean updateAttachment(T t);
	
	public boolean deleteAttachment(T t);
	
	public T selectAttachment(int ID);
	
	public List<T> selectAllAttachment();
	
	public List<T> selectAttachmentsByReport(String ID);
	
}
