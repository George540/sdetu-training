package Practise;

public class MoneyDriver1 {

	public static void main(String[] args) {
		Money m1 = new Money(10, 10);
		Money m2 = new Money(20);
		Money m3 = new Money();
		Money m4 = new Money(m1);
		
		System.out.println("We have " + Money.getCount() + " accounts created");
		System.out.println("There are " + m1.toString() + " in account m1");
		System.out.println("There are $" + m2.getDollars() + "." + m2.getCents() + " in account m2");
		m1 = m1.add2(new Money(3, 50));
		m2 = m2.minus1(m2, new Money(5, 0));
		System.out.println("After add2: " + m1);
		System.out.println("After minus1: " + m2);
		System.out.println("The objects m1 and m2 equals is: " + m1.equals(m2));
		System.out.println("The objects m3 and m4 equals is: " + m3.equals(m4));
		
	}

}
