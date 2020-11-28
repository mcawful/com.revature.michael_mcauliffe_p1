package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.RequestAttachment;

public class AttachmentDaoPostgres implements AttachmentDao<RequestAttachment> {

	@Override
	public int insertattachment(RequestAttachment attachment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateAttachment(RequestAttachment attachment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAttachment(RequestAttachment attachment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RequestAttachment selectAttachment(int attachmentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestAttachment> selectAllAttachment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestAttachment> selectAttachmentsByReport(String formID) {
		// TODO Auto-generated method stub
		return null;
	}

}
