package com.va.quiz.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author AonoZan Dejan Petrovic 2017 ©
 */
public class Setup {
	Connection conn;

	public void check() {
		if (!canConnect()) {
			System.out.println("\nPlease edit 'db_setup.properties' file"
					+ "\nand provide correct database credentials."
					+ "\nAlso check if MySQL server is running.");
			System.exit(0);
		} else if (!databaseExists()) {
			System.out.println("Database doesnt exists.");
			System.out.println("Atempting setup.");
			if (!createDatabase()) {
				System.out.println("Cant create database.");
				System.exit(0);
			}
			System.out.println("Sucessful!");
		}
	}
	
	private boolean canConnect() {
		conn = ConnectionManager.getInstance().getConnection();
		if (conn == null) {
			return false;
		}
		return true;
	}
	private boolean databaseExists() {
		try (Statement statement = conn.createStatement()){
			statement.executeQuery("SELECT * FROM quiz.admin;");
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	private boolean createDatabase() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream sqlFile = classLoader.getResourceAsStream("setup_query.sql");
		
		Scanner s = new Scanner(sqlFile);
		s.useDelimiter(";");
		
		boolean finished = true;
		while(s.hasNext()) {
			try (Statement statement = conn.createStatement()){
				String query = s.next() + ";";
				statement.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("There were error durning execution.");
				finished = false;
				break;
			}
		}
		s.close();
		return finished;
	}
}