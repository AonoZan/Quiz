package com.va.quiz.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.va.quiz.App;
import com.va.quiz.dao.ScoreDAO;
import com.va.quiz.dto.Score;
import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class ScoreBOImplementation implements ScoreBO {
	ScoreDAO dao;

	@Override
	public ArrayList<Score> getTopHundred() {
		ArrayList<Score> scores = null;
		try {
			scores = dao.getTopHundred();
		} catch (SQLException e) {
			App.close(e.getMessage());
		}

		if(scores == null) scores = new ArrayList<>();

		return scores;
	}

	@Override
	public ArrayList<Score> getScores(User user) {
		if(user.getID() < 1) return new ArrayList<>();

		ArrayList<Score> scores = null;
		try {
			scores = dao.getScores(user);
		} catch (SQLException e) {
			App.close(e.getMessage());
		}
		if(scores == null) scores = new ArrayList<>();

		return scores;
	}
	
	@Override
	public boolean addScore(Score score) {
		if (score == null || score.getUserID() < 1 || score.getResult() < 0) return false;

		boolean result = false;
		try {
			result = dao.addScore(score);
		} catch (SQLException e) {
			App.close(e.getMessage());
		}

		return result;
	}

	@Override
	public void setDao(ScoreDAO dao) {
		this.dao = dao;
	}
}