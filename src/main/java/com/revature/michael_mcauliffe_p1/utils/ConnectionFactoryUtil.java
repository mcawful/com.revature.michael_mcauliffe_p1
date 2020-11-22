package com.revature.michael_mcauliffe_p1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryUtil {

    private static ConnectionFactoryUtil instance;
    private Connection connection;
    
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Link6453";

    private ConnectionFactoryUtil() throws SQLException {
        
    	super();
    	try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            // TODO: add logging
        	System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
    	
        return connection;
    }

    public static ConnectionFactoryUtil getInstance() throws SQLException {
    	
        if (instance == null) {
        	
            instance = new ConnectionFactoryUtil();
            
        } else if (instance.getConnection().isClosed()) {
        	
            instance = new ConnectionFactoryUtil();
        }
        return instance;
    }
}