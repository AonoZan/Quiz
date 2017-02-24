package com.va.quiz.dao;

import com.va.quiz.dto.Admin;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface AdminDAO {
	public Admin getAdmin(Admin admin);
	public boolean addAdmin(Admin admin);
}