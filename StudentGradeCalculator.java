package codSoft;

import java.util.Scanner;

public class StudentGradeCalculator {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		 marksGradeCalculator();
	}
	public static void marksGradeCalculator() {
		
	

		System.out.println("Let's calculate your marks aggregate !");
		System.out.print("Enter the number of subjects you want to calculate aggregate :\n");
		int numSub = sc.nextInt();

		int[] marks = new int[numSub];
		int totalMarks = 0;

		for (int i = 0; i < numSub; i++) {
			System.out.print("\nEnter marks out of 100 for subject " + (i + 1) + ": ");
			marks[i] = sc.nextInt();
			totalMarks =totalMarks + marks[i] ;
		}

		double averagePer = (double) totalMarks / (numSub * 100) * 100;

		String grade;

		if (averagePer <= 100 & averagePer > 90) {
			grade = "A+";
		} else if (averagePer <= 90 & averagePer > 80) {
			grade = "A";
		} else if (averagePer <= 80 & averagePer > 70) {
			grade = "B+";
		} else if (averagePer <= 70 & averagePer > 60) {
			grade = "B";
		} else if (averagePer <= 60 & averagePer > 50) {
			grade = "C+";
		} else if (averagePer <= 50 & averagePer > 34) {
			grade = "C";
		} else {
			grade = "F";
		}

		System.out.println("\nResult !\nTotal Marks: " + totalMarks);
		System.out.println("Average Percentage :" + averagePer + "%");
		System.out.println("Grade : " + grade);

		
	}

}