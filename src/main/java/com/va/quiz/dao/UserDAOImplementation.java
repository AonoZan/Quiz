package com.va.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.va.quiz.dto.User;
import com.va.quiz.utils.ConnectionManager;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class UserDAOImplementation implements UserDAO {
	Connection conn = ConnectionManager.getInstance().getConnection();

	@Override
	public User getUser(User user)  throws SQLException{
		String query = "SELECT * FROM quiz.user WHERE name = ? AND pass = ?;";

		ResultSet result;

		try (PreparedStatement statement = conn.prepareStatement(query)){

			statement.setString(1, user.getName());
			statement.setString(2, user.getPass());

			result = statement.executeQuery();

			if (result.next()) {
				user.setID(result.getInt("id"));
			} else {
				return null;
			}
		}

		return user;
	}

	@Override
	public boolean addUser(User user)  throws SQLException{
		String query = "INSERT INTO quiz.user (name, pass) VALUES (?, ?);";

		try (PreparedStatement statement = conn.prepareStatement(query)){

			statement.setString(1, user.getName());
			statement.setString(2, user.getPass());

			statement.executeUpdate();

			return true;
		}
	}

	@Override
	public boolean deleteUser(User user)  throws SQLException{
		String query = "DELETE FROM quiz.user WHERE name = ? AND pass = ?;";

		try (PreparedStatement statement = conn.prepareStatement(query)){

			statement.setString(1, user.getName());
			statement.setString(2, user.getPass());

			statement.executeUpdate();

			return true;
		}
	}
}