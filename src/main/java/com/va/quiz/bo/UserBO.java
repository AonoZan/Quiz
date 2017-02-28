
package com.va.quiz.bo;

import java.util.ArrayList;

import com.va.quiz.dao.UserDAO;
import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface UserBO {
	public User getUser(User user);
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	ArrayList<User> getAllUsers();
	void setDao(UserDAO dao);
}