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

	final int ID = 5;
	final int EDITOR = 1;
	final String CONTENT = "Simple question?";
	final String SOLUTION = "Just an answer...";
	final int POINTS = 20;
	final ArrayList<Question> allQuestions = new ArrayList<>();
	private static final int NEGATIVE_NUM = -10;

	@Before
	public void setUp() {
		bo.setDao(daoMock);
		question = new Question(EDITOR);
		defaultQuestion(question);
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
	public void shouldReturnFalseWhenAddingQuestionButIDIsNotValid() {
		question.setID(NEGATIVE_NUM);
		boolean result = bo.addQuestion(question);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnFalseWhenAddingQuestionButEditorIDIsNotValid() {
		question = new Question(NEGATIVE_NUM);
		defaultQuestion(question);
		boolean result = bo.addQuestion(question);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnFalseWhenAddingQuestionButContentIsNull() {
		question.setContent(null);
		boolean result = bo.addQuestion(question);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnFalseWhenAddingQuestionButSolutionIsNull() {
		question.setSolution(null);
		boolean result = bo.addQuestion(question);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnFalseWhenAddingQuestionButPointsAreNegative() {
		question.setPoints(NEGATIVE_NUM);
		boolean result = bo.addQuestion(question);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}

	private void defaultQuestion(Question question) {
		question.setID(ID);
		question.setContent(CONTENT);
		question.setSolution(SOLUTION);
		question.setID(ID);
	}
}
