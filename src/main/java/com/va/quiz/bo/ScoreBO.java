package com.va.quiz.bo;

import java.util.ArrayList;

import com.va.quiz.dto.Score;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface ScoreBO {
	ArrayList<Score> getTopHundred();
}