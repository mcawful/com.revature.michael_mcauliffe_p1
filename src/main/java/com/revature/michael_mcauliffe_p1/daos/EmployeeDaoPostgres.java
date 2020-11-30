package com.revature.michael_mcauliffe_p1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.Department;
import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.JobTitle;
import com.revature.michael_mcauliffe_p1.utils.ConnectionFactoryUtil;

public class EmployeeDaoPostgres implements EmployeeDao<Employee> {

	private Connection connection;

	public EmployeeDaoPostgres() throws SQLException {

		super();
		this.connection = ConnectionFactoryUtil.getInstance().getConnection();
	}

	@Override
	public int insertEmployee(Employee employee) {

		String sql = "insert into employee (job_title, department, is_ben_co, first_name, last_name, address, city, state, "
				+ "postal_code, phone_number, email, reports_to, admin_level) values "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) on conflict do nothing returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employee.getJobTitle().name());
			ps.setObject(2, employee.getDepartment().name());
			ps.setObject(3, employee.isBenCo());
			ps.setObject(4, employee.getFirstName());
			ps.setObject(5, employee.getLastName());
			ps.setObject(6, employee.getAddress());
			ps.setObject(7, employee.getCity());
			ps.setObject(8, employee.getState());
			ps.setObject(9, employee.getPostalCode());
			ps.setObject(10, employee.getPhoneNumber());
			ps.setObject(11, employee.getEmail());
			ps.setObject(12, employee.getReportsTo());
			ps.setObject(13, employee.getAdminLevel());

			ResultSet rs = ps.executeQuery();
			if (!rs.next())
				return 0;

			// TODO Add logging
			return rs.getInt("employee_id");

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		String sql = "update employee set job_title = ?, department = ?, is_ben_co = ?,"
				+ "first_name = ?, last_name = ?, address = ?, city = ?, state = ?, postal_code = ?, "
				+ "phone_number = ?, email = ?, reports_to = ?, admin_level = ? "
				+ "where employee_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employee.getJobTitle().name());
			ps.setObject(2, employee.getDepartment().name());
			ps.setObject(3, employee.isBenCo());
			ps.setObject(4, employee.getFirstName());
			ps.setObject(5, employee.getLastName());
			ps.setObject(6, employee.getAddress());
			ps.setObject(7, employee.getCity());
			ps.setObject(8, employee.getState());
			ps.setObject(9, employee.getPostalCode());
			ps.setObject(10, employee.getPhoneNumber());
			ps.setObject(11, employee.getEmail());
			ps.setObject(12, employee.getReportsTo());
			ps.setObject(13, employee.getAdminLevel());
			ps.setObject(14, employee.getEmployeeID());

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
	public boolean deleteEmployee(int employeeID) {

		String sql = "delete from employee where employee_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employeeID);

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
	public Employee selectEmployee(int employeeID) {

		String sql = "select * from employee where employee_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employeeID);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				return null;

			Employee employee = new Employee();

			employee.setEmployeeID(rs.getInt("employee_id"));
			employee.setJobTitle(JobTitle.valueOf(rs.getString("job_title")));
			employee.setDepartment(Department.valueOf(rs.getString("department")));
			employee.setBenCo(rs.getBoolean("is_ben_co"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setAddress(rs.getString("address"));
			employee.setCity(rs.getString("city"));
			employee.setState(rs.getString("state"));
			employee.setPostalCode(rs.getString("postal_code"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			employee.setEmail(rs.getString("email"));
			employee.setReportsTo(rs.getInt("reports_to"));
			employee.setAdminLevel(rs.getInt("admin_level"));

			// TODO Add logging
			return employee;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Employee> selectEmployeeList() {

		String sql = "select * from employee;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			List<Employee> employeeList = new ArrayList<>();
			while (rs.next()) {

				Employee employee = new Employee();

				employee.setEmployeeID(rs.getInt("employee_id"));
				employee.setJobTitle(JobTitle.valueOf(rs.getString("job_title")));
				employee.setDepartment(Department.valueOf(rs.getString("department")));
				employee.setBenCo(rs.getBoolean("is_ben_co"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setAddress(rs.getString("address"));
				employee.setCity(rs.getString("city"));
				employee.setState(rs.getString("state"));
				employee.setPostalCode(rs.getString("postal_code"));
				employee.setPhoneNumber(rs.getString("phone_number"));
				employee.setEmail(rs.getString("email"));
				employee.setReportsTo(rs.getInt("reports_to"));
				employee.setAdminLevel(rs.getInt("admin_level"));

				// TODO Add logging
				employeeList.add(employee);
			}
			return employeeList;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

	}

}
