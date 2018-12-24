package Practise;

//-----------------------------------------------------------
//Assignment 2 - Part 1:
//Written by: (George Mavroeidis 40065356)
//For COMP 248 Section R - Fall 2018
//-----------------------------------------------------------

/* In this program, I created an evaluator for the English language proficiency of students.
First, they choose if they want to check the requirements for the University(1) or Evaluate themselves(2).
If they choose (1), they get information regarding the requirements and the IELTS exam.
If they choose (2), they give their scores and depending on the overall, reading and writing score, they get different levels of eligibility.
*/
import java.util.Scanner;

public class Assignment2E1 {

	public static void main(String[] args) {
		// Program is starting
		System.out.println("-------****-------****-------****-------****-----****------");
		System.out.println("   Welcome to Concordia Language Proficiency Evaluator!    ");
		System.out.println("                   based on IELTS exam                     ");
		System.out.println("-------****-------****-------****-------****-----****------");
		
		System.out.println();
		
		// User chooses between evaluation and requirements
		System.out.println("Here are the available options:");
		System.out.println("             1 – Language Proficiency Requirements for the Applicant ");
		System.out.println("             2 – Evaluation of your language proficiency");
		
		System.out.println();
		
		// Let user choose by user input
		// Cases: integer that gives 3 choices: (1) requirements, (2) evaluation, (3) Try again?(1/2)
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the digit corresponding to your case: ");
		int cases = keyboard.nextInt();
		
		// If the user wrote 1: Give information on admission for Concordia and the IELTS exam
		if (cases == 1) {
			System.out.println();
			System.out.println("- The overall score of IELTS exam of applicants needs to be equal or above 6.5 and the scores");
			System.out.println("for writing and reading skills should not be below 6.0. If your overall score is 6, and your ");
			System.out.println("reading and writing scores are at least 6, you will be eligible for conditional admission. So ");
			System.out.println("you need to take an English course in the first semester. Otherwise you have to retake the IELTS ");
			System.out.println("exam.");
			System.out.println("Thanks for choosing Concordia.");
		}
		
		// If the user wrote 2: Let user give score and depending on the results, give statement about admission.
		// Score can be either whole or half bands(range: 1-9)
		// Scores are converted to doubles
		else if (cases == 2) {
			System.out.println();
			// Listening score
			System.out.print("Please enter your listening score: ");
			double listening = keyboard.nextDouble();
			System.out.println();
			// Speaking score
			System.out.print("Please enter your speaking score: ");
			double speaking = keyboard.nextDouble();
			System.out.println();
			// Reading score
			System.out.print("Please enter your reading score: ");
			double reading = keyboard.nextDouble();
			System.out.println();
			// Writing score
			System.out.print("Please enter your writing score: ");
			double writing = keyboard.nextDouble();
			
			// Overall(Average) = (All 4 inputs)/amount of scores given(4 in this case)
			double overall = (listening + speaking + reading + writing) / 4.0;
			
			// Check bellow for method on rounding overall score to nearest half band
			System.out.println();
			System.out.println("          Your overall score is: " + RoundToHalf(overall));
			System.out.println("          Your reading score is: " + reading);
			System.out.println("          Your writing score is: " + writing);
			System.out.println();
			
			
			// Condition 1
			if (RoundToHalf(overall) >= 6.5 && (reading >= 6.0 && writing >= 6.0))
				System.out.println("Congratulations: You are eligible for Admission.");
			
			// Condition 2
			else if (RoundToHalf(overall) >= 6.5 && (reading < 6.0 || writing < 6.0)) {
				System.out.println("You are eligible for Conditional Admission.");
				
			// Condition 3
			}
			else if (RoundToHalf(overall) == 6 && (reading >= 6.0 && writing >= 6.0)) {
				System.out.println("You are eligible for Conditional Admission.");
				
			// Condition 4
			}
			else if (RoundToHalf(overall) == 6.0 && (reading < 6.0 || writing < 6.0)) {
				System.out.println("Sorry, you have to retake the exam.");
				
			// Condition 5
			}
			else if (RoundToHalf(overall) < 6.0) {
				System.out.println("Sorry, you have to retake the exam.");
			}
			
			
		}
		
		// If the user wrote other inputs instead of 1 or 2: Give a statement on trying again
		else
			System.out.println("You did not enter the correct input. Please try again (1/2).");
		
		keyboard.close();
	}
	
	
	// Temporary: Method on rounding the overall score to the nearest half band
	public static double RoundToHalf(double overall) {
	    return Math.round(overall * 2) / 2.0;
	}

}
