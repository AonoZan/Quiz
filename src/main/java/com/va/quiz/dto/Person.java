
package com.va.quiz.dto;
/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class Person {
	private int ID;
	private String name;
	private String pass;
	
	public Person(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
}