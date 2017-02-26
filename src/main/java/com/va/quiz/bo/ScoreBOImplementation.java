package com.va.quiz.bo;

import java.util.ArrayList;

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
		ArrayList<Score> scores = dao.getTopHundred();

		if(scores == null) scores = new ArrayList<>();

		return scores;
	}

	@Override
	public ArrayList<Score> getScores(User user) {
		return dao.getScores(user);
	}

	public void setDao(ScoreDAO dao) {
		this.dao = dao;
	}
}