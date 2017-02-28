package com.va.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.va.quiz.bo.AdminBO;
import com.va.quiz.bo.AdminBOImplementation;
import com.va.quiz.bo.QuestionBO;
import com.va.quiz.bo.QuestionBOImplementation;
import com.va.quiz.bo.ScoreBO;
import com.va.quiz.bo.ScoreBOImplementation;
import com.va.quiz.bo.UserBO;
import com.va.quiz.bo.UserBOImplementation;
import com.va.quiz.dao.AdminDAOImplementation;
import com.va.quiz.dao.QuestionDAOImplementation;
import com.va.quiz.dao.ScoreDAOImplementation;
import com.va.quiz.dao.UserDAOImplementation;
import com.va.quiz.dto.Admin;
import com.va.quiz.dto.Person;
import com.va.quiz.dto.Question;
import com.va.quiz.dto.Score;
import com.va.quiz.dto.User;
import com.va.quiz.utils.Printer;
import com.va.quiz.utils.Setup;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class App {
	private static AdminBO adminBO = new AdminBOImplementation();
	private static UserBO userBO = new UserBOImplementation();
	private static QuestionBO questionBO = new QuestionBOImplementation();
	private static ScoreBO scoreBO = new ScoreBOImplementation();

	private static Scanner in = new Scanner(System.in);
	private static Printer printer = new Printer();
	private Person person;
	
	private static int choice = -1;

	public void run() {
		welcomeMenu();
	}
	/* First menu that is shown when app starts. */
	public void welcomeMenu() {
		boolean active = true;
		while (active) {
			printNotification("[1] Login"
					+ "\n[2] Register"
					+ "\n[3] Close");
			chose();
			switch (choice) {
			case 1:
				logInMenu();
				break;
			case 2:
				registerMenu();
				break;
			case 3:
				active = false;
				break;
			default:
				break;
			}
		}
	}
	/* Menu for logging in. */
	public void logInMenu() {
		String name = scan("Enter your name");
		String pass = scan("Enter your pasword");
		
		if ((person = get(new Admin(name, pass))) != null ) {
			adminMenu();
		} else if ((person = get(new User(name, pass))) != null ) {
			userMenu();
		} else {
			printNotificationAndWait("Credentials not correct.\nPlease try again\n\n(press enter)");
		}
	}
	/* Menu for registering user. */
	public void registerMenu() {
		String name = scan("Enter your name");
		String pass = scan("Enter your pasword");
		
		User user = new User(name, pass);
		if (userBO.getUser(user) == null) {
			userBO.addUser(user);
			printNotificationAndWait("You registeres sucessfuly.\n\n (press enter)");
		} else {
			printNotificationAndWait("Credentials not correct\nCheck your input.\n\n (press enter)");
		}
	}
	/* Prints admin menu and responds acording to choices. */
	private void adminMenu() {
		boolean active = true;
		while (active) {
			printNotification("[1] Browse questions."
					+ "\n[2] Browse users"
					+ "\n[3] Add question"
					+ "\n[4] Edit question"
					+ "\n[5] Delete user"
					+ "\n[6] Close");
			chose();
			switch (choice) {
			case 1:
				ArrayList<Question> questions = questionBO.getAllQuestions();
				browseList(questions);
				break;
			case 2:
				ArrayList<User> users = userBO.getAllUsers();
				browseList(users);
				break;
			case 3:
				addQuestion();
				break;
			case 4:
				editQuestion();
				break;
			case 5:
				deleteUser();
				break;
			case 6:
				active = false;
				break;
			default:
				break;
			}
		}
	}
	/* Called when admin wants to add new question. */
	private void addQuestion() {
		Question question = createQuestion();
		
		if (questionBO.addQuestion(question)) {
			printNotificationAndWait("Question added.");
		} else {
			printNotificationAndWait("Question is not added.");
		}
	}
	/* Called when admin edits question. */
	private void editQuestion() {
		int id = scanInt("Enter id of a question.");
		if (id > 0 && id < questionBO.getAllQuestions().size()) {
			Question updateQuestion = createQuestion();
			updateQuestion.setID(id);
			questionBO.updateQuestion(updateQuestion);
		} else {
			printNotificationAndWait("Question id is not correct.");
		}
	}
	/* Called to fill in information about question. */
	private Question createQuestion() {
		Question question = new Question(person.getID());
		
		String content = scan("Enter question and use \"\\n\"\nto break lines.");
		String solution = scan("Enter solution.");
		int points = scanInt("Enter amount of points.");
		
		question.setContent(content);
		question.setSolution(solution);
		question.setPoints(points);
		
		return question;
	}
	/* Called when deleting user. */
	private void deleteUser() {
		String name = scan("Enter user name.");
		String pass = scan("Enter user password.");
		
		User user = new User(name, pass);
		if (userBO.getUser(user) != null) {
			userBO.deleteUser(user);
			printNotificationAndWait("User deleted.");
		} else {
			printNotificationAndWait("User doesn't exist.");
		}
	}
	/* Prints user menu and responds acording to choices. */
	private void userMenu() {
		boolean active = true;
		while (active) {
			printNotification("[1] Play."
					+ "\n[2] Browse top 100"
					+ "\n[3] Browse my scores"
					+ "\n[4] Close");
			chose();
			switch (choice) {
			case 1:
				play();
				break;
			case 2:
				ArrayList<Score> scores = scoreBO.getTopHundred();
				browseList(scores);
				break;
			case 3:
				ArrayList<Score> allScores = scoreBO.getScores((User)person);
				browseList(allScores);
				break;
			case 4:
				active = false;
				break;
			default:
				break;
			}
		}
	}
	/* Called when user wants to play one game. */
	private void play() {
		printNotificationAndWait("Read questions and type answer."
				+ "\nAnswer can be"
				+ "\nletter or a word.");
		ArrayList<Question> questions = questionBO.getAllQuestions();
		Collections.shuffle(questions);
		int points = 0;
		for (Question question : questions) {
			String answer = scan(question.toString());
			if (question.getSolution().equals(answer)) {
				points += question.getPoints();
			}
		}
		Score score = new Score(person.getID());
		score.setResult(points);
		scoreBO.addScore(score);
	}
	/* Retrieve admin if exists, else retrieve null. */
	private Admin get(Admin admin) {
		return adminBO.getAdmin(admin);
	}
	/* Retrieve user if exists, else retrieve null. */
	private User get(User user) {
		return userBO.getUser(user);
	}
	/* Browse any list of items. */
	private <T> void browseList(ArrayList<T> list) {
		printNotificationAndWait("Type number of question"
				+ "\nto browse."
				+ "\nType 0 to exit.");
		choice = 1;
		while (choice > 0 && choice <= list.size()) {
			printer.printList(list, choice - 1);
			chose();
		}
	}
	/* Print notification and wait for user to respond. */
	private void printNotificationAndWait(String notification) {
		printNotification(notification);
		in.nextLine();
	}
	/* Print simple notification. */
	private void printNotification(String notification) {
		printer.printNotification(notification);
	}
	/* Scan user string input and retrieve. */
	private String scan(String message) {
		printNotification(message);
		return in.nextLine();
	}
	/* Scan user string input and retrieve. */
	private int scanInt(String message) {
		printNotification(message);
		int i = 0;
		try {
			System.out.print(">> ");
			i = in.nextInt();
			in.nextLine();
		} catch (InputMismatchException e) {
			inputWarning();
		}
		return i;
	}
	/* Read number as a choice that will be used to pick menu. */
	private void chose() {
		try {
			System.out.print(">> ");
			choice = in.nextInt();
			in.nextLine();
		} catch (InputMismatchException e) {
			choice = -1;
			inputWarning();
		}
	}
	/* If input is not correct print warning. */
	private void inputWarning() {
		in.nextLine();
		printNotificationAndWait("Enter numeric value.\n\n(press enter)");
	}
	/* Close app with default message. */
	public static void close() {
		close("App is closed.");
	}
	/* Print message/error and close app. */
	public static void close(String message) {
		printer.printNotification(message);
		System.out.close();
	}

	public static void main(String[] args) {
		Setup setup = new Setup();
		setup.check();
		
		adminBO.setDao(new AdminDAOImplementation());
		userBO.setDao(new UserDAOImplementation());
		questionBO.setDao(new QuestionDAOImplementation());
		scoreBO.setDao(new ScoreDAOImplementation());
		

		App app = new App();
		app.run();

		in.close();
		App.close();
	}
}
