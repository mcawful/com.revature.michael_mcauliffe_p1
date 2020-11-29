package com.revature.michael_mcauliffe_p1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.RequestAttachment;
import com.revature.michael_mcauliffe_p1.utils.ConnectionFactoryUtil;

public class AttachmentDaoPostgres implements AttachmentDao<RequestAttachment> {

	private Connection connection;
	
	public AttachmentDaoPostgres() throws SQLException {
		
		super();
		this.connection = ConnectionFactoryUtil.getInstance().getConnection();
	}
	
	@Override
	public int insertAttachment(RequestAttachment attachment) {

		String sql = "insert into attachment (request_id, file, description) "
				+ "values (?, ?, ?) on conflict do nothing returning *;";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setObject(1, attachment.getRequestID());
			ps.setObject(2, attachment.getFile());
			ps.setObject(3, attachment.getDescription());
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next()) {
				// TODO Add logging
				return 0;
			}
			// TODO Add logging
			return rs.getInt("attachment_id");
			
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updateAttachment(RequestAttachment attachment) {
		
		String sql = "update attachment set request_id = ?, file = ?, description = ? "
				+ "where attachment_id = ? returning *;";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setObject(1, attachment.getRequestID());
			ps.setObject(2, attachment.getFile());
			ps.setObject(3, attachment.getDescription());
			ps.setObject(4, attachment.getAttachmentID());
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next()) {
				// TODO Add logging
				return false;
			}
			// TODO Add logging
			return true;
			
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteAttachment(int attachmentID) {

		String sql = "delete from attachment where attachment_id = ? returning *;";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setObject(1, attachmentID);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next()) return false;
			
			// TODO Add logging
			return true;
			
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public RequestAttachment selectAttachment(int attachmentID) {

		String sql = "select * from attachment where attachment_id = ?;";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setObject(1, attachmentID);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next()) return null;
			
			RequestAttachment attachment = new RequestAttachment();
			
			attachment.setAttachmentID((Integer) rs.getObject("attachment_id"));
			attachment.setRequestID((String) rs.getObject("request_id"));
			attachment.setFile(rs.getBytes("file"));
			attachment.setDescription((String) rs.getObject("description"));
			
			// TODO Add logging
			return attachment;
			
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<RequestAttachment> selectAllAttachments() {

		String sql = "select * from attachment;";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ResultSet rs = ps.executeQuery();
			
			List<RequestAttachment> attachList = new ArrayList<>();
			
			while(rs.next()) {
				
				RequestAttachment attachment = new RequestAttachment();
				
				attachment.setAttachmentID((Integer) rs.getObject("attachment_id"));
				attachment.setRequestID((String) rs.getObject("request_id"));
				attachment.setFile(rs.getBytes("file"));
				attachment.setDescription((String) rs.getObject("description"));
				
				attachList.add(attachment);
			}

			// TODO Add logging
			return attachList;
			
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<RequestAttachment> selectAttachmentsByRequest(String formID) {

String sql = "select * from attachment where request_id = ?;";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setObject(1, formID);
			
			ResultSet rs = ps.executeQuery();
			
			List<RequestAttachment> attachList = new ArrayList<>();
			
			while(rs.next()) {
				
				RequestAttachment attachment = new RequestAttachment();
				
				attachment.setAttachmentID((Integer) rs.getObject("attachment_id"));
				attachment.setRequestID((String) rs.getObject("request_id"));
				attachment.setFile(rs.getBytes("file"));
				attachment.setDescription((String) rs.getObject("description"));
				
				attachList.add(attachment);
			}

			// TODO Add logging
			return attachList;
			
		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}
}
