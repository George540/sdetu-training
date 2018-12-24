package Labs;

import java.util.Scanner;

public class Lab52 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		String Input = keyboard.next();
		
		int strLength = Input.length();
		
		for (int i = 0; i <= strLength; i++) {
			for (int k = 0; k < 5 - i; k++)
				System.out.print(" ");
			for (int n = 0; n < i; n++)
				System.out.print(Input.charAt(strLength-1-n) + "\t");
		System.out.println();
		}

	}

}
