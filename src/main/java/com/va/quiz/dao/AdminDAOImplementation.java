package com.va.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.va.quiz.dto.Admin;
import com.va.quiz.utils.ConnectionManager;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class AdminDAOImplementation implements AdminDAO {
	Connection conn = ConnectionManager.getInstance().getConnection();

	@Override
	public Admin getAdmin(Admin admin) throws SQLException {
		String query = "SELECT * FROM quiz.admin WHERE name = ? AND pass = ?;";

		ResultSet result;

		try (PreparedStatement statement = conn.prepareStatement(query)){

			statement.setString(1, admin.getName());
			statement.setString(2, admin.getPass());

			result = statement.executeQuery();

			if (result.next()) {
				admin.setID(result.getInt("id"));
			} else {
				return null;
			}
		}

		return admin;
	}

	@Override
	public boolean addAdmin(Admin admin) throws SQLException {
		String query = "INSERT INTO quiz.admin (name, pass) VALUES (?, ?);";

		try (PreparedStatement statement = conn.prepareStatement(query)){

			statement.setString(1, admin.getName());
			statement.setString(2, admin.getPass());

			statement.executeUpdate();

			return true;
		}
	}
}