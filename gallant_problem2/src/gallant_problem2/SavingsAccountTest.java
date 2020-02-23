package gallant_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {
		
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		
		SavingsAccount.modifyIntrestRate(0.04);
		
		for (int i = 1; i < 13; i++) {
			saver1.calculateMonthlyIntrest();
			saver2.calculateMonthlyIntrest();
			double saver1Savings = saver1.getSavings();
			double saver2Savings = saver2.getSavings();
			System.out.printf("%.2f$ is the monthly balance for saver1 month %d\n", saver1Savings, i);
			System.out.printf("%.2f$ is the monthly balance for saver2 month %d\n", saver2Savings, i);
			System.out.println();
		}
		
		
		SavingsAccount.modifyIntrestRate(0.05);
		
		saver1.calculateMonthlyIntrest();
		saver2.calculateMonthlyIntrest();
		double saver1Savings = saver1.getSavings();
		double saver2Savings = saver2.getSavings();
		System.out.printf("%.2f$ is the monthly balance for saver1 month 13\n", saver1Savings);
		System.out.printf("%.2f$ is the monthly balance for saver2 month 13\n", saver2Savings);

	}

}
