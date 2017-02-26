package com.va.quiz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.va.quiz.bo.ScoreBOImplementation;
import com.va.quiz.dao.ScoreDAO;
import com.va.quiz.dto.Score;
import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class ScoreBOImplementationTest {
	ScoreDAO daoMock = Mockito.mock(ScoreDAO.class);
	ScoreBOImplementation bo = new ScoreBOImplementation();

	Score score;
	User user;

	final int USER_ID = 1, WRONG_ID = -1;
	final String NAME = "Dejan", PASS = "pass";
	ArrayList<Score> scores = new ArrayList<>();

	@Before
	public void setUp() {
		bo.setDao(daoMock);
		score = new Score(USER_ID);
		user = defaultUser();
	}

	@Test
	public void shouldReturnTopHundredScores() throws SQLException {
		Mockito.when(daoMock.getTopHundred()).thenReturn(scores);

		ArrayList<Score> scoresResult = bo.getTopHundred();

		assertSame(scores, scoresResult);
		Mockito.verify(daoMock).getTopHundred();
	}
	@Test
	public void shouldReturnEmptyListOfScoresWhenNoScoreEntry() throws SQLException {
		Mockito.when(daoMock.getTopHundred()).thenReturn(null);

		ArrayList<Score> scoresResult = bo.getTopHundred();

		assertEquals(scores, scoresResult);
		Mockito.verify(daoMock).getTopHundred();
	}

	@Test
	public void shouldReturnScores() throws SQLException {
		user.setID(USER_ID);
		Mockito.when(daoMock.getScores(user)).thenReturn(scores);

		ArrayList<Score> scoresResult = bo.getScores(user);

		assertSame(scores, scoresResult);
		Mockito.verify(daoMock).getScores(user);
	}
	@Test
	public void shouldReturnEmptyListOfScoresWhenNoScoreForUser() throws SQLException {
		user.setID(USER_ID);
		Mockito.when(daoMock.getScores(user)).thenReturn(null);

		ArrayList<Score> scoresResult = bo.getScores(user);

		assertEquals(scores, scoresResult);
		Mockito.verify(daoMock).getScores(user);
	}
	@Test
	public void shouldReturnEmptyListOfScoresWhenUserIDIsNotValid() {
		user.setID(WRONG_ID);

		ArrayList<Score> scoresResult = bo.getScores(user);

		assertEquals(scores, scoresResult);
		Mockito.verifyZeroInteractions(daoMock);
	}

	private User defaultUser() {
		User user = new User(NAME, PASS);
		return user;
	}
}