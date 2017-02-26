package com.va.quiz;

import org.junit.Before;
import org.mockito.Mockito;

import com.va.quiz.bo.ScoreBOImplementation;
import com.va.quiz.dao.ScoreDAO;
import com.va.quiz.dto.Score;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class ScoreBOImplementationTest {
	ScoreDAO daoMock = Mockito.mock(ScoreDAO.class);
	ScoreBOImplementation bo = new ScoreBOImplementation();

	Score score;

	final int USER_ID = 1, WRONG_ID = -1;

	@Before
	public void setUp() {
		bo.setDao(daoMock);
		score = new Score(USER_ID);
	}
}