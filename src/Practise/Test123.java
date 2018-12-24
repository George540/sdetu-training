package Practise;

import java.util.Scanner;

public class Test123 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int num = keyboard.nextInt();
		int number = num;
		int initial = 0;

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print(initial+1 + "\t");
			}
			initial = initial + 1;
			System.out.println();
		}
		
		for (int k = 1; k < num; k++) {
			for (int n = num; n > k; n--) {
				System.out.print(number-1 + "\t");
			}
			number = number - 1;
			System.out.println();
		}
		
		keyboard.close();

	}

}
