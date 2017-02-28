package com.va.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.va.quiz.dto.Score;
import com.va.quiz.dto.User;
import com.va.quiz.utils.ConnectionManager;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class ScoreDAOImplementation implements ScoreDAO {
	Connection conn = ConnectionManager.getInstance().getConnection();

	@Override
	public ArrayList<Score> getTopHundred() throws SQLException {
		String query = "SELECT score.user_id "
				+ ", score.id "
				+ ", score.result"
				+ ", user.name  "
				+ "FROM quiz.score "
				+ "INNER JOIN quiz.user "
				+ "ON quiz.score.user_id=quiz.user.id "
				+ "ORDER BY result DESC LIMIT 100;";

		ResultSet result;
		ArrayList<Score> list = new ArrayList<>();

		try (Statement statement = conn.createStatement()){

			result = statement.executeQuery(query);

			while(result.next()) {
				Score score = new Score(result.getInt("user_id"));
				score.setID(result.getInt("id"));
				score.setResult(result.getInt("result"));
				score.setName(result.getString("name"));

				list.add(score);
			}
		}

		return list;
	}

	@Override
	public ArrayList<Score> getScores(User user)  throws SQLException{
		String query = "SELECT score.user_id "
				+ ", score.id "
				+ ", score.result"
				+ ", user.name  "
				+ "FROM quiz.score "
				+ "INNER JOIN quiz.user "
				+ "ON quiz.score.user_id=quiz.user.id "
				+ "WHERE user_id = ? "
				+ "ORDER BY result DESC LIMIT 100;";

		ResultSet result;
		ArrayList<Score> list = new ArrayList<>();

		try (PreparedStatement statement = conn.prepareStatement(query)){

			statement.setInt(1, user.getID());

			result = statement.executeQuery();

			while(result.next()) {
				Score score = new Score(user.getID());
				score.setID(result.getInt("id"));
				score.setResult(result.getInt("result"));
				score.setName(result.getString("name"));

				list.add(score);
			}
		}

		return list;
	}

	@Override
	public boolean addScore(Score score) throws SQLException {
		String query = "INSERT INTO quiz.score "
				+ "(user_id, result) "
				+ "VALUES (?, ?);";

		try (PreparedStatement statement = conn.prepareStatement(query)){

			statement.setInt(1, score.getUserID());
			statement.setInt(2, score.getResult());

			statement.executeUpdate();

			return true;
		}
	}
}