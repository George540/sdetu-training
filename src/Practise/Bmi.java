package Practise;

// -----------------------------------------------------------
// Assignment 1:
// Written by: (George Mavroeidis 40065356)
// For COMP 248 Section R - Fall 2018
// -----------------------------------------------------------


// In this program, I calculated the BMI of the user. I asked them their weight and height by importing the scanner utility for keyboard input. Then, I calculated their BMI, using a formula. Finally, I printed the height, weight and BMI all together, once the user was done entering both inputs.

import java.util.Scanner;

public class Bmi {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your weight in kilograms: ");
		double weight = keyboard.nextDouble();
		System.out.print("Enter your height in meters: ");
		double height = keyboard.nextDouble();
		
		double BMI = weight/(height*height);

		System.out.println();
		System.out.println("Your weight: " + weight + " kg");
		System.out.println("Your height: " + height + " m");
		System.out.println();
		System.out.println("Your BMI: " + BMI + " kg/m^2");
		System.out.println();
		System.out.println("********** Thanks for using the best BMI calculator ever. **********");
		
		keyboard.close();
	}

}
