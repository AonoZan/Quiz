
package com.va.quiz.bo;

import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface UserBO {
	public User getUser(User user);
	public boolean addUser(User user);
	public boolean deleteUser(User user);
}