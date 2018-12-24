package Practise;

//-----------------------------------------------------------
//Assignment 2 - Part 2:
//Written by: (George Mavroeidis 40065356)
//For COMP 248 Section R - Fall 2018
//-----------------------------------------------------------

/* In this program, I made a simple game-like calculator. The user gives an input of an integer with at most 7 digits.
Two calculations were performed. One to give the sum of the digits and one to give the divisors of the sum. Both calculations
used while loops. The program printed the sum of the digits and later gave a list of the divisors of that sum. In the end, the user
was given a choice to whether he'd like to try another number or not. This was done with a do-while loop containing both while loop
calculations inside. If he said yes, the program would ask again for an input number. If no, he got a nice little message saying goodbye.
*/

import java.util.Scanner;

public class Assignment2E2 {

	public static void main(String[] args) {
		
		// Initialize sum variable
		int sum = 0;
		// Asking user to give a string input
		Scanner keyboard = new Scanner (System.in);
		String answer = "yes";
		
		
		do
		{
			while (answer.equalsIgnoreCase("yes"))
			{
				// User input variable for number with at most 7 digits
				System.out.print("Enter a number with at  most 7-digits: ");
				int number = 0;
				keyboard.nextInt();
				// Initialize count (amount of digits summed)
				int count = 0;
				
				// Assign number into another variable for printing after the loop
				int main = number;
				
				/*
				For every loop, the last digit of the number is removed and added to the sum.
				It loops until there are no more digits left.
				Conditions of while loop: The number assigned by user is a positive intiger and it is at most 7 digits.
				If number assigned has more than 7 digits, the loop does not work.
				*/
				while (number > 0 && number < 1000000) {
					sum = sum + number % 10;
					number = number / 10;
					count++;
				}
				System.out.println();
				System.out.println("Sum of the digits of " + main + " is " + sum);
				
				// Initialize variables for divisors and remainder
				// Divisor is initialized at 1 because 0 is not a divisor (gives an error)
				int divisor = 1;
				int remainder = 0;

				System.out.println();
				System.out.println("The divisors of " + sum + " are as follows:");
				
				// A divisor can't be bigger than its divident(sum).
				// In this loop, every number is tested from 1 up to the sum itself.
				// If that divisor gives a remainder of 0, it is printed in the list of the sum's divisors.
				// If not, it's just ignored and the loop tests the next intiger by incrementation.
				while(divisor <= sum) {
					remainder = sum % divisor;
					if (remainder == 0)
						System.out.print(divisor + "\t");
					divisor++;
				}
				
				System.out.println();
				System.out.println("\n"+ "Do you want to try another number? (yes to repeat, no to stop)");
				answer = keyboard.next();
			}
		} while (!answer.equalsIgnoreCase("no"));
		
		keyboard.close();
		// If the user wrote no, the following message would print.
		System.out.println();
		System.out.println("Thanks and Have a Great Day!");
	}
}
