package com.va.quiz.bo;

import java.util.ArrayList;

import com.va.quiz.dao.ScoreDAO;
import com.va.quiz.dto.Score;

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

	public void setDao(ScoreDAO dao) {
		this.dao = dao;
	}
}