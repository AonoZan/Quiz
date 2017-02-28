package com.va.quiz.utils;

import java.util.ArrayList;

/**
 * @author AonoZan Dejan Petrovic 2017 ©
 */
public class Printer {
	private final int MENU_HEIGHT = 8;
	private String[] content;

	/* Print simple notification. */
	public void printNotification(String notification) {
		printNewPage();
		printHeader("\tQuiz");
		printContent(notification);
	}
	/* Print list with list length in header. */
	public <T> void printList(ArrayList<T> list, int item) {
		printNewPage();
		printHeader(item+1 + "/" + list.size());
		printContent(list.get(item).toString());
	}
	/* Prints content properly aligned to MENU_HEIGHT. */
	public void printContent(String content) {
		this.content = content.split("(\n)|(\\\\n)");
		int topSpacer = (MENU_HEIGHT - this.content.length)/2;
		for (int line = -topSpacer; line <= MENU_HEIGHT - topSpacer; line++) {
			if(line >= 0 && line < this.content.length) {
				System.out.println(this.content[line]);
			} else {
				System.out.println();
			}
		}
	}
	/* Prints header. */
	public static void printHeader(String header) {
		System.out.println(":::::::::::::::::::::::::");
		System.out.println(header);
		System.out.println("'''''''''''''''''''''''''");
	}
	/* Prints new page. */
	public static void printNewPage() {
		System.out.println("\n\n\n\n\n\n\n\n\n");
	}
}