package com.va.quiz.dao;

import java.util.ArrayList;

import com.va.quiz.dto.Score;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface ScoreDAO {
	public ArrayList<Score> getTopHundred();
}