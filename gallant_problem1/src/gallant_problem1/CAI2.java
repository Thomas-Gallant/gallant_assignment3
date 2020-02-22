package gallant_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {

	public static void main(String[] args) {
		
		CAI2 quiz = new CAI2();
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
		
		int positiveMessages = 1 + randomNumbers.nextInt(4);
		
		switch (positiveMessages) {
		
			case 1:
				System.out.println("Very good!");
				break;
			case 2:
				System.out.println("Excellent!");
				break;
			case 3:
				System.out.println("Nice work!");
				break;
			case 4:
				System.out.println("Keep up the good work!");
				break;
		}	

		System.exit(0);
	}
	
	public void displayIncorrectResponse() {
		
		int negativeMessages = 1 + randomNumbers.nextInt(4);
		
		switch (negativeMessages) {
		
			case 1:
				System.out.println("No. Please try again.");
				break;
			case 2:
				System.out.println("Wrong. Try once more.");
				break;
			case 3:
				System.out.println("Don’t give up!");
				break;
			case 4:
				System.out.println("No. Keep trying.");
				break;
		}
	}
}