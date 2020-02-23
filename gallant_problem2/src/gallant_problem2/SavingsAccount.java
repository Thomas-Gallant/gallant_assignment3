package gallant_problem2;

public class SavingsAccount {

	
	private static double annualIntrestRate;
	
	private double savingsBalance;
	
	public SavingsAccount(double balance) {
		this.savingsBalance = balance;
	}
	
	public double getSavings() {
		return savingsBalance;
	}
	public void calculateMonthlyIntrest() {
		savingsBalance = savingsBalance + (savingsBalance * annualIntrestRate / 12.0);
	}
	
	public static void modifyIntrestRate(double newInterestRate) {
		annualIntrestRate = newInterestRate;
	}
}
