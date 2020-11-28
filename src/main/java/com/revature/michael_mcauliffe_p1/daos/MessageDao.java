package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

public interface MessageDao<T> {

	public int insertMessage(T t);
	
	public boolean updateMessage(T t);
	
	public boolean deleteMessage(T t);
	
	public T selectMessage(int ID);
	
	public List<T> selectAllMessages();
	
	public List<T> selectMessagesByReceiver(int ID);
	
	public List<T> selectMessagesByReport(String ID);
}
