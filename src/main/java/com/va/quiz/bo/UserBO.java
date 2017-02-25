
package com.va.quiz.bo;

import com.va.quiz.dao.UserDAO;
import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface UserBO {
	public User getUser(User user);
	public void setDao(UserDAO dao);
}