
package com.va.quiz.dto;
/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class Score {
	private int ID;
	private int userID;
	private int result;
	String name;

	public Score(int userID) {
		super();
		this.userID = userID;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getUserID() {
		return userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " : " + result;
	}
}