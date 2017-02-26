package com.va.quiz;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
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
	ArrayList<Score> scores = new ArrayList<>();

	@Before
	public void setUp() {
		bo.setDao(daoMock);
		score = new Score(USER_ID);
	}

	@Test
	public void shouldReturnTopHundredScores() {
		Mockito.when(daoMock.getTopHundred()).thenReturn(scores);

		ArrayList<Score> scoresResult = bo.getTopHundred();

		assertSame(scores, scoresResult);
		Mockito.verify(daoMock).getTopHundred();
	}
	@Test
	public void shouldReturnEmptyListOfScoresWhenNoScoreEntry() {
		Mockito.when(daoMock.getTopHundred()).thenReturn(null);

		ArrayList<Score> scoresResult = bo.getTopHundred();

		assertEquals(scores, scoresResult);
		Mockito.verify(daoMock).getTopHundred();
	}
}