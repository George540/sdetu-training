package Labs;

import java.util.Scanner;

public class Lab4 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Boolean repeat = false;
		String str;
		System.out.print("Enter a string: ");
		
		do {
			str = keyboard.nextLine();
			if (str.charAt(0) != 'C' || !str.contains("248") || str.length() % 2 != 0) {
				repeat = true;
				System.out.print("Invalid string, try again: ");
			}
			else {
				repeat = false;
			}
		} while (repeat == true);
		
		System.out.println("Output:");
		System.out.println(str);
		
		int length = str.length();
		int i = 0;
		
		while (i <= length && str.length() > 0)
		{
			str = str.substring(1, str.length());
			System.out.println(str);
			i++;
		}
	}
}
