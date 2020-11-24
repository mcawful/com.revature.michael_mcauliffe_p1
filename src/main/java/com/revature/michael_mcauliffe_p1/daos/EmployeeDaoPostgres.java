package com.revature.michael_mcauliffe_p1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.Employee;
import com.revature.michael_mcauliffe_p1.pojos.Manager;
import com.revature.michael_mcauliffe_p1.utils.ConnectionFactoryUtil;

public class EmployeeDaoPostgres implements EmployeeDao<Employee> {

	private Connection connection;
	
	public EmployeeDaoPostgres() throws SQLException {
		
		super();
		this.connection = ConnectionFactoryUtil.getInstance().getConnection();
	}
	
	@Override
	public int insertEmployee(Employee employee) {

		String sql = "insert into employee (job_title, first_name, last_name, address, city, state,"
				+ "postal_code, phone_number, email, reports_to, admin_level) values"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning *;";
		
		try (PreparedStatement ps = connection.prepareStatement(sql)){
			
			ps.setObject(1, employee.getJobTitle());
			ps.setObject(2, employee.getFirstName());
			ps.setObject(3, employee.getLastName());
			ps.setObject(4, employee.getAddress());
			ps.setObject(5, employee.getCity());
			ps.setObject(6, employee.getState());
			ps.setObject(7, employee.getPostalCode());
			ps.setObject(8, employee.getPhoneNumber());
			ps.setObject(9, employee.getEmail());
			ps.setObject(10, employee.getReportsTo());
			
			if(employee.getClass() == Manager.class) {
				
				Manager manager = (Manager) employee;
				
				ps.setObject(11, manager.getAdminLevel());
			}
			else {
				
				ps.setObject(11, -1);
			}
			
			ResultSet rs = ps.executeQuery();
			if(!rs.next()) return 0;
			
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

		String sql = "update employee set job_title = ?, first_name = ?, last_name = ?, address = ?,"
				+ "city = ?, state = ?, postal_code = ?, phone_number = ?, email = ?, reports_to = ?,"
				+ "admin_level = ? where employee_id = ? returning *;";
		
		try (PreparedStatement ps = connection.prepareStatement(sql)){
			
			ps.setObject(1, employee.getJobTitle());
			ps.setObject(2, employee.getFirstName());
			ps.setObject(3, employee.getLastName());
			ps.setObject(4, employee.getAddress());
			ps.setObject(5, employee.getCity());
			ps.setObject(6, employee.getState());
			ps.setObject(7, employee.getPostalCode());
			ps.setObject(8, employee.getPhoneNumber());
			ps.setObject(9, employee.getEmail());
			ps.setObject(10, employee.getReportsTo());
			
			if(employee.getClass() == Manager.class) {
				
				Manager manager = (Manager) employee;
				
				ps.setObject(11, manager.getAdminLevel());
			}
			else {
				
				ps.setObject(11, -1);
			}
			
			ps.setObject(12, employee.getEmployeeID());
			
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
	public boolean deleteEmployee(int employeeID) {

		String sql = "delete from employee where employee_id = ? returning *;";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setObject(1, employeeID);
			
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
	public Employee selectEmployee(int employeeID) {
		
		String sql = "select * from employee where employee_id = ?;";
		
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ps.setObject(1, employeeID);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next()) return null;
			
			Employee employee = new Employee();
			
			employee.setEmployeeID((Integer) rs.getObject("employee_id"));
			employee.setJobTitle((String) rs.getObject("job_title"));
			employee.setFirstName((String) rs.getObject("first_name"));
			employee.setLastName((String) rs.getObject("last_name"));
			employee.setAddress((String) rs.getObject("address"));
			employee.setCity((String) rs.getObject("city"));
			employee.setState((String) rs.getObject("state"));
			employee.setPostalCode((Integer) rs.getObject("postal_code"));
			employee.setPhoneNumber((String) rs.getObject("phone_number"));
			employee.setEmail((String) rs.getObject("email"));
			employee.setReportsTo((Integer) rs.getObject("reports_to"));
			
			if(employee.getClass() == Manager.class) {
				
				Manager manager = (Manager) employee;
				manager.setAdminLevel((Integer) rs.getObject("admin_level"));
				
				// TODO Add logging
				return manager;
			}
			
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
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employeeList = new ArrayList<>();
			while(rs.next()) {
				
				Employee employee = new Employee();
				
				employee.setEmployeeID((Integer) rs.getObject("employee_id"));
				employee.setJobTitle((String) rs.getObject("job_title"));
				employee.setFirstName((String) rs.getObject("first_name"));
				employee.setLastName((String) rs.getObject("last_name"));
				employee.setAddress((String) rs.getObject("address"));
				employee.setCity((String) rs.getObject("city"));
				employee.setState((String) rs.getObject("state"));
				employee.setPostalCode((Integer) rs.getObject("postal_code"));
				employee.setPhoneNumber((String) rs.getObject("phone_number"));
				employee.setEmail((String) rs.getObject("email"));
				employee.setReportsTo((Integer) rs.getObject("reports_to"));
				
				if(employee.getClass() == Manager.class) {
					
					Manager manager = (Manager) employee;
					manager.setAdminLevel((Integer) rs.getObject("admin_level"));
					
					// TODO Add logging
					employeeList.add(manager);
				}
				
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
