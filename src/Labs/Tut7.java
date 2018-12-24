package Labs;

import java.util.Arrays;
import java.util.Scanner;

public class Tut7 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Question 1:");
		double sum = 0;
		boolean sign = true;
		
		for (int i = 1; i <= 1000; i+=2)
				if (sign == true)
					sum = sum + 1.0/i;
				else if (sign == false) {
					sum = sum - 1.0/i;
					sign = !sign;
			}
		System.out.println(4*sum);
		
		System.out.println();
		System.out.println();
		
		
		
		/* System.out.println("Question 2:");
		int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.print("Enter an integer: ");
		int element = keyboard.nextInt();
		
		for (int c = 0; c < element; c++) {
			System.out.println(myArray[c] + " ");
		}
		*/
		
		System.out.println();
		System.out.println();
		
		/* for (int l = 1; l<=100; l++)
			if (l%3 == 0) {
				if (l%5 == 0) System.out.println("FizzBuzz");
				else System.out.println("Fizz");
			}
			else if (l%5 == 0) System.out.println("Buzz");
			else System.out.println(l);
		*/
		
		for (int a = 1; a<=9; a++) {
			for (int b=1; b<=9; b++) System.out.print(a*b + "\t");
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		String s = "Ifmmp!Xpsme";
		for (int i=0; i<s.length(); i++) {
			String before  = s.substring(0, i);
			String after = s.substring(i+1, s.length());
			s = before + (char)(s.charAt(i) - 1) + after;
		}
		System.out.println(s);
			
		

	}

}
