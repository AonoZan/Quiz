package com.va.quiz.bo;

import com.va.quiz.dao.AdminDAO;
import com.va.quiz.dto.Admin;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class AdminBOImplementation implements AdminBO {
	AdminDAO dao;

	public Admin getAdmin(Admin admin) {
		if (!adminValid(admin)) return null;

		admin = dao.getAdmin(admin);
		return admin;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		if (!adminValid(admin)) return false;

		boolean result = dao.addAdmin(admin);
		return result;
	}

	private boolean adminValid(Admin admin) {
		if (admin == null || admin.getName() == null || admin.getPass() == null) {
			return false;
		}
		return true;
	}

	public void setDao(AdminDAO dao) {
		this.dao = dao;
	}
}