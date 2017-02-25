
package com.va.quiz.dao;

import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface UserDAO {
	public User getUser(User user);
	public boolean addUser(User user);
}