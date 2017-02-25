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

	public void setDao(QuestionDAO dao) {
		this.dao = dao;
	}
}