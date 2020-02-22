package gallant_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {

	public static void main(String[] args) {
		
		CAI4 quiz = new CAI4();
		quiz.quiz();
	}
	
	private static Scanner in = new Scanner(System.in);
	private static SecureRandom randomNumbers = new SecureRandom();
	
	public int correctCount;
	public int incorrectCount;
	
	public int multiplier;
	public int multiplicand;
	
	public void quiz() {
		
		int questionDifficulty = readDifficulty();
		
		for (int i = 0; i < 10; i++) {
			generateQuestionArguement(questionDifficulty);
			int correctAnswer = askQuestion();
			int userAnswer = readResponse();
			isAnswerCorrect(correctAnswer, userAnswer);
		}
		
		displayCompletionMessage();
	}
	public int readDifficulty() {
		
		System.out.println("Please input a difficulty level of 1, 2, 3, or 4");
		
		while (!in.hasNextInt()) {
            String input = in.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
		
		int questionDifficulty = in.nextInt();
		
		while (true) {
			if (questionDifficulty >= 1 || questionDifficulty <= 1) {
				return questionDifficulty;
			}
			
			else {
				
				while (!in.hasNextInt()) {
		            String input = in.next();
		            System.out.printf("\"%s\" is not a valid number.\n", input);
		        }
				
				questionDifficulty = in.nextInt();
			}
		}
	}
	
	public void generateQuestionArguement(int questionDifficulty) {
		switch (questionDifficulty) {
		
			case 1:
				multiplicand = 0 + randomNumbers.nextInt(10);
				multiplier = 0 + randomNumbers.nextInt(10);
				break;
			case 2:
				multiplicand = 0 + randomNumbers.nextInt(100);
				multiplier = 0 + randomNumbers.nextInt(100);
				break;
			case 3:
				multiplicand = 0 + randomNumbers.nextInt(1000);
				multiplier = 0 + randomNumbers.nextInt(1000);
				break;
			case 4:
				multiplicand = 0 + randomNumbers.nextInt(10000);
				multiplier = 0 + randomNumbers.nextInt(10000);
				break;
		}
	}
	
	public int askQuestion() {
		
		System.out.println("How much is " + multiplicand + " x " + multiplier + "?");
		
		return multiplicand * multiplier;
		
	}

	public int readResponse() {
		
		while (!in.hasNextInt()) {
            String input = in.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
		
		int userAnswer = in.nextInt();
		return userAnswer;
	}
	
	public void isAnswerCorrect(int correctAnswer, int userAnswer) {
		
		if (userAnswer == correctAnswer) {
			displayCorrectResponse();
			correctCount += 1;
		}
		
		else {
			displayIncorrectResponse();
			incorrectCount += 1;
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
	}
	
	public void displayIncorrectResponse() {
		
		int negativeMessages = 1 + randomNumbers.nextInt(4);
		
		switch (negativeMessages) {
		
			case 1:
				System.out.println("No. Please try this problem.");
				break;
			case 2:
				System.out.println("Wrong. Try this one.");
				break;
			case 3:
				System.out.println("Don’t give up!");
				break;
			case 4:
				System.out.println("No. Good try.");
				break;
		}
	}
	
	public void displayCompletionMessage() {
		
		double score = (double) correctCount / 10.0 * 100.0;
		
		System.out.println("You scored " + score + "% on this problem set.");
		if (score < 75) {
			System.out.println("Please ask your teacher for extra help.");
		}
		if (score >= 75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		
		System.out.println("Do you want to do another study set? (yes or no)");
		
		String yes = "yes";
		String no = "no";
		
		String continueResponse = in.next();
		
		while (true) {
			if (continueResponse.equals(yes)) {
				break;
			}
			if (continueResponse.equals(no)) {
				break;
			}
			System.out.println("Please input \"yes\" or \"no\"");
			continueResponse = in.next();
		}
		
		if (continueResponse.equals(yes)) {
			correctCount = 0;
			incorrectCount = 0;
			quiz();
		}
		else {
			System.exit(0);
		}
	}
}