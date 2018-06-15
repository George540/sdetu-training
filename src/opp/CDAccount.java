package opp;

public class CDAccount extends BankAccount implements IRate {
	
	String interestRate;
	
	void compound() {
		System.out.println("Compound interest");
	}

}
