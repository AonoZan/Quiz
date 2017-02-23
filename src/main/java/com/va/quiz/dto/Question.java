
package com.va.quiz.dto;
/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class Question {

	private int ID;
	private int editor;
	private String content;
	private String solution;
	private int points;

	public Question(int editor) {
		super();
		this.editor = editor;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getEditor() {
		return editor;
	}

	@Override
	public String toString() {
		return content;
	}
}
