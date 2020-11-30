package com.revature.michael_mcauliffe_p1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.RequestMessage;
import com.revature.michael_mcauliffe_p1.utils.ConnectionFactoryUtil;

public class MessageDaoPostgres implements MessageDao<RequestMessage> {

	private Connection connection;

	public MessageDaoPostgres() throws SQLException {

		super();
		this.connection = ConnectionFactoryUtil.getInstance().getConnection();
	}

	@Override
	public boolean deleteMessage(int messageID) {

		String sql = "delete from message where message_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, messageID);
			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				return false;

			// TODO Add logging
			return true;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int insertMessage(RequestMessage message) {

		String sql = "insert into message (request_id, sender_id, receiver_id, send_timestamp, "
				+ " message_text, is_read) values (?, ?, ?, ?, ?, ?) " + "on conflict do nothing returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, message.getRequestID());
			ps.setObject(2, message.getSenderID());
			ps.setObject(3, message.getRecipientID());
			ps.setObject(4, message.getSentDateAndTime());
			ps.setObject(5, message.getMessage());
			ps.setObject(6, message.isRead());

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				return 0;
			// TODO Add logging
			return rs.getInt("message_id");

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<RequestMessage> selectAllMessages() {

		String sql = "select * from message;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			List<RequestMessage> messList = new ArrayList<>();

			while (rs.next()) {

				RequestMessage message = new RequestMessage();

				message.setIsRead((Boolean) rs.getObject("is_read"));
				message.setMessage((String) rs.getObject("message_text"));
				message.setMessageID((Integer) rs.getObject("message_id"));
				message.setRecipient((Integer) rs.getObject("receiver_id"));
				message.setRequestID((String) rs.getObject("request_id"));
				message.setSender((Integer) rs.getObject("sender_id"));
				message.setSentDateAndTime(rs.getTimestamp("send_timestamp").toLocalDateTime());

				messList.add(message);
			}

			// TODO: add logging
			return messList;

		} catch (SQLException e) {
			// TODO: add logging
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public RequestMessage selectMessage(int messageID) {
		String sql = "select * from message where message_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, messageID);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				return null;

			RequestMessage message = new RequestMessage();

			message.setIsRead((Boolean) rs.getObject("is_read"));
			message.setMessage((String) rs.getObject("message_text"));
			message.setMessageID((Integer) rs.getObject("message_id"));
			message.setRecipient((Integer) rs.getObject("receiver_id"));
			message.setRequestID((String) rs.getObject("request_id"));
			message.setSender((Integer) rs.getObject("sender_id"));
			message.setSentDateAndTime(rs.getTimestamp("send_timestamp").toLocalDateTime());

			return message;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<RequestMessage> selectMessagesByRecipient(int employeeID) {

		String sql = "select * from message where receiver_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employeeID);
			ResultSet rs = ps.executeQuery();

			List<RequestMessage> messList = new ArrayList<>();

			while (rs.next()) {

				RequestMessage message = new RequestMessage();

				message.setIsRead((Boolean) rs.getObject("is_read"));
				message.setMessage((String) rs.getObject("message_text"));
				message.setMessageID((Integer) rs.getObject("message_id"));
				message.setRecipient((Integer) rs.getObject("receiver_id"));
				message.setRequestID((String) rs.getObject("request_id"));
				message.setSender((Integer) rs.getObject("sender_id"));
				message.setSentDateAndTime(rs.getTimestamp("send_timestamp").toLocalDateTime());

				messList.add(message);
			}

			// TODO: add logging
			return messList;

		} catch (SQLException e) {
			// TODO: add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<RequestMessage> selectMessagesByRequest(String formID) {

		String sql = "select * from message where request_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, formID);
			ResultSet rs = ps.executeQuery();

			List<RequestMessage> messList = new ArrayList<>();

			while (rs.next()) {

				RequestMessage message = new RequestMessage();

				message.setIsRead((Boolean) rs.getObject("is_read"));
				message.setMessage((String) rs.getObject("message_text"));
				message.setMessageID((Integer) rs.getObject("message_id"));
				message.setRecipient((Integer) rs.getObject("receiver_id"));
				message.setRequestID((String) rs.getObject("request_id"));
				message.setSender((Integer) rs.getObject("sender_id"));
				message.setSentDateAndTime(rs.getTimestamp("send_timestamp").toLocalDateTime());

				messList.add(message);
			}

			// TODO: add logging
			return messList;

		} catch (SQLException e) {
			// TODO: add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean setMessageAsRead(int messageID) {

		String sql = "update message set is_read = true where message_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, messageID);

			ResultSet rs = ps.executeQuery();
			if (!rs.next())
				return false;

			// TODO Add logging
			return true;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateMessage(RequestMessage message) {

		String sql = "update message set request_id = ?, sender_id = ?, receiver_id = ?, "
				+ "send_timestamp = ?, message_text = ?, is_read = ? where message_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, message.getRequestID());
			ps.setObject(2, message.getSenderID());
			ps.setObject(3, message.getRecipientID());
			ps.setObject(4, message.getSentDateAndTime());
			ps.setObject(5, message.getMessage());
			ps.setObject(6, message.isRead());
			ps.setObject(7, message.getMessageID());

			ResultSet rs = ps.executeQuery();
			if (!rs.next())
				return false;

			// TODO Add logging
			return true;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}
	}

}
