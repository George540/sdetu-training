package Labs;

import java.util.Scanner;

public class DivAndModCalculator {

	public static void main(String[] args) {
		// num = (divisor)(quotient) + remainder
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a divisor: ");
		int num = keyboard.nextInt();
		System.out.print("Enter a quotient: ");
		int quotient = keyboard.nextInt();
		
		int remainder = num % quotient;
		System.out.println("The remainder is: " + remainder);
		

	}

}
