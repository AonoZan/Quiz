
package com.va.quiz;

import org.junit.Before;
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

	@Before
	public void setUp() {
		bo.setDao(daoMock);
		question = new Question(EDITOR);
	}
}

