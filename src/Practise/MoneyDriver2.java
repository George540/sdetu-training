package Practise;

public class MoneyDriver2 {

	public static void main(String[] args) {
		Money[] bank = new Money[4];
		bank[0] = new Money(10, 10);
		bank[1] = new Money(20);
		bank[2] = new Money();
		bank[3] = new Money(bank[0]);
		
		System.out.println("The account at bank[3] has " + bank[3].toString());
		// bank[2] = bank[0].add2(bank[1]);
		bank[2] = Money.add1(bank[0], bank[1]);

	}

}
