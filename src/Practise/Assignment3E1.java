package Practise;

import java.util.Scanner;
import java.util.Random;

// George Mavroeidis (40065356), 13 November of 2018

// In this java program, a tournament generator was made by using arrays and loops. The goal is to generate as many tournaments until the user's input team has won a game.
// A tournament consists of round of 16, quarter finals, semi finals and finals (total of 15 rounds per tournament).
// The goal statistics are also presented by listing the total amount of goals for each match, per tournament.
// The average goals for each tournament is calculated, as well the average of all goals in all the tournaments generated.
// Finally, the total amount of matches in all tournaments over the average goal value is calculated.

public class Assignment3E1 {

	public static void main(String[] args) {
		// Welcoming Banner
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|---------------------------- Welcome to the... -------------------------------|");
		System.out.println("|------------------------- SOCCER SIMULATOR 2018! -----------------------------|");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|______________________________________________________________________________|");
		System.out.println();
		System.out.println("Your goal is to enter a team and wish that you win before the 20th tournament!");
		System.out.println("You will be able to see the roadmap and the goal statistics for all tournaments.");
		System.out.println();
		
		
// ------------------------------------------------- VARIABLE DECLARATION ----------------------------------------------------------------------------------------------------------------------------------------------
		//Initial String that has all the teams: used for Round of 16
		String[] teams16 = {"Uruguay", "Portugal", "France", "Argentina", "Brazil", "Mexico", "Belgium", "Japan", "Spain", "Russia", "Croatia", "Denmark", "Sweden", "Switzerland", "Colombia", "England"};
		// String that stores the winners from the RO16. The winner of the first game is stored to the first index
		String[] quarter = new String[8];
		// String that stores the winners from the quarters. The winner of the first game is stored to the first index
		String[] semi = new String[4];
		// String that stores the winners from the semi-finals. The winner of the first game is stored to the first index
		String[] fin = new String[2];
		
		// User enters his favorite team. The generator will tell if the team is in the list, then it will show how many tournaments it took for it to win
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your favourite team: ");
		String team = keyboard.next();
		System.out.println();
		System.out.println();
		System.out.println("|---------------------------------------------------------------------------------------------|");
		System.out.println("GAME RESULTS:");
		System.out.println();
		
		// Initialize the amount of tournaments
		int tourn = 20;
		// p1 and p2 are the random goal generators for a game of 2 teams
		Random p1 = new Random();
		Random p2 = new Random();
		// if there is a tie, create a sudden death situation (0 or 1), where ,randomly, a team is chose to score an extra goal.
		Random win = new Random();
		// store value win into a new variable for easier comparisons
		int w = 0;
		// The winner of each TOURNAMENT is stored in the winner value
		String winner = null;
		// 2D array containing the goal for each game, for each tournament
		int[][] goals = new int[tourn][15];
		
		// Initialize sum and average, used to calculate average goals of each tournament
		double sumGoals = 0;
		double average = 0;
		double sumAverages = 0;
		double totalAverages;
		
		// Total matches in all tournaments over the average goal value. Will be incremented if this condition is true
		int matches = 0;
		
		// Boolean value that checks if the team the player entered is in the list. This is checked first before any other steps are done.
		boolean check = false;
		
// ------------------------------------------------- GENERATOR PROGRAM ---------------------------------------------------------------------------------------------------------------------------------------------
		
		// Check if Team is in list. Iterates through array teams16 to find a string that equals to the input. If it is, the game starts. If it's not, a goodbye message is printed.
		for (int i = 0; i < teams16.length; i++) {
			if (team.equalsIgnoreCase(teams16[i])) {
				check = true;
				break;
			}
			else
				check = false;
		}

// ------------------------------------------------- TEAM IS ON LIST ---------------------------------------------------------------------------------------------------------------------------------------------
		
		// If true, the generator does its work
		if (check == true) {
			// Iterate tournaments "tourn" until the winner of the tournament matches with the user's team OR until 20 tournaments have been played
			for(tourn = 0; tourn < 20 && !team.equalsIgnoreCase(winner); tourn++) {
				
				// There are indexes t0(RO16), t1(QUARTER), t2(SEMI) that iterate through each play within a round
				System.out.print("ROUND OF 16");
				// indexes j, n, t, r will be incremented by 2, since the team in j+1 has been paired with j. So we try to pair every odd-indexed team with the team on its right(even).
				for (int j = 0, t0 = 0; j < teams16.length; j +=2, t0++) {
					// G1 and g2 are (Random)variables that store the goals of the two teams playing in a match
					int g1 = (int)p1.nextInt(5);
					int g2 = (int)p2.nextInt(5);
					
					// For RO16, to make it more visually appealing, I split the scoreboard and paste the second half in a new line.
					if (j == 8)
						System.out.print("\n\t   ");
					
					{
					// This is where a coin "win" is "flipped" to give 1 or 0. This randomely gives a goal to a team IF there is a tie.
					if (g1 == g2) {
						w = (int)win.nextInt(2);
						if (w == 1)
							g1++;
						else if (w == 0)
							g2++;
					}
					if (g1 > g2)
						quarter[t0] = teams16[j];
					else if (g2 > g1)
						quarter[t0] = teams16[j+1];
					
					// Store total amount of goals for each MATCH in the 2D array "goals"
					goals[tourn][t0] = g1 + g2;
					}
					// Since teams in indexes i and i+1 are playing against each other, we print them with indexes i and i+1.
					System.out.print("[" + teams16[j] + " " + g1 + ":" + g2 + " " + teams16[j+1] + "]" + " ");
					
					// Steps within QUARTER FINALS and SEMI FINALS won't be explained since they have similarities with ROF16.
					
				}
				System.out.println();
				
				System.out.print("QUARTER FINALS");
				for (int n = 0, t1=0; n < quarter.length; n +=2, t1++) {
					int g1 = (int)p1.nextInt(5);
					int g2 = (int)p2.nextInt(5);
					
					{
					if (g1 == g2) {
						w = (int)win.nextInt(2);
						if (w == 1)
							g1++;
						else if (w == 0)
							g2++;
					}
					if (g1 > g2)
						semi[t1] = quarter[n];
					else if (g2 > g1)
						semi[t1] = quarter[n+1];
					
					// ROF16 has 8 rounds, so the QUARTER FINALS will store total goals in the array AFTER the 8th index of goals.
					goals[tourn][t1+8] = g1 + g2;
					}
					System.out.print("[" + quarter[n] + " " + g1 + ":" + g2 + " " + quarter[n+1] + "]" + " ");
					
				}
				System.out.println();
				
				System.out.print("SEMI FINALS");
				for (int t = 0, t2=0; t < semi.length; t +=2, t2++) {
					int g1 = (int)p1.nextInt(5);
					int g2 = (int)p2.nextInt(5);
					
					{
					if (g1 == g2) {
						w = (int)win.nextInt(2);
						if (w == 1)
							g1++;
						else if (w == 0)
							g2++;
					}
					if (g1 > g2)
						fin[t2] = semi[t];
					else if (g2 > g1)
						fin[t2] = semi[+1];
					
					// QUARTER FINALS have 4 rounds, so the SEMI FINALS will store total goals in the array AFTER the 8+4=12th index of goals.
					goals[tourn][t2+12] = g1 + g2;
					}
					System.out.print("[" + semi[t] + " " + g1 + ":" + g2 + " " + semi[t+1] + "]" + " ");
					
				}
				System.out.println();
				
				// Since the FINAL has 1 match, there is no need to iterate through each match.
				// Instead of storing the winner into an array like the other rounds, it will be stored into a variable "winner", since there is only one team winning.
				System.out.print("FINAL");
				for (int r = 0; r < fin.length; r +=2) {
					int g1 = (int)p1.nextInt(5);
					int g2 = (int)p2.nextInt(5);
					
					{
					if (g1 == g2) {
						w = (int)win.nextInt(2);
						if (w == 1)
							g1++;
						else if (w == 0)
							g2++;
					}
					if (g1 > g2)
						winner = fin[r];
					else if (g2 > g1)
						winner = fin[r+1];
					
					// Since there is only 1 game, the total goals will be saved in the LAST(index 14) of the array goals
					goals[tourn][14] = g1 + g2;
					}
					System.out.print("[" + fin[r] + " " + g1 + ":" + g2 + " " + fin[r+1] + "]" + " ");
					
				}
				// The winner of the FINAL round will be printed.
				System.out.println();
				System.out.println("Tournament: " + tourn + " The WINNER is: " + winner);
				System.out.println();
				
			}
			

			
			// We ignore cases when a user enters a team, so for example, if a user entered "japan" or "jAPAN", we put the first letter in Upper Case and the rest in lower case: "Japan".
			String printedteam = team.substring(0, 1).toUpperCase() + team.substring(1).toLowerCase();
			// If statement that prints the appropriate statement on whether the user's team won in less than 20 tournaments or lost in all 20.
			if (tourn >= 20 && !winner.equalsIgnoreCase(team))
				System.out.println("Sorry, " + printedteam + " didn't win in 20 tournaments!");
			else if (winner.equalsIgnoreCase(team))
				System.out.println("It took " + tourn + " tournament(s) of the game for " + winner + " to win!!!");

            // --------------------------------------- GOAL STATISTICS ---------------------------------------------------------------------------------------------------------------------------------------------
			
			System.out.println();
			System.out.println("|---------------------------------------------------------------------------------------------|");
			System.out.println("GOAL STATISTICS:");
			System.out.println();
			
			// Variable teamgoals that saves the length(amount of tournaments) of the 2D array goals.
			int teamgoals = goals[tourn-1].length;
			// New 1D array that has the length of the tournaments. Each of this array's indexes has the total goals for EACH match in ALL tournaments.
			// A tournament has 15 matches.
			int[] goalSum = new int[15];
			int b = 0;
			
			// Initializing a variable that will store the sum of averagers with 1 decimal point, which is also used AFTER and OUTSIDE the loop
			double sumAve = 0;
			
			// Printing loop that lists how many tournaments have been played.
			for (int a=0; a < tourn; a++) {
				System.out.print("[Tournament " + a + "]: Total goals: [");
				// Printing loop that prints the total goals for EACH match.
				for(b=0; b < 14; b++) {
					goalSum[b] = goals[a][b]; 
					System.out.print(goalSum[b] + ", ");
				}
				// Adding goal sum of finals outside of the loop for seperate printing statement
				goalSum[b] = goals[a][b];
				// For every tournament, the sum of the goals is initialized to 0 so it can start counting the average for a new tournament instead of using the existing average from the previous tournament.
				sumGoals = 0;
				// Printing loop that stores all the goals in each tournament in a value
				for(int c = 0; c < goalSum.length; c++)
					sumGoals += goalSum[c];
				
				// ave = average goals for each TOURNAMENT
				double ave = sumGoals/15;
				// average = keep only one digit of the ave
				average = ((int)(ave*10.0))/10.0;
				
				System.out.print(goalSum[b] + "]  [Average: " + average + "]");
				System.out.println();
				 
				// Store all averages from each tournament in another variable called sumAverages
			    sumAverages += average;
			    // Store sum of averages with 1 decimal point
			    sumAve = ((int)(sumAverages*10.0))/10.0;
			}
			
			// Find the average of the averages. This is done by (sum of averages/ amount of tournaments).
			totalAverages = ((int)((sumAve/tourn)*10.0))/10.0;
			
			System.out.println();
			System.out.println("Average goals for " + tourn + " tournament(s): " + totalAverages);
			
			// Loop that checks if a match is over the average goal value. I made a new nested loop, because if I plugged it in the nested loop with index a
			// the value totalAverages wasn't calculated by that time.
			for (int g = 0; g < tourn; g++) {
				for (int f=0; f<teamgoals; f++) {
					if (goalSum[f] > totalAverages) 
						matches++;
				}
			}
			System.out.println("Total matches in all tournaments over the average goal value: " + matches);
		}

// ------------------------------------------------- TEAM NOT ON LIST ---------------------------------------------------------------------------------------------------------------------------------------------
		
		// If the user entered a team or another string that does not match with the teams (ignoring cases), print a goodbye message.
		else
			System.out.println("Your team is not in the Round of 16.");
		
		// close keyboard
		keyboard.close();
		
		// Closing Banner
		System.out.println();
		System.out.println();
		System.out.println("|---------------------------------------------------------------------------------------------|");
		System.out.println("|___________________________ Program is ending. Have a nice day! _____________________________|");
	}

}
