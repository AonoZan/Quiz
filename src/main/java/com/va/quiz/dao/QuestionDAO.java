package com.va.quiz.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.va.quiz.dto.Question;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface QuestionDAO {
	public ArrayList<Question> getAllQuestions() throws SQLException;
	public boolean addQuestion(Question question) throws SQLException;
	public boolean updateQuestion(Question question) throws SQLException;
}