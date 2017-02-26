
package com.va.quiz.bo;

import java.sql.SQLException;

import com.va.quiz.App;
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

		try {
			user = dao.getUser(user);
		} catch (SQLException e) {
			App.close(e.getMessage());
		}
		return user;
	}

	@Override
	public boolean addUser(User user) {
		if (!userValid(user)) return false;

		boolean result = false;
		try {
			result = dao.addUser(user);
		} catch (SQLException e) {
			App.close(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean deleteUser(User user) {
		if (!userValid(user)) return false;

		boolean result = false;
		try {
			result = dao.deleteUser(user);
		} catch (SQLException e) {
			App.close(e.getMessage());
		}
		return result;
	}

	private boolean userValid(User user) {
		if (user == null || user.getName() == null || user.getPass() == null) {
			return false;
		}
		return true;
	}

	@Override
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
}