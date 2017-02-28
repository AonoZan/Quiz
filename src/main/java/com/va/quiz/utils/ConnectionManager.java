package com.va.quiz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class ConnectionManager {

	private static ConnectionManager instance;
	private Connection connection;
	private static final String PROPERTIES_FILE = "db_setup.properties";
	private static PropertiesLoader properties = new PropertiesLoader(PROPERTIES_FILE);
	
	private ConnectionManager(){
	}

	public static ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	public boolean openConnection() {
		try {
			connection = DriverManager.getConnection(
					properties.getProperty("db_conn_string", false),
					properties.getProperty("db_user_name", false),
					properties.getProperty("db_user_pass", false)
					);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Connection getConnection() {
		if(connection == null) {
			if (openConnection()) {
				return connection;
			} else {
				System.out.println("Connection can't be extablished.");
				return null;
			}
		}
		return connection;
	}

	public static String getProperty(String property, boolean mustProvide) {
		return properties.getProperty(property, mustProvide);
	}
}