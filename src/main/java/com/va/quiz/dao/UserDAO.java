package com.va.quiz.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public interface UserDAO {
	public User getUser(User user) throws SQLException;
	public boolean addUser(User user) throws SQLException;
	public boolean deleteUser(User user) throws SQLException;
	public ArrayList<User> getAllUsers() throws SQLException;
}