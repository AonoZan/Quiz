package com.va.quiz.bo;

import java.util.ArrayList;

import com.va.quiz.dao.ScoreDAO;
import com.va.quiz.dto.Score;
import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface ScoreBO {
	ArrayList<Score> getTopHundred();
	ArrayList<Score> getScores(User user);
	boolean addScore(Score score);
	void setDao(ScoreDAO dao);
}