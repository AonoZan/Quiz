package com.va.quiz.bo;

import java.util.ArrayList;

import com.va.quiz.dao.QuestionDAO;
import com.va.quiz.dto.Question;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class QuestionBOImplementation implements QuestionBO {
	private QuestionDAO dao;

	@Override
	public ArrayList<Question> getAllQuestions() {
		return dao.getAllQuestions();
	}

	@Override
	public boolean addQuestion(Question question) {
		if (!isValidQuestion(question)) return false;
		return dao.addQuestion(question);
	}

	@Override
	public boolean updateQuestion(Question question) {
		if (!isValidQuestion(question)) return false;
		return dao.updateQuestion(question);
	}

	private boolean isValidQuestion(Question question) {
		if (question == null 
				|| question.getID() < 1
				|| question.getEditor() < 1
				|| question.getContent() == null
				|| question.getSolution() == null
				|| question.getPoints() < 0) {
			return false;
		}
		return true;
	}
	public void setDao(QuestionDAO dao) {
		this.dao = dao;
	}
}