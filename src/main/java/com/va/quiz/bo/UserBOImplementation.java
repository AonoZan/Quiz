
package com.va.quiz.bo;

import com.va.quiz.dao.UserDAO;
import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class UserBOImplementation implements UserBO {
	UserDAO dao;

	@Override
	public User getUser(User user) {
		if (!userValid(user)) return null;

		user = dao.getUser(user);
		return user;
	}

	@Override
	public boolean addUser(User user) {
		if (!userValid(user)) return false;

		boolean result = dao.addUser(user);
		return result;
	}

	@Override
	public boolean deleteUser(User user) {
		if (!userValid(user)) return false;

		boolean result = dao.deleteUser(user);
		return result;
	}

	private boolean userValid(User user) {
		if (user == null || user.getName() == null || user.getPass() == null) {
			return false;
		}
		return true;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
}