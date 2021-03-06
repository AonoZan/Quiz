package com.va.quiz.bo;

import java.util.ArrayList;

import com.va.quiz.dao.QuestionDAO;
import com.va.quiz.dto.Question;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface QuestionBO {
	public ArrayList<Question> getAllQuestions();
	boolean addQuestion(Question question);
	boolean updateQuestion(Question question);
	void setDao(QuestionDAO dao);
}