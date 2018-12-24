package Practise;

import java.util.Scanner;

public class RectangleArea {

	public static void main(String[] args) {
		System.out.println("Program is starting.");
		System.out.println();
		
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter the rectangle's length in meters: ");
		double length = keyboard.nextDouble();
		System.out.println("Enter the rectangle's width in meters: ");
		double width = keyboard.nextDouble();
		
		double area = length*width;
		
		System.out.println();
		System.out.println("The length of the rectangle is: " + length + " m");
		System.out.println("The width of the rectangle is: " + width + " m");
		System.out.println();
		System.out.println("The area of the rectangle is: " + area + " m^2");
		System.out.println();
		System.out.println("Program is ending.");

	}

}
