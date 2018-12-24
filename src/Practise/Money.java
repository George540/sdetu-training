package Practise;

public class Money {
	private int dol;
	private int cnts;
	private static int count = 0;
	
	public Money(int dollars, int cents) {
		dol = dollars;
		cnts = cents;
		count++;
	}
	
	public Money(int dollars) {
		dol = dollars;
		cnts = 0;
		count++;
	}
	
	public Money() {
		dol = 0;
		cnts = 0;
		count++;
	}
	
	// Copy constructor
	public Money(Money m) {
		dol = m.dol;
		cnts = m.cnts;
		count++;
	}
	
	public void setDollars(int dollars) {
		this.dol = dollars;
	}
	
	public int getDollars() {
		return dol;
	}
	
	public void setCents(int cents) {
		this.cnts = cents;
	}
	
	public int getCents() {
		return cnts;
	}
	
	public static int getCount() {
		return count;
	}
	
	public Money add2(Money m) {
		// Anonymous Object
		return new Money(this.dol + m.dol, this.cnts + m.cnts);
	}
	
	public Money minus2(Money m) {
		return new Money(this.dol - m.dol, this.cnts - m.cnts);
	}
	
	public static Money add1(Money m1, Money m2) {
		// m3 = Money.add1(m1, m2);
		return new Money(m1.dol + m2.dol, m1.cnts + m2.cnts);
	}
	
	public static Money minus1(Money m1, Money m2) {
		return new Money(m1.dol - m2.dol, m1.cnts - m2.cnts);
	}
	
	public String toString() {
		return("$" + dol + "." + cnts);
	}
	
	public boolean equals(Money m) {
		return ((dol == m.dol) && (cnts == m.cnts));
	}
}
