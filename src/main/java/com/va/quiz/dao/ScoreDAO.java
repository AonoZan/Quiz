package com.va.quiz.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.va.quiz.dto.Score;
import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface ScoreDAO {
	public ArrayList<Score> getTopHundred() throws SQLException;
	public ArrayList<Score> getScores(User user) throws SQLException;
	public boolean addScore(Score score) throws SQLException;
}