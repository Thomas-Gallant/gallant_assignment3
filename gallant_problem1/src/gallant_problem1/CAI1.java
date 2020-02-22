package gallant_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {

	public static void main(String[] args) {
		
		CAI1 quiz = new CAI1();
		quiz.quiz();
	}
	
	private static Scanner in = new Scanner(System.in);
	private static SecureRandom randomNumbers = new SecureRandom();
	
	public void quiz() {
		
		int multiplicand = 0 + randomNumbers.nextInt(10);
		int multiplier = 0 + randomNumbers.nextInt(10);
		
		while (true) {
			askQuestion(multiplicand, multiplier);
			int userAnswer = readResponse();
			isAnswerCorrect(multiplicand, multiplier, userAnswer);
		}
	}
	
	public void askQuestion(int multiplicand, int multiplier) {
		System.out.println("How much is " + multiplicand + " x " + multiplier + "?");
		
	}

	public int readResponse() {
		
		while (!in.hasNextInt()) {
            String input = in.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
		
		int userAnswer = in.nextInt();
		return userAnswer;
	}
	
	public void isAnswerCorrect(int multiplicand, int multiplier, int userAnswer) {
		int correctAnswer = multiplicand * multiplier;
		if (userAnswer == correctAnswer) {
			displayCorrectResponse();
		}
		
		else {
			displayIncorrectResponse();
		}
	}
	
	public void displayCorrectResponse() {
		System.out.println("Very good!");
		System.exit(0);
	}
	
	public void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
		
	}
}
