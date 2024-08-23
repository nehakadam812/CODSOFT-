package codSoft_4;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ExecutionClass {
	private static final int TL = 15;

	private QuizQuestions[] questions;
	private int score;
	private Scanner sc = new Scanner(System.in);;

	public ExecutionClass(QuizQuestions[] questions) {
		this.questions = questions;
		this.score = 0;

	}

	public void start() {
		for (QuizQuestions question : questions) {
			askQuestion(question);
		}
		displayScore();
	}

	private void askQuestion(QuizQuestions question) {
		System.out.println(question.getQuestion());
		String[] options = question.getOptions();
		for (String option : options) {
			System.out.println(option);
		}

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("---- Time's up !----");

			}
		};
		timer.schedule(task, TL * 1000);

		System.out.println("You have " + TL + " seconds to answer.");
		String answer = sc.nextLine();

		timer.cancel();

		if (answer.equalsIgnoreCase(question.getCorrectAnswer())) {
			System.out.println("Correct!");
			score++;
		} else {
			System.out.println("Incorrect. The correct answer was : " + question.getCorrectAnswer());
		}
	}

	private void displayScore() {
		System.out.println("Your final score is: " + score + "Out of" + questions.length);
	}

	public static void main(String[] args) {
		System.out.println("\n---- Welcome To QUIZ !----");
		QuizQuestions[] questions = {
				new QuizQuestions("1) Who invented Java Programming?",
						new String[] { "a) Guido van Rossum", "b) James Gosling", "c) Dennis Ritchie",
								"d) Bjarne Stroustrup" },
						"b"),
				new QuizQuestions("2) Which component is used to compile, debug and execute the java programs?",
						new String[] { "a) JRE", "b) JIT", "c) JDK", "d) JVM" }, "c"),
				new QuizQuestions("3) Which of these cannot be used for a variable name in Java?",
						new String[] { "a) Identifier & Keyword", "b) Identifier", "c) Keyword",
								"d) none of the mentioned" },
						"c"),
				new QuizQuestions("4) What is the extension of compiled java classes??",
						new String[] { "a) .txt", "b) .js", "c) .class", "d) .java" }, "d"),

		};

		ExecutionClass quiz = new ExecutionClass(questions);
		quiz.start();
	}

}
