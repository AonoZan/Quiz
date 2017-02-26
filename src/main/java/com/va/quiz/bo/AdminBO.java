package com.va.quiz.bo;

import com.va.quiz.dao.AdminDAO;
import com.va.quiz.dto.Admin;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface AdminBO {
	public Admin getAdmin(Admin admin);
	public boolean addAdmin(Admin admin);
	public void setDao(AdminDAO dao);
}