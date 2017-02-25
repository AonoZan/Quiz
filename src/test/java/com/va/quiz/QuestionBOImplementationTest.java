package com.va.quiz;

import static org.junit.Assert.*;

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
	@Test
	public void shouldReturnNullWhenNoQuestionsExists() {
		Mockito.when(daoMock.getAllQuestions()).thenReturn(null);

		ArrayList<Question> resultQuestions = bo.getAllQuestions();

		assertNull(resultQuestions);
		Mockito.verify(daoMock).getAllQuestions();
	}

	@Test
	public void shouldAddQuestion() {
		question.setContent("content");
		question.setSolution("solution");
		Mockito.when(daoMock.addQuestion(question)).thenReturn(true);

		boolean result = bo.addQuestion(question);

		assertTrue(result);
		Mockito.verify(daoMock).addQuestion(question);
	}
	@Test
	public void shouldReturnFalseWhenAddingQuestionButArgumentIsNull() {
		Mockito.when(daoMock.addQuestion(null)).thenReturn(false);

		boolean result = bo.addQuestion(null);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnFalseWhenAddingQuestionButContentIsNull() {
		boolean result = bo.addQuestion(question);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}

	
}
