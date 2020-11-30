package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

public interface MessageDao<T> {

	public int insertMessage(T t);

	public boolean updateMessage(T t);

	public boolean setMessageAsRead(int ID);

	public boolean deleteMessage(int messadeID);

	public T selectMessage(int ID);

	public List<T> selectAllMessages();

	public List<T> selectMessagesByRecipient(int ID);

	public List<T> selectMessagesByRequest(String ID);
}
