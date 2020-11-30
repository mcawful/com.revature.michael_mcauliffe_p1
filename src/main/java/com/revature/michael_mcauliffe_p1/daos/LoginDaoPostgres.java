package com.revature.michael_mcauliffe_p1.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.michael_mcauliffe_p1.pojos.Login;
import com.revature.michael_mcauliffe_p1.utils.ConnectionFactoryUtil;

public class LoginDaoPostgres implements LoginDao<Login> {

	private Connection connection;

	public LoginDaoPostgres() throws SQLException {

		super();
		this.connection = ConnectionFactoryUtil.getInstance().getConnection();
	}

	@Override
	public boolean checkIfUsernameExists(String username) {

		String sql = "select username from credential where username = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, username);

			if (ps.executeQuery().next()) {
				// TODO Add logging
				return true;
			}
			// TODO Add logging
			return false;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteLogin(int employeeID) {

		String sql = "delete from credential where employee_id = ? returning *;";

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
	public boolean insertLogin(Login login) {

		String sql = "insert into credential (employee_id, username, password) "
				+ "values (?, ?, ?) on conflict do nothing returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, login.getID());
			ps.setObject(2, login.getUsername());
			ps.setObject(3, login.getPassword());

			if (ps.executeQuery().next()) {
				// TODO Add logging
				return true;
			}
			// TODO Add logging
			return false;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Login selectLoginByID(int employeeID) {

		String sql = "select * from credential where employee_id = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, employeeID);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				return null;

			Login login = new Login();

			login.setID(rs.getInt("employee_id"));
			login.setUsername(rs.getString("username"));
			login.setPassword(rs.getString("password"));

			// TODO Add logging
			return login;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Login selectLoginByUsername(String username) {

		String sql = "select * from credential where username = ?;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, username);

			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				return null;

			Login login = new Login();

			login.setID(rs.getInt("employee_id"));
			login.setUsername(rs.getString("username"));
			login.setPassword(rs.getString("password"));

			// TODO Add logging
			return login;

		} catch (SQLException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Login> selectLoginList() {

		String sql = "select * from credential;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			List<Login> loginList = new ArrayList<>();

			while (rs.next()) {

				Login login = new Login();

				login.setID(rs.getInt("employee_id"));
				login.setUsername(rs.getString("username"));
				login.setPassword(rs.getString("password"));

				loginList.add(login);
			}

			// TODO: add logging
			return loginList;

		} catch (SQLException e) {
			// TODO: add logging
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateLogin(Login login) {

		String sql = "update credential set username = ?, password = ? where employee_id = ? returning *;";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setObject(1, login.getUsername());
			ps.setObject(2, login.getPassword());
			ps.setObject(3, login.getID());

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
