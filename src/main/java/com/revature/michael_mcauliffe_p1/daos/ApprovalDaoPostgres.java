package com.revature.michael_mcauliffe_p1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.RequestApproval;
import com.revature.michael_mcauliffe_p1.utils.ConnectionFactoryUtil;

public class ApprovalDaoPostgres implements ApprovalDao<RequestApproval> {

	private Connection connection;

	public ApprovalDaoPostgres() throws SQLException {

		super();
		this.connection = ConnectionFactoryUtil.getInstance().getConnection();
	}

	@Override
	public int insertApproval(RequestApproval approval) {

		String sql = "insert into approval (request_id, first_approver_id, first_approval, first_approval_date, "
				+ "second_approver_id, second_approval, second_approval_date, final_approver_id, final_approval, "
				+ "final_approval_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) on conflict do nothing returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, approval.getRequestID());
			ps.setObject(2, approval.getFirstApproverID());
			ps.setObject(3, approval.getFirstApproval());
			ps.setObject(4, approval.getFirstApprovalDateAndTime());
			ps.setObject(5, approval.getSecondApproverID());
			ps.setObject(6, approval.getSecondApproval());
			ps.setObject(7, approval.getSecondApprovalDateAndTime());
			ps.setObject(8, approval.getFinalApproverID());
			ps.setObject(9, approval.getFinalApproval());
			ps.setObject(10, approval.getFinalApprovalDateAndTime());

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				// TODO Add logging
				return 0;
			}
			// TODO Add logging
			return rs.getInt("approval_id");

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updateApproval(RequestApproval approval) {

		String sql = "update approval set request_id = ?, first_approver_id  = ?, first_approval = ?, "
				+ "first_approval_date = ?, second_approver_id = ?, second_approval = ?, "
				+ "second_approval_date = ?, final_approver_id = ?, final_approval = ?, "
				+ "final_approval_date = ? where approval_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, approval.getRequestID());
			ps.setObject(2, approval.getFirstApproverID());
			ps.setObject(3, approval.getFirstApproval());
			ps.setObject(4, approval.getFirstApprovalDateAndTime());
			ps.setObject(5, approval.getSecondApproverID());
			ps.setObject(6, approval.getSecondApproval());
			ps.setObject(7, approval.getSecondApprovalDateAndTime());
			ps.setObject(8, approval.getFinalApproverID());
			ps.setObject(9, approval.getFinalApproval());
			ps.setObject(10, approval.getFinalApprovalDateAndTime());
			ps.setObject(11, approval.getApprovalID());

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
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
	public boolean deleteApproval(int approvalID) {

		String sql = "delete from approval where approval_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, approvalID);

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
	public RequestApproval selectApproval(int approvalID) {

		String sql = "select * from approval where approval_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, approvalID);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				return null;

			RequestApproval approval = new RequestApproval();

			approval.setApprovalID((Integer) rs.getObject("approval_id"));
			approval.setRequestID((String) rs.getObject("request_id"));
			approval.setFirstApproverID((Integer) rs.getObject("first_approver_id"));
			approval.setFirstApproval((Boolean) rs.getObject("first_approval"));
			if (rs.getTimestamp("first_approval_date") != null)
				approval.setFirstApprovalDateAndTime(rs.getTimestamp("first_approval_date").toLocalDateTime());
			approval.setSecondApproverID((Integer) rs.getObject("second_approver_id"));
			approval.setSecondApproval((Boolean) rs.getObject("second_approval"));
			if (rs.getTimestamp("second_approval_date") != null)
				approval.setSecondApprovalDateAndTime(rs.getTimestamp("second_approval_date").toLocalDateTime());
			approval.setFinalApproverID((Integer) rs.getObject("final_approver_id"));
			approval.setFinalApproval((Boolean) rs.getObject("final_approval"));
			if (rs.getTimestamp("final_approval_date") != null)
				approval.setFinalApprovalDateAndTime(rs.getTimestamp("final_approval_date").toLocalDateTime());

			// TODO Add logging
			return approval;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<RequestApproval> selectAllApprovals() {

		String sql = "select * from approval;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			List<RequestApproval> approvalList = new ArrayList<>();

			while (rs.next()) {

				RequestApproval approval = new RequestApproval();

				approval.setApprovalID((Integer) rs.getObject("approval_id"));
				approval.setRequestID((String) rs.getObject("request_id"));
				approval.setFirstApproverID((Integer) rs.getObject("first_approver_id"));
				approval.setFirstApproval((Boolean) rs.getObject("first_approval"));
				if (rs.getTimestamp("first_approval_date") != null)
					approval.setFirstApprovalDateAndTime(rs.getTimestamp("first_approval_date").toLocalDateTime());
				approval.setSecondApproverID((Integer) rs.getObject("second_approver_id"));
				approval.setSecondApproval((Boolean) rs.getObject("second_approval"));
				if (rs.getTimestamp("second_approval_date") != null)
					approval.setSecondApprovalDateAndTime(rs.getTimestamp("second_approval_date").toLocalDateTime());
				approval.setFinalApproverID((Integer) rs.getObject("final_approver_id"));
				approval.setFinalApproval((Boolean) rs.getObject("final_approval"));
				if (rs.getTimestamp("final_approval_date") != null)
					approval.setFinalApprovalDateAndTime(rs.getTimestamp("final_approval_date").toLocalDateTime());

				approvalList.add(approval);
			}

			// TODO Add logging
			return approvalList;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<RequestApproval> selectApprovalsByFirstApprover(int employeeID) {

		String sql = "select * from approval where first_approver_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employeeID);
			ResultSet rs = ps.executeQuery();

			List<RequestApproval> approvalList = new ArrayList<>();

			while (rs.next()) {

				RequestApproval approval = new RequestApproval();

				approval.setApprovalID((Integer) rs.getObject("approval_id"));
				approval.setRequestID((String) rs.getObject("request_id"));
				approval.setFirstApproverID((Integer) rs.getObject("first_approver_id"));
				approval.setFirstApproval((Boolean) rs.getObject("first_approval"));
				if (rs.getTimestamp("first_approval_date") != null)
					approval.setFirstApprovalDateAndTime(rs.getTimestamp("first_approval_date").toLocalDateTime());
				approval.setSecondApproverID((Integer) rs.getObject("second_approver_id"));
				approval.setSecondApproval((Boolean) rs.getObject("second_approval"));
				if (rs.getTimestamp("second_approval_date") != null)
					approval.setSecondApprovalDateAndTime(rs.getTimestamp("second_approval_date").toLocalDateTime());
				approval.setFinalApproverID((Integer) rs.getObject("final_approver_id"));
				approval.setFinalApproval((Boolean) rs.getObject("final_approval"));
				if (rs.getTimestamp("final_approval_date") != null)
					approval.setFinalApprovalDateAndTime(rs.getTimestamp("final_approval_date").toLocalDateTime());

				approvalList.add(approval);
			}

			// TODO Add logging
			return approvalList;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<RequestApproval> selectApprovalsBySecondApprover(int employeeID) {

		String sql = "select * from approval where second_approver_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employeeID);
			ResultSet rs = ps.executeQuery();

			List<RequestApproval> approvalList = new ArrayList<>();

			while (rs.next()) {

				RequestApproval approval = new RequestApproval();

				approval.setApprovalID((Integer) rs.getObject("approval_id"));
				approval.setRequestID((String) rs.getObject("request_id"));
				approval.setFirstApproverID((Integer) rs.getObject("first_approver_id"));
				approval.setFirstApproval((Boolean) rs.getObject("first_approval"));
				if (rs.getTimestamp("first_approval_date") != null)
					approval.setFirstApprovalDateAndTime(rs.getTimestamp("first_approval_date").toLocalDateTime());
				approval.setSecondApproverID((Integer) rs.getObject("second_approver_id"));
				approval.setSecondApproval((Boolean) rs.getObject("second_approval"));
				if (rs.getTimestamp("second_approval_date") != null)
					approval.setSecondApprovalDateAndTime(rs.getTimestamp("second_approval_date").toLocalDateTime());
				approval.setFinalApproverID((Integer) rs.getObject("final_approver_id"));
				approval.setFinalApproval((Boolean) rs.getObject("final_approval"));
				if (rs.getTimestamp("final_approval_date") != null)
					approval.setFinalApprovalDateAndTime(rs.getTimestamp("final_approval_date").toLocalDateTime());

				approvalList.add(approval);
			}

			// TODO Add logging
			return approvalList;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<RequestApproval> selectApprovalsByFinalApprover(int employeeID) {

		String sql = "select * from approval where final_approver_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employeeID);
			ResultSet rs = ps.executeQuery();

			List<RequestApproval> approvalList = new ArrayList<>();

			while (rs.next()) {

				RequestApproval approval = new RequestApproval();

				approval.setApprovalID((Integer) rs.getObject("approval_id"));
				approval.setRequestID((String) rs.getObject("request_id"));
				approval.setFirstApproverID((Integer) rs.getObject("first_approver_id"));
				approval.setFirstApproval((Boolean) rs.getObject("first_approval"));
				if (rs.getTimestamp("first_approval_date") != null)
					approval.setFirstApprovalDateAndTime(rs.getTimestamp("first_approval_date").toLocalDateTime());
				approval.setSecondApproverID((Integer) rs.getObject("second_approver_id"));
				approval.setSecondApproval((Boolean) rs.getObject("second_approval"));
				if (rs.getTimestamp("second_approval_date") != null)
					approval.setSecondApprovalDateAndTime(rs.getTimestamp("second_approval_date").toLocalDateTime());
				approval.setFinalApproverID((Integer) rs.getObject("final_approver_id"));
				approval.setFinalApproval((Boolean) rs.getObject("final_approval"));
				if (rs.getTimestamp("final_approval_date") != null)
					approval.setFinalApprovalDateAndTime(rs.getTimestamp("final_approval_date").toLocalDateTime());

				approvalList.add(approval);
			}

			// TODO Add logging
			return approvalList;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RequestApproval selectApprovalByRequest(String formID) {

		String sql = "select * from approval where request_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, formID);
			ResultSet rs = ps.executeQuery();

			RequestApproval approval = new RequestApproval();

			if (!rs.next())
				return null;

			approval.setApprovalID((Integer) rs.getObject("approval_id"));
			approval.setRequestID((String) rs.getObject("request_id"));
			approval.setFirstApproverID((Integer) rs.getObject("first_approver_id"));
			approval.setFirstApproval((Boolean) rs.getObject("first_approval"));
			if (rs.getTimestamp("first_approval_date") != null)
				approval.setFirstApprovalDateAndTime(rs.getTimestamp("first_approval_date").toLocalDateTime());
			approval.setSecondApproverID((Integer) rs.getObject("second_approver_id"));
			approval.setSecondApproval((Boolean) rs.getObject("second_approval"));
			if (rs.getTimestamp("second_approval_date") != null)
				approval.setSecondApprovalDateAndTime(rs.getTimestamp("second_approval_date").toLocalDateTime());
			approval.setFinalApproverID((Integer) rs.getObject("final_approver_id"));
			approval.setFinalApproval((Boolean) rs.getObject("final_approval"));
			if (rs.getTimestamp("final_approval_date") != null)
				approval.setFinalApprovalDateAndTime(rs.getTimestamp("final_approval_date").toLocalDateTime());

			// TODO Add logging
			return approval;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}

}
