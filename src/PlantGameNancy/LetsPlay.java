package PlantGameNancy;

//-----------------------------------------------------------
//Assignment 4: Nancy's Crazy Garden Game
//Written by: (George Mavroeidis 40065356)
//For COMP 248 Section R - Fall 2018
//-----------------------------------------------------------

/* In this program, a simple video game was made. The goal for the players in the game is to fill up their garden first.
 * Whoever fills it first, wins. A player rolls the dice and depending on what they roll, they must do certain actions,
 * A player can plant a 2x2 tree, a 1x2 flower, miss his turn or has a rabbit eat part of his garden.
 * Before the game starts, the system asks for garden sizes, player amount, user names and a roll of dice to determine who starts first.
 * In the end of the game, the winner is determined and the results for each player are listed.
 */

// Scanner class for user input and Random class for assigning random values to certain attributes.
import java.util.Scanner;
import java.util.Random;

public class LetsPlay {

	// Determines the size of the gardens
	static int size = 0;
	// If the player sets the default size, the size of the garden becomes 3x3. It is a FINAL unchanged variable.
	static final int DEFAULT = 3;
	// Scanner key for user input (strings and numbers)
	static Scanner keyboard = new Scanner(System.in);
	// Defines default or not garden size
	static int def = 0;
	// Sets the amount of players asked by user
	static int playerAmount;
	// Saves index of who goes first
	static int temp = 0;
	// Array of type Player. Saves data for each player assigned
	static Player[] players;
	// String that saves user's name
	static String username;
	// Class Dice
	static Dice playerDice = new Dice();
	// Array which saves the rolls of each player in order to determine who goes first by comparison.
	// Also has the same length as the players[] array. Each of the player[]'s array user name matches with the first[]'s roll.
	static int[] first;
	// Saves index of the player who goes first. Saved as static in order to be used for other methods
	static int firstPlayer;
	// Saves temporarily the roll of each player during the game.
	// Since it's static, the number of the previous player is replaced by the next one.
	static int tempRoll = 0;
	// Array that saves coordinates entered by user.
	// I personally used an array instead of 2 different static variables. I found it more safe to enter 2 variables in a single object
	static int[] coordinates = new int[2];
	// Temporarily saves player index in order to be used for other methods(ex: checkCoordinates() and enterCoordinates();
	static int playerIndex = 0;
	// Used to enter random coordinates for rabbit
	static Random rabbit = new Random();
	// String that saves the name of the winner after the game has ended
	static String winner;
	// Counts the rounds after each player's turn
	static int roundCounter = 0;
	

// -------------------- Method that checks the garden size -------------------------
	public static void checkGardenSize() {
		System.out.println();
		System.out.println("The default garden size is a 3x3 square. You can use this default board size or change the size");
		System.out.print("Enter 0 to use the default garden size or -1 to enter your own size: ");
		def = keyboard.nextInt();

		// If player entered other than 0  or -1, it asks again for a new input
		while (def != 0 && def != -1) {
			System.out.print("Sorry but " + def + " is not a legal choice. Enter your choice: ");
			def = keyboard.nextInt();
		}
		// Sets garden to default 3x3
		if (def == 0) {
			size = DEFAULT;
		}
		// Sets garden to user input bigger than 3
		else if (def == -1) {
			System.out.print("What size board would you like? (minimum size 3): ");
			size = keyboard.nextInt();
			// If he enters smaller or equal to 3, it asks for new input
			while (size <= 3) {
				System.out.print("Wrong size. Please enter a size bigger than 3: ");
				size = keyboard.nextInt();
			}
		}
	}

// -------------------- Method that asks for player amount -------------------------
	public static void askPlayersAmount() {
		System.out.println();
		System.out.print("How many gardeners will there be (minimum 2 required to play, max allowed 10)? ");
		playerAmount = keyboard.nextInt();

		// If user entered something out of range, new user input is asked
		while (playerAmount < 2 || playerAmount > 10) {
			System.out.print("Wrong amount. Please enter an amount of players within the given range: ");
			playerAmount = keyboard.nextInt();
		}
		// Sets the player amount as the length of the array players[]
		players = new Player[playerAmount];

		// Loop that asks to enter username for each player
		for (int i = 0; i < players.length; i++) {
			System.out.print("      --> Name of player " + (i+1) + " (no spaces allowed): ");
			username = keyboard.next();
			username = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase();
			players[i] = new Player(username, size);
		}
		// Sets the array first[] to the amount of players set earlier
		first = new int[playerAmount];
	}

// -------------------- Method that checks who will play first -------------------------
	public static void whoGoesFirst() {
		System.out.println();
		System.out.println("Let's see who goes first ... ");
		// Boolean that checks if an equal roll was found
		boolean equalFound = false;
		// Boolean that repeats the process if an equal was found
		boolean repeat = false;
		// Saves index of player who had equal roll
		int playerEqual = 0;
		
		do {
			// Loop that assigns a roll to each player. Saved to array first[]
			for (int k = 0; k < players.length; k++) {
				first[k] = playerDice.rollDice();
			}
			
			// Loop that checks if an equal was found
			// For each player selected, it checks its previous players if any of them have an equal roll
			for (int k = 0; k < players.length; k++) {
				System.out.println(players[k].getName() + " rolled a " + first[k]);
				if (k > 0) {
					// Checks if each new roll is bigger than the previous players.
					for (int j = 0; j < k; j++) {
						// If an equal roll was found, it breaks the loop
						if (first[k] == first[j]) {
							equalFound = true;
							playerEqual = j;
							break;
						}
						else {
							equalFound = false;
						}
					}

					// If an equal value was found, the outer loop breaks as well
					if (equalFound == true) {
						repeat = true;
						System.out.println("We will start over as " + first[k] + " was rolled by " + players[playerEqual].getName() + " as well.");
						System.out.println();
						break;
					}
					
					// If no equal was found, do not repeat process and make this the actual process on who goes first
					else if (equalFound == false && k == players.length-1) {
						repeat = false;
						// Initial the maximum roll as the first player
						int max = first[0];
						
						// Loop that checks if each player after the max has a bigger roll
						for (int j = 0; j < players.length; j++) {
							// If indeed a bigger roll was found, set that new player as first by saving his index at attribute "temp"
							if (first[j] > max) {
								max = first[j];
								temp = j;
							}
						}
						System.out.println();
						System.out.println(players[temp].getName() + " goes first");
						firstPlayer = temp;
					}
				}
			}
		} while (repeat == true);
	}

// -------------------- Method that saves user's entered coordinates -------------------------
	private static void enterCoordinates() {
		// Saves coordinates on vertical axis
		coordinates[0] = keyboard.nextInt();
		// Saves coordinates on horizontal axis
		coordinates[1] = keyboard.nextInt();
	}
	
// -------------------- Method that checks the coordinates for flower inputs -------------------------
	private static void checkCoordinatesFlower() {
		// If the coordinates are out of the garden size, enter new ones
		while ((coordinates[0] > size-1 || coordinates[1] > size-1) || (coordinates[0] < 0 || coordinates[1] < 0))  {
			System.out.print("** Sorry either the row or column is not in the range of 0 to 2 or your tree will be off the grid. Try again: ");
			enterCoordinates();
			checkCoordinatesFlower();
		}
		
		// If the coordinates are already taken by another flower, enter new ones
		while (players[playerIndex].whatIsPlanted(coordinates[0], coordinates[1]) == 'f') {
			System.out.println("** Sorry that location is already taken up by a f. ");
			System.out.print("Please enter a new set of coordinates: ");
			enterCoordinates();
			checkCoordinatesFlower();
		}
		
		// If the coordinates are already taken by a tree, enter new ones
		while (players[playerIndex].whatIsPlanted(coordinates[0], coordinates[1]) == 't') {
			System.out.println("** Sorry that location is already taken up by a t. ");
			System.out.print("Please enter a new set of coordinates: ");
			enterCoordinates();
			checkCoordinatesFlower();
		}
	}
	
// -------------------- Method that checks the coordinates for tree inputs -------------------------
	private static void checkCoordinatesTree() {
		// If at least one of the tree's coordinates are out of the garden size, enter new ones
		while ((coordinates[0] < 0 || coordinates[1] < 0) || (coordinates[0]+1 < 0 || coordinates[1] < 0) || (coordinates[0] < 0 || coordinates[1]+1 < 0) || (coordinates[0]+1 < 0 || coordinates[1]+1 < 0))  {
			System.out.print("** Sorry either the row or column is not in the range of 0 to 2 or your tree will be off the grid. Try again: ");
			enterCoordinates();
			checkCoordinatesTree();
		}
		
		// A tree's coordinates range are one dimension smaller than the garden size, or else a part of the tree is out of the garden
		// If at least one of the tree's components are out of the garden, enter new ones
		while ((coordinates[0] > size-2 || coordinates[1] > size-2) || (coordinates[0]+1 > size-1 || coordinates[1] > size-2) || (coordinates[0] > size-2 || coordinates[1]+1 > size-1) || (coordinates[0]+1 > size-1 || coordinates[1]+1 > size-1))  {
			System.out.print("** Sorry either the row or column is not in the range of 0 to 2 or your tree will be off the grid. Try again: ");
			enterCoordinates();
			checkCoordinatesTree();
		}
		
		// If at least one of the tree's components is taken by a flower, enter new coordinates
		while (players[playerIndex].whatIsPlanted(coordinates[0], coordinates[1]) == 'f' || players[playerIndex].whatIsPlanted(coordinates[0]+1, coordinates[1]) == 'f' || players[playerIndex].whatIsPlanted(coordinates[0], coordinates[1]+1) == 'f' || players[playerIndex].whatIsPlanted(coordinates[0]+1, coordinates[1]+1) == 'f') {
			System.out.println("** Sorry that location is already taken up by a f. ");
			System.out.print("Please enter a new set of coordinates: ");
			enterCoordinates();
			checkCoordinatesTree();
		}

		// If at least one of the tree's components is taken by a tree, enter new coordinates
		while (players[playerIndex].whatIsPlanted(coordinates[0], coordinates[1]) == 't' || players[playerIndex].whatIsPlanted(coordinates[0]+1, coordinates[1]) == 't' || players[playerIndex].whatIsPlanted(coordinates[0], coordinates[1]+1) == 't' || players[playerIndex].whatIsPlanted(coordinates[0]+1, coordinates[1]+1) == 't') {
			System.out.println("** Sorry that location is already taken up by a t. ");
			System.out.print("Please enter a new set of coordinates: ");
			enterCoordinates();
			checkCoordinatesTree();
		}
	}

// -------------------- Method that executes the game -------------------------
	public static void theGame() {
		System.out.println();
		System.out.println("Time to play!!!!");
		System.out.println("----------------");
		System.out.println();
		// Checks if winner was found
		boolean winnerFound = false;
		// Repeats round of players if a winner was not found (used for big do-while loop)
		boolean repeatRound = true;


		do {
			// The big for loops contain the same information, the only difference is the iteration
			// The second loop won't contain comments that have already been explained in the first

//FIRST LOOP: LOOPS THROUGH PLAYERS AFTER THE PLAYER WHO STARTED FIRST ----------------------------------------------------------------
			for (int i = temp; i < players.length; i++) {
				System.out.println();
				System.out.println("--------------------------------------------------");
				// Temporarily save the player's roll
				tempRoll = playerDice.rollDice();
				System.out.println(players[i].getName() + " you rolled " + tempRoll + " " + playerDice.toString());
				// Temporarily save player's index to be used to other methods
				playerIndex = i;

				if (tempRoll == 3) {
					System.out.println("You must plant a tree (2x2) and a flower (1x1)");
					System.out.println();
					players[i].showGarden();

					// Condition on whether a player can plant his tree or not
					if (players[i].howManyTreesPossible() > 0) {
						System.out.println("Let's start with the tree. You have " + players[i].howManyTreesPossible() + " places to do this.");
						System.out.print("Enter coordinates as row column: ");
						enterCoordinates();
						checkCoordinatesTree();
						players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
						players[i].showGarden();
					}
					else {
						System.out.println("You have no place to plant your tree.");
					}

					// Condition whether he can plant his flower, regardless on whether he planted his tree or not
					if(players[i].howManyFlowersPossible() > 0) {
						System.out.println("You still have a flower (1x1) flower to plant.");
						players[i].showGarden();
						System.out.println("You now have " + players[i].howManyFlowersPossible() + " places to do this.");
						System.out.print("Enter coordinates as row column: ");
						enterCoordinates();
						checkCoordinatesFlower();
						players[i].plantFlowerInGarden(coordinates[0], coordinates[1]);
						players[i].showGarden();
					}
					
					else {
						System.out.println("You have no place to plant your flower.");
					}
				}

				else if (tempRoll == 6) {
					System.out.println("You must plant 2 flowers (1x1)");
					System.out.println();
					players[i].showGarden();

					System.out.println("You have " + players[i].howManyFlowersPossible() + " places to do this.");

					// Player enters first flower. He definitely has space for it since he was able to roll
					System.out.print("First flower - Enter coordinates as row column: ");
					enterCoordinates();
					checkCoordinatesFlower();
					players[i].plantFlowerInGarden(coordinates[0], coordinates[1]);
					players[i].showGarden();

					// If he still has space for a second flower, he can plant it
					if (players[i].howManyFlowersPossible() >= 1) {
						System.out.println();
						System.out.print("Second flower - Enter coordinates as row column: ");
						enterCoordinates();
						checkCoordinatesFlower();
						players[i].plantFlowerInGarden(coordinates[0], coordinates[1]);
						players[i].showGarden();
					}

					// If he planted a flower already, he might not have room for another one
					// This means that his garden is full and he's most likely the winner
					else if (players[i].howManyFlowersPossible() == 0) {
						System.out.println("Sorry! No room to plant another flower! ");
					}
				}

				else if (tempRoll == 12) {
					System.out.println("You must plant 2 trees (2x2)");

					System.out.println();
					players[i].showGarden();
					players[i].howManyTreesPossible();

					// Condition whether he has space for his 2 trees
					if (players[i].howManyTreesPossible() == 0) {
						System.out.println("You have no room to plant any of the trees! You miss your turn.");
					}

					// He might have space for one tree
					else if (players[i].howManyTreesPossible() == 1) {
						System.out.println("There is enough room for 1 tree in your garden.Enter coordinates as row column: ");
						enterCoordinates();
						checkCoordinatesTree();
						players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
						players[i].showGarden();
					}

					// Condition that lets user enters both trees
					else {
						System.out.println("You have " + players[i].howManyTreesPossible() + " places to do this.");
						System.out.print("First tree - Enter coordinates as row column: ");
						enterCoordinates();
						checkCoordinatesTree();
						players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
						players[i].showGarden();

						// After planting the first tree, he might not have space for the second. Player looses turn
						if (players[i].howManyTreesPossible() == 0) {
							System.out.println("You have no room for your second tree. You miss your turn.");
						}
						// Plants second tree
						else {
							System.out.println();
							System.out.print("Second tree - Enter coordinates as row column: ");
							enterCoordinates();
							checkCoordinatesTree();
							players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
							players[i].showGarden();
						}
					}
				}

				else if (tempRoll == 5 || tempRoll == 10) {
					players[i].showGarden();
					boolean findNew = true;
					
					// Set random coordinates for rabbit
					int rabbitRow = (int)rabbit.nextInt(size);
					int rabbitCol = (int)rabbit.nextInt(size);
					
					// If the garden is empty, the rabbit cannot eat anything and the user looses his turn
					if (players[i].howManyFlowersPossible() == (size*size)) {
						System.out.println("There is no place for the rabbit to eat. You miss your turn.");
					}
					
					// If there are stuff planted, the rabbit does its job
					else {
						// The do-while loop exists on whether the rabbit has to generate new coordinates
						do {
							// If the coordinates entered encounter an empty, then generate new ones
							if (players[i].whatIsPlanted(rabbitRow, rabbitCol) == '-') {
								rabbitRow = (int)rabbit.nextInt(size);
								rabbitCol = (int)rabbit.nextInt(size);
							}
							
							else {
								players[i].eatHere(rabbitRow, rabbitCol);
								System.out.println("The rabbit ate whatever was planted in location (" + rabbitRow + ", " + rabbitCol + ")");
								findNew = false;
							}
						} while (findNew == true);
						players[i].showGarden();
					}
				}

				else if (tempRoll == 2 || tempRoll == 4 || tempRoll == 8) {
					System.out.println("You must plant a tree (2x2)");
					System.out.println();
					players[i].showGarden();
					players[i].howManyTreesPossible();

					// If user has no place to plant his tree, he misses his turn
					if (players[i].howManyTreesPossible() == 0) {
						System.out.println("You have no room to plant your tree! You miss your turn.");
					}

					// If he has space, he places it
					else {
						System.out.println("You have " + players[i].howManyTreesPossible() + " places to do this.");
						System.out.print("Enter coordinates as row column: ");
						enterCoordinates();
						checkCoordinatesTree();
						players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
						players[i].showGarden();
					}
				}

				else if (tempRoll == 7 || tempRoll == 9 || tempRoll == 11) {
					System.out.println("You must plant a flower (1x1)");
					System.out.println();
					players[i].showGarden();

					// User enters flower to his garden
					System.out.println("You have " + players[i].howManyFlowersPossible() + " places to do this.");
					System.out.print("Enter coordinates as row column: ");
					enterCoordinates();
					checkCoordinatesFlower();
					players[i].plantFlowerInGarden(coordinates[0], coordinates[1]);
					players[i].showGarden();
				}
				System.out.println("");
				// After each round, his garden is checked on whether it's full or not
				players[i].isGardenFull();
				
				// If a player's garden is full after his turn, a winner is found and the game stops
				if (players[i].isGardenFull() == true) {
					winner = players[i].getName();
					winnerFound = true;
					break;
				}
				roundCounter++;
			}
			
//SECOND LOOP: LOOPS THROUGH PLAYERS BEFORE THE PLAYER WHO STARTED FIRST, SO AFTER THE END OF THE players[] ARRAY ------------
			// If a winner is found in the first big loop, this loop isn't executed
			if (winnerFound == false) {
				for (int i = 0; i < temp; i++) {
					System.out.println();
					System.out.println("--------------------------------------------------");
					tempRoll = playerDice.rollDice();
					System.out.println(players[i].getName() + " you rolled " + tempRoll + " " + playerDice.toString());
					playerIndex = i;

					if (tempRoll == 3) {
						System.out.println("You must plant a tree (2x2) and a flower (1x1)");
						System.out.println();
						players[i].showGarden();

						if (players[i].howManyTreesPossible() > 0) {
							System.out.println("Let's start with the tree. You have " + players[i].howManyTreesPossible() + " places to do this.");
							players[i].showGarden();
							System.out.println("You now have " + players[i].howManyFlowersPossible() + " places to do this.");
							System.out.print("Enter coordinates as row column: ");
							enterCoordinates();
							checkCoordinatesTree();
							players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
							players[i].showGarden();
						}
						else {
							System.out.println("You have no place to plant your tree.");
						}

						if(players[i].howManyFlowersPossible() > 0) {
							System.out.println("You still have a flower (1x1) flower to plant.");
							players[i].showGarden();
							System.out.println("You now have " + players[i].howManyFlowersPossible() + " places to do this.");
							System.out.print("Enter coordinates as row column: ");
							enterCoordinates();
							checkCoordinatesFlower();
							players[i].plantFlowerInGarden(coordinates[0], coordinates[1]);
							players[i].showGarden();
						}
						else {
							System.out.println("You have no place to plant your flower.");
						}
					}

					else if (tempRoll == 6) {
						System.out.println("You must plant 2 flowers (1x1)");
						System.out.println();
						players[i].showGarden();

						System.out.println("You have " + players[i].howManyFlowersPossible() + " places to do this.");

						System.out.print("First flower - Enter coordinates as row column: ");
						enterCoordinates();
						checkCoordinatesFlower();
						players[i].plantFlowerInGarden(coordinates[0], coordinates[1]);
						players[i].showGarden();

						if (players[i].howManyFlowersPossible() >= 1) {
							System.out.println();
							System.out.print("Second flower - Enter coordinates as row column: ");
							enterCoordinates();
							checkCoordinatesFlower();
							players[i].plantFlowerInGarden(coordinates[0], coordinates[1]);
							players[i].showGarden();
						}

						else if (players[i].howManyFlowersPossible() == 0) {
							System.out.println("Sorry! No room to plant another flower! ");
						}
					}

					else if (tempRoll == 12) {
						System.out.println("You must plant 2 trees (2x2)");

						System.out.println();
						players[i].showGarden();
						players[i].howManyTreesPossible();

						if (players[i].howManyTreesPossible() == 0) {
							System.out.println("You have no room to plant any of the trees! You miss your turn.");
						}

						else if (players[i].howManyTreesPossible() == 1) {
							System.out.println("There is enough room for 1 tree in your garden.Enter coordinates as row column: ");
							enterCoordinates();
							checkCoordinatesTree();
							players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
							players[i].showGarden();
						}

						else {
							System.out.println("You have " + players[i].howManyTreesPossible() + " places to do this.");
							System.out.print("First tree - Enter coordinates as row column: ");
							enterCoordinates();
							checkCoordinatesTree();
							players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
							players[i].showGarden();

							if (players[i].howManyTreesPossible() == 0) {
								System.out.println("You have no room for your second tree. You miss your turn.");
							}
							else {
								System.out.println();
								System.out.print("Second tree - Enter coordinates as row column: ");
								enterCoordinates();
								checkCoordinatesTree();
								players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
								players[i].showGarden();
							}
						}
					}

					else if (tempRoll == 5 || tempRoll == 10) {
						players[i].showGarden();
						boolean findNew = true;
						
						int rabbitRow = (int)rabbit.nextInt(size);
						int rabbitCol = (int)rabbit.nextInt(size);
						if (players[i].howManyFlowersPossible() == (size*size)) {
							System.out.println("There is no place for the rabbit to eat. You miss your turn.");
						}
						else {
							do {
								if (players[i].whatIsPlanted(rabbitRow, rabbitCol) == '-') {
									rabbitRow = (int)rabbit.nextInt(size);
									rabbitCol = (int)rabbit.nextInt(size);
								}
								else {
									players[i].eatHere(rabbitRow, rabbitCol);
									System.out.println("The rabbit ate whatever was planted in location (" + rabbitRow + ", " + rabbitCol + ")");
									findNew = false;
								}
							} while (findNew == true);
							players[i].showGarden();
						}
					}

					else if (tempRoll == 2 || tempRoll == 4 || tempRoll == 8) {
						System.out.println("You must plant a tree (2x2)");
						System.out.println();
						players[i].showGarden();
						players[i].howManyTreesPossible();

						if (players[i].howManyTreesPossible() == 0) {
							System.out.println("You have no room to plant your tree! You miss your turn.");
						}

						else {
							System.out.println("You have " + players[i].howManyTreesPossible() + " places to do this.");
							System.out.print("Enter coordinates as row column: ");
							enterCoordinates();
							checkCoordinatesTree();
							players[i].plantTreeInGarden(coordinates[0], coordinates[1]);
							players[i].showGarden();
						}
					}

					else if (tempRoll == 7 || tempRoll == 9 || tempRoll == 11) {
						System.out.println("You must plant a flower (1x1)");
						System.out.println();
						players[i].showGarden();
						playerIndex = i;

						System.out.println("You have " + players[i].howManyFlowersPossible() + " places to do this.");
						System.out.print("Enter coordinates as row column: ");
						enterCoordinates();
						checkCoordinatesFlower();
						players[i].plantFlowerInGarden(coordinates[0], coordinates[1]);
						players[i].showGarden();
					}
					System.out.println("");
					players[i].isGardenFull();
					
					if (players[i].isGardenFull() == true) {
						winner = players[i].getName();
						winnerFound = true;
						break;
					}
					roundCounter++;
				}
			}
			
			// If a winner in the game was found, the do-while loop stops as well
			if (winnerFound == true) {
				repeatRound = false;
			}
		} while (repeatRound == true);

		// If winner was found, execute the results() method
		if (winnerFound == true) {
			results();
		}

	}

// -------------------- Method that displays results after the game has finished -------------------------
	private static void results() {
		winner = players[playerIndex].getName();
		System.out.println();
		System.out.println("FINAL RESULTS");
		System.out.println("-------------");
		// RoundCounter is adding an extra +1 because the first round is not included in the roundCounter attribute (since it's a do-while loop)
		System.out.println("Here are the results after " + (roundCounter+1) + " rounds.");
		System.out.println();

		// Prints garden for each player
		for (int i = 0; i < players.length; i++) {
			System.out.println("-------------");
			System.out.println(players[i].getName() + "'s garden: ");
			players[i].showGarden();
			System.out.println();
		}
		System.out.println("And the winner is ..... " + winner + " !!!");
		System.out.println("Your garden is trash though");
		System.out.println();
		System.out.println("Hope you had fun!");
	}
	
// -------------------- Main method that runs the driver -------------------------
	public static void main(String[] args) {
		System.out.println("-------****-------****-------****-------****-----****-----\r\n" + 
				"	Welcome to Nancy's Crazy Garden Game! \r\n" + 
				"-------****-------****-------****-------****-----****----- ");

		System.out.println();
		System.out.println("To win this game you need some luck with the dice and a bit of strategy. \r\n" + 
				"Your garden is an NxN lot. You can plant flowers or trees. A flower takes one spot.\r\n" + 
				"A tree takes 4 spots (2x2). You roll the dice and based on the outcome you get to plant a pre-set number of trees and flowers. \r\n" + 
				" \r\n" + 
				"Rolls and their outcome:\r\n" + 
				"---------------------\r\n" + 
				"3: plan a tree (2x2) and a flower (1x1)\r\n" + 
				"6: plant 2 flowers (2 times 1x1)\r\n" + 
				"12: plant 2 trees (2 times 2x2)\r\n" + 
				"5 or 10: the rabbit will eat something that you have planted - might be a flower or part of a tree(1x1)\r\n" + 
				"Any other EVEN rolls: plant a tree (2x2)\r\n" + 
				"Any other ODD rolls: plant a flower (1x1)\r\n" + 
				" \r\n" + 
				"Minimum number of players: 2.\r\n" + 
				"Minimum garden size: 3x3.\r\n" + 
				"You can only plant in empty locations.\r\n" + 
				"To plant a tree you give the top left coordinates of the 2x2 space and I will check to make sure all 4 locations are free.\r\n" + 
				"Okay .. Let's start the game! May the best gardener win!!!");

		System.out.println();
		System.out.println();

		// Methods for the whole game
		checkGardenSize();
		askPlayersAmount();
		whoGoesFirst();
		theGame();
		
		keyboard.close();
	}

}
