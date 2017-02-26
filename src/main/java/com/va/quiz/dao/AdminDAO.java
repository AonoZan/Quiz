package com.va.quiz.dao;

import java.sql.SQLException;

import com.va.quiz.dto.Admin;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface AdminDAO {
	public Admin getAdmin(Admin admin) throws SQLException;
	public boolean addAdmin(Admin admin) throws SQLException;
}