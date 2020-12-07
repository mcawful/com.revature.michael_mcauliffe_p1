package com.revature.michael_mcauliffe_p1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.michael_mcauliffe_p1.dtos.RequestDto;
import com.revature.michael_mcauliffe_p1.pojos.EventType;
import com.revature.michael_mcauliffe_p1.pojos.GradeFormat;
import com.revature.michael_mcauliffe_p1.pojos.Request;
import com.revature.michael_mcauliffe_p1.utils.ConnectionFactoryUtil;

public class RequestDaoPostgres implements RequestDao<Request> {

	private Connection connection;

	public RequestDaoPostgres() throws SQLException {

		super();
		this.connection = ConnectionFactoryUtil.getInstance().getConnection();
	}

	@Override
	public boolean completeRequest(String formID) {

		String sql = "update request set is_complete = true where request_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, formID);

			ResultSet rs = ps.executeQuery();
			// TODO Add logging
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
	public boolean deleteRequest(String formID) {

		String sql = "delete from request where request_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, formID);

			ResultSet rs = ps.executeQuery();

			// TODO Add logging
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
	public boolean insertGrade(String formID, byte[] grade) {

		String sql = "update request set grade = ? where request_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, grade);
			ps.setObject(2, formID);

			ResultSet rs = ps.executeQuery();
			// TODO Add logging
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
	public boolean insertRequest(Request request) {

		String sql = "insert into request (request_id, employee_id, is_urgent, description, event_type, "
				+ "location, cost, reimbursement, request_date, event_date_start, event_date_end, grade_format, "
				+ "grade_format_other, passing_grade_other, grade, is_passing, is_complete) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) on conflict do nothing returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, request.getFormID());
			ps.setObject(2, request.getEmployeeID());
			ps.setObject(3, request.isUrgent());
			ps.setObject(4, request.getDescription());
			ps.setObject(5, request.getEventType().name());
			ps.setObject(6, request.getLocation());
			ps.setObject(7, request.getCost());
			ps.setObject(8, request.getReimbursement());
			ps.setObject(9, request.getPostingDateAndTime());
			ps.setObject(10, request.getEventDateStart());
			ps.setObject(11, request.getEventDateEnd());
			ps.setObject(12, request.getGradeFormat().name());
			ps.setObject(13, request.getOtherGradeFormat());
			ps.setObject(14, request.getPassingGradeOther());
			ps.setObject(15, request.getGrade());
			ps.setObject(16, request.isPassing());
			ps.setObject(17, request.isComplete());

			ResultSet rs = ps.executeQuery();
			// TODO Add logging
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
	public List<Request> selectAllRequests() {

		String sql = "select * from request;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			List<Request> requestList = new ArrayList<>();
			while (rs.next()) {

				Request request = new Request();

				request.setFormID((String) rs.getObject("request_id"));
				request.setCost(rs.getDouble("cost"));
				request.setDecription((String) rs.getObject("description"));
				request.setEmployeeID((Integer) rs.getObject("employee_id"));
				request.setEventDateStart(rs.getTimestamp("event_date_start").toLocalDateTime());
				request.setEventType(EventType.valueOf(rs.getObject("event_type").toString()));
				request.setGrade(rs.getBytes("grade"));
				request.setGradeFormat(GradeFormat.valueOf(rs.getObject("grade_format").toString()));
				request.setIsComplete((Boolean) rs.getObject("is_complete"));
				request.setIsPassing((Boolean) rs.getObject("is_passing"));
				request.setIsUrgent((Boolean) rs.getObject("is_urgent"));
				request.setLocalDateEnd(rs.getTimestamp("event_date_end").toLocalDateTime());
				request.setLocation((String) rs.getObject("location"));
				request.setOtherGradeFormat((String) rs.getObject("grade_format_other"));
				request.setPassingGradeOther((String) rs.getObject("passing_grade_other"));
				request.setPostingDateAndTime(rs.getTimestamp("request_date").toLocalDateTime());
				request.setReimbursement(rs.getDouble("reimbursement"));

				// TODO Add logging
				requestList.add(request);
			}
			return requestList;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Request selectRequest(String formID) {

		String sql = "select * from request where request_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, formID);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				return null;

			Request request = new Request();

			request.setFormID((String) rs.getObject("request_id"));
			request.setCost(rs.getDouble("cost"));
			request.setDecription((String) rs.getObject("description"));
			request.setEmployeeID((Integer) rs.getObject("employee_id"));
			request.setEventDateStart(rs.getTimestamp("event_date_start").toLocalDateTime());
			request.setEventType(EventType.valueOf(rs.getObject("event_type").toString()));
			request.setGrade(rs.getBytes("grade"));
			request.setGradeFormat(GradeFormat.valueOf(rs.getObject("grade_format").toString()));
			request.setIsComplete((Boolean) rs.getObject("is_complete"));
			request.setIsPassing((Boolean) rs.getObject("is_passing"));
			request.setIsUrgent((Boolean) rs.getObject("is_urgent"));
			request.setLocalDateEnd(rs.getTimestamp("event_date_end").toLocalDateTime());
			request.setLocation((String) rs.getObject("location"));
			request.setOtherGradeFormat((String) rs.getObject("grade_format_other"));
			request.setPassingGradeOther((String) rs.getObject("passing_grade_other"));
			request.setPostingDateAndTime(rs.getTimestamp("request_date").toLocalDateTime());
			request.setReimbursement(rs.getDouble("reimbursement"));

			return request;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<RequestDto> selectRequestsByRequester(int employeeID) {

		String sql = "select * from request where employee_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employeeID);
			ResultSet rs = ps.executeQuery();

			List<RequestDto> requestList = new ArrayList<>();
			while (rs.next()) {

				Request request = new Request();

				request.setFormID((String) rs.getObject("request_id"));
				request.setCost(rs.getDouble("cost"));
				request.setDecription((String) rs.getObject("description"));
				request.setEmployeeID((Integer) rs.getObject("employee_id"));
				request.setEventDateStart(rs.getTimestamp("event_date_start").toLocalDateTime());
				request.setEventType(EventType.valueOf(rs.getObject("event_type").toString()));
				request.setGrade(rs.getBytes("grade"));
				request.setGradeFormat(GradeFormat.valueOf(rs.getObject("grade_format").toString()));
				request.setIsComplete((Boolean) rs.getObject("is_complete"));
				request.setIsPassing((Boolean) rs.getObject("is_passing"));
				request.setIsUrgent((Boolean) rs.getObject("is_urgent"));
				request.setLocalDateEnd(rs.getTimestamp("event_date_end").toLocalDateTime());
				request.setLocation((String) rs.getObject("location"));
				request.setOtherGradeFormat((String) rs.getObject("grade_format_other"));
				request.setPassingGradeOther((String) rs.getObject("passing_grade_other"));
				request.setPostingDateAndTime(rs.getTimestamp("request_date").toLocalDateTime());
				request.setReimbursement(rs.getDouble("reimbursement"));

				// TODO Add logging
				RequestDto requestDto = new RequestDto(request);
				requestList.add(requestDto);
			}
			return requestList;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean setPassOrFail(String formID, boolean isPassing) {

		String sql = "update request set is_passing = ? where request_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, isPassing);
			ps.setObject(2, formID);

			ResultSet rs = ps.executeQuery();
			// TODO Add logging
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
	public boolean updateRequest(Request request) {

		String sql = "update request set employee_id = ?, is_urgent = ?, description = ?, "
				+ "event_type = ?, location = ?, cost = ?, reimbursement = ?, request_date = ?, "
				+ "event_date_start = ?, event_date_end = ?, grade_format = ?, grade_format_other = ?, "
				+ "passing_grade_other = ?, grade = ?, is_passing = ?, is_complete = ? "
				+ "where request_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, request.getEmployeeID());
			ps.setObject(2, request.isUrgent());
			ps.setObject(3, request.getDescription());
			ps.setObject(4, request.getEventType().name());
			ps.setObject(5, request.getLocation());
			ps.setObject(6, request.getCost());
			ps.setObject(7, request.getReimbursement());
			ps.setObject(8, request.getPostingDateAndTime());
			ps.setObject(9, request.getEventDateStart());
			ps.setObject(10, request.getEventDateEnd());
			ps.setObject(11, request.getGradeFormat().name());
			ps.setObject(12, request.getOtherGradeFormat());
			ps.setObject(13, request.getPassingGradeOther());
			ps.setObject(14, request.getGrade());
			ps.setObject(15, request.isPassing());
			ps.setObject(16, request.isComplete());
			ps.setObject(17, request.getFormID());

			ResultSet rs = ps.executeQuery();
			// TODO Add logging
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
