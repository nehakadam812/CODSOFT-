package codeSoft;

import java.util.Random;
import java.util.Scanner;

public class Random_NumberGame {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("----Welcome to Guess-number  Game----");
		System.out.println("*___Let's start the game___* ");
		game();
	}

	public static void game() {
		do {
			Random rand = new Random();
			int ranNum = rand.nextInt(1, 100);
			boolean guessCorrect = false;
			int attempt = 1;
			while (attempt < 4) {
				System.out.println("\nThis is your " + attempt + " Round");
				System.out.println("Enter the guess num");
				int gsn = sc.nextInt();
				if (gsn == ranNum) {
					guessCorrect = true;
					System.out.println("guess number is right !");
					System.out.println();
					break;

				} else if (gsn < ranNum) {
					System.out.println("Your guess number is too low !");

				} else {
					System.out.println("Your guess number is too high !");

				}
				attempt++;
			}

			if (guessCorrect) {
				System.out.println("||  Congratulations you guessed correctly!   ||");
				System.out.println("The number was :" + ranNum);

			} else {
				System.out.println("||  Sorray ,you are out !   ||");
				System.out.println("The correct number was " + ranNum);
			}

			System.out.println("\n----Enter R to start again----");
		} while ("R".equalsIgnoreCase(sc.next()));
	}

}
