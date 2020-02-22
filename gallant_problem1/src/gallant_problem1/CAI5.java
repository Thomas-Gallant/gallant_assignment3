package gallant_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {

	public static void main(String[] args) {
		
		CAI5 quiz = new CAI5();
		quiz.quiz();
	}
	
	private static Scanner in = new Scanner(System.in);
	private static SecureRandom randomNumbers = new SecureRandom();
	
	public int correctCount;
	public int incorrectCount;
	
	public double numOne;
	public double numTwo;

	
	public void quiz() {
		
		int questionDifficulty = readDifficulty();
		int problemType = readProblemType();
		for (int i = 0; i < 10; i++) {
			generateQuestionArguement(questionDifficulty);
			double correctAnswer = askQuestion(problemType);
			double userAnswer = readResponse();
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
			if (questionDifficulty >= 1 && questionDifficulty <= 4) {
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
	
	public int readProblemType() {
		
		System.out.println("Please input problem type of 1, 2, 3, 4, or 5");
		
		while (!in.hasNextInt()) {
            String input = in.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
		
		int problemType = in.nextInt();
		
		while (true) {
			if (problemType >= 1 && problemType <= 5) {
				return problemType;
			}
			
			else {
				
				while (!in.hasNextInt()) {
		            String input = in.next();
		            System.out.printf("\"%s\" is not a valid number.\n", input);
		        }
				
				problemType = in.nextInt();
			}
		}
	}
	
	public void generateQuestionArguement(int questionDifficulty) {
		switch (questionDifficulty) {
		
			case 1:
				numOne = 0 + randomNumbers.nextInt(10);
				numTwo = 0 + randomNumbers.nextInt(10);
				break;
			case 2:
				numOne = 0 + randomNumbers.nextInt(100);
				numTwo = 0 + randomNumbers.nextInt(100);
				break;
			case 3:
				numOne = 0 + randomNumbers.nextInt(1000);
				numTwo = 0 + randomNumbers.nextInt(1000);
				break;
			case 4:
				numOne = 0 + randomNumbers.nextInt(10000);
				numTwo = 0 + randomNumbers.nextInt(10000);
				break;
		}
	}
	
	public double askQuestion(int problemType) {
	
		switch (problemType) {
		
		case 1:
			System.out.println("How much is " + numOne + " + " + numTwo + "?");
			return numOne + numTwo;

		case 2:
			System.out.println("How much is " + numOne + " x " + numTwo + "?");
			return numOne * numTwo;
			
		case 3:
			System.out.println("How much is " + numOne + " - " + numTwo + "?");
			return numOne - numTwo;
			
		case 4:
			if (numTwo == 0) {
				numTwo = 1;
			}
			System.out.println("How much is " + numOne + " / " + numTwo + " to one decimal place?");
			return Math.round(numOne / numTwo * 10) / 10.0;
			
		case 5:
			
			int questionType = 1 + randomNumbers.nextInt(4);
			switch (questionType) {
			
			case 1:
				System.out.println("How much is " + numOne + " + " + numTwo + "?");
				return numOne + numTwo;

			case 2:
				System.out.println("How much is " + numOne + " x " + numTwo + "?");
				return numOne * numTwo;
				
			case 3:
				System.out.println("How much is " + numOne + " - " + numTwo + "?");
				return numOne - numTwo;
				
			case 4:
				if (numTwo == 0) {
					numTwo = 1;
				}
				System.out.println("How much is " + numOne + " / " + numTwo + "  to one decimal place?");
				return Math.round(numOne / numTwo * 10) / 10.0;
			}
		}
		return 0;
		
	}

	public double readResponse() {
		
		while (!in.hasNextDouble()) {
            String input = in.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
		
		double userAnswer = in.nextDouble();
		return userAnswer;
	}
	
	public void isAnswerCorrect(double correctAnswer, double userAnswer) {
		
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