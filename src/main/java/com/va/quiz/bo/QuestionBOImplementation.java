package com.va.quiz.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.va.quiz.App;
import com.va.quiz.dao.QuestionDAO;
import com.va.quiz.dto.Question;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class QuestionBOImplementation implements QuestionBO {
	private QuestionDAO dao;
	ArrayList<Question> list = new ArrayList<>();

	@Override
	public ArrayList<Question> getAllQuestions() {
		try {
			list = dao.getAllQuestions();
		} catch (SQLException e) {
			App.close(e.getMessage());
		}
		return list;
	}

	@Override
	public boolean addQuestion(Question question) {
		if (!isValidQuestion(question)) return false;

		boolean result = false;
		try {
			result = dao.addQuestion(question);
		} catch (SQLException e) {
			App.close(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean updateQuestion(Question question) {
		if (!isValidQuestion(question)) return false;

		boolean result = false;
		try {
			result = dao.updateQuestion(question);
		} catch (SQLException e) {
			App.close(e.getMessage());
		}
		return result;
	}

	private boolean isValidQuestion(Question question) {
		if (question == null 
				|| question.getEditor() < 1
				|| question.getContent() == null
				|| question.getSolution() == null
				|| question.getPoints() < 0) {
			return false;
		}
		return true;
	}

	@Override
	public void setDao(QuestionDAO dao) {
		this.dao = dao;
	}
}