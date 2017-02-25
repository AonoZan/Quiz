
package com.va.quiz.bo;

import com.va.quiz.dao.QuestionDAO;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class QuestionBOImplementation implements QuestionBO {
	private QuestionDAO dao;

	public void setDao(QuestionDAO dao) {
		this.dao = dao;
	}
}