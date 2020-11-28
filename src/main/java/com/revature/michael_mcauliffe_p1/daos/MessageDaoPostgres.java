package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.Message;

public class MessageDaoPostgres implements MessageDao<Message> {

	@Override
	public int insertMessage(Message message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateMessage(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMessage(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Message selectMessage(int messageID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> selectAllMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> selectMessagesByReceiver(int employeeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> selectMessagesByReport(String formID) {
		// TODO Auto-generated method stub
		return null;
	}

}
