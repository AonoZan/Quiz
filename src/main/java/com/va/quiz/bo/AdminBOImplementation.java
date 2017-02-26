package com.va.quiz.bo;

import java.sql.SQLException;

import com.va.quiz.App;
import com.va.quiz.dao.AdminDAO;
import com.va.quiz.dto.Admin;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class AdminBOImplementation implements AdminBO {
	AdminDAO dao;

	public Admin getAdmin(Admin admin) {
		if (!adminValid(admin)) return null;

		try {
			admin = dao.getAdmin(admin);
		} catch (SQLException e) {
			App.close(e.getMessage());
		}
		return admin;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		if (!adminValid(admin)) return false;

		boolean result = false;
		try {
			result = dao.addAdmin(admin);
		} catch (SQLException e) {
			App.close(e.getMessage());
		}
		return result;
	}

	private boolean adminValid(Admin admin) {
		if (admin == null || admin.getName() == null || admin.getPass() == null) {
			return false;
		}
		return true;
	}

	@Override
	public void setDao(AdminDAO dao) {
		this.dao = dao;
	}
}