package com.va.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.va.quiz.dto.Question;
import com.va.quiz.utils.ConnectionManager;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class QuestionDAOImplementation implements QuestionDAO {
	Connection conn = ConnectionManager.getInstance().getConnection();

	@Override
	public ArrayList<Question> getAllQuestions() throws SQLException {
		String query = "SELECT * FROM quiz.question;";

		ResultSet result;
		ArrayList<Question> list = new ArrayList<>();

		try (Statement statement = conn.createStatement()){

			result = statement.executeQuery(query);

			while(result.next()) {
				Question question = new Question(result.getInt("editor"));
				question.setID(result.getInt("id"));
				question.setContent(result.getString("content"));
				question.setPoints(result.getInt("points"));
				question.setSolution(result.getString("solution"));

				list.add(question);
			}
		}

		return list;
	}

	@Override
	public boolean addQuestion(Question question) throws SQLException{
		String query = "INSERT INTO quiz.question "
				+ "(editor, content, solution, points) "
				+ "VALUES (?, ?, ?, ?);";

		try (PreparedStatement statement = conn.prepareStatement(query)){

			statement.setInt(1, question.getEditor());
			statement.setString(2, question.getContent());
			statement.setString(3, question.getSolution());
			statement.setInt(4, question.getPoints());

			statement.executeUpdate();

			return true;
		}
	}

	@Override
	public boolean updateQuestion(Question question) throws SQLException{
		String query = "Update quiz.question "
				+ "SET editor = ?, "
				+ "content = ?, "
				+ "solution = ?, "
				+ "points = ? "
				+ "WHERE id = ?;";

		try (PreparedStatement statement = conn.prepareStatement(query)){

			statement.setInt(1, question.getEditor());
			statement.setString(2, question.getContent());
			statement.setString(3, question.getSolution());
			statement.setInt(4, question.getPoints());
			statement.setInt(5, question.getID());

			statement.executeUpdate();

			return true;
		}
	}
}