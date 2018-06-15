package Basics;

public class SalaryCalculator {
	public static void main(String[] args) {
		// Let's Create a variable to define our career
		
		// Declare a variable
		String career;
		System.out.println("Program is starting");
		
		// Declare & Define
		career = "Software Developer";
		System.out.println("My career: " + career);
		
		// Declare & Define
		int hoursPerWeek = 40;
		int weeksPerYear = 50;
		double rate = 42.50;
		
		double salary = hoursPerWeek * weeksPerYear * rate;
		System.out.println("My salary as a " + career + " at the rate of $" + rate + " per hour is $" + salary + " per year.");
		
		// Computer our annual salary
		// rate * hoursPerWeek * weeksPerYear
	}

}
