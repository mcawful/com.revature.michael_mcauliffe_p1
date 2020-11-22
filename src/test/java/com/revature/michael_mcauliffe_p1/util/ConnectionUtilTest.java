package com.revature.michael_mcauliffe_p1.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p1.utils.ConnectionFactoryUtil;

public class ConnectionUtilTest {
	
	private static ConnectionFactoryUtil cu;
	private Connection connection;
	
	@BeforeClass
	public static void setUpBeforeClass() throws SQLException {
		
		cu = ConnectionFactoryUtil.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
		this.connection.close();
	}

	@Test
	public void connectionTest() throws SQLException {
		
		this.connection = cu.getConnection();
		assertFalse("Connection should be opened.", this.connection.isClosed());
	}
}
