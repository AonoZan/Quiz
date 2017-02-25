package com.va.quiz.dao;

import java.util.ArrayList;

import com.va.quiz.dto.Question;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface QuestionDAO {

	public ArrayList<Question> getAllQuestions();
}