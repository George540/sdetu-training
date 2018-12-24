package PlantGameNancy;

// Used in the Driver LetsPlay

import java.util.Random;

public class Dice {
	
	// 2 attributes: Two integers which record the value for each die. A die has a range from 1 to 6. There are 2 dice
	private int d1;
	private int d2;
	
	// Importing the random class for random number picking for dice
	private Random rand = new Random();
	
	// Default constructor: sets the value of each die to zero
	public Dice() {
		d1 = 0;
		d2 = 0;
	}
	
	// Getter for die 1
	public int getd1() {
		return d1;
	}
	
	// Getter for die 2
	public int getd2() {
		return d2;
	}
	
	// Method that rolls the dice and records the sum
	public int rollDice() {
		d1 = (int)rand.nextInt(6)+1;
		d2 = (int)rand.nextInt(6)+1;
		return d1+d2;
	}
	
	// Concatenates the recorded value of each die
	public String toString() {
		return ("(Die 1: " + d1 + " " + "Die 2: " + d2 + ")");
	}
}
