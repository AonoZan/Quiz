package com.va.quiz.bo;

import com.va.quiz.dao.ScoreDAO;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class ScoreBOImplementation implements ScoreBO {
	ScoreDAO dao;

	public void setDao(ScoreDAO dao) {
		this.dao = dao;
	}
}