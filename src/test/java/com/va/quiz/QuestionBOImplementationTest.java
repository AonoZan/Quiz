package com.va.quiz;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.va.quiz.bo.QuestionBOImplementation;
import com.va.quiz.dao.QuestionDAO;
import com.va.quiz.dto.Question;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class QuestionBOImplementationTest {
	QuestionDAO daoMock = Mockito.mock(QuestionDAO.class);
	QuestionBOImplementation bo = new QuestionBOImplementation();

	Question question;

	final int EDITOR = 1;
	final ArrayList<Question> allQuestions = new ArrayList<>();

	@Before
	public void setUp() {
		bo.setDao(daoMock);
		question = new Question(EDITOR);
	}
	
	@Test
	public void shouldReturnAllQuestionsWhenAnyQuestionExists() {
		Mockito.when(daoMock.getAllQuestions()).thenReturn(allQuestions);

		ArrayList<Question> resultQuestions = bo.getAllQuestions();

		assertSame(allQuestions, resultQuestions);
		Mockito.verify(daoMock).getAllQuestions();
	}
	
}

