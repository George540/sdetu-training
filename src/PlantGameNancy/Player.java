package PlantGameNancy;

// Used in the Driver LetsPlay

public class Player {
	
	// 2 attributes: name is the user name of the player on a String and garden is an attribute of type Garden, which creates a garden class for each player called
	private String name;
	private Garden garden;
	
	// Constructor: initializes user name and dimension of garden array for each player
	public Player(String username, int dimension) {
		name = username;
		garden = new Garden(dimension);
	}
	
	// Getter: accessor for player's name
	public String getName() {
		return name;
	}
	
	// Returns how many flowers possible for each player
	public int howManyFlowersPossible() {
		return garden.countPossibleFlowers();
	}
	
	// Returns how many trees possible
	public int howManyTreesPossible() {
		return garden.countPossibleTrees();
	}
	
	// Returns what character is planted in a certain location of the garden
	public char whatIsPlanted(int r, int c) {
		return garden.getInLocation(r, c);
	}
	
	public void plantTreeInGarden(int r, int c) {
		garden.plantTree(r, c);
	}
	
	// Plants flower at a user given location
	public void plantFlowerInGarden(int r, int c) {
		garden.plantFlower(r, c);
	}
	
	// Removes a character 'f' or 't' from the garden (rabbit)
	public void eatHere(int r, int c) {
		garden.removeFlower(r, c);
	}
	
	// Returns a boolean variable whether the garden is full or not
	public boolean isGardenFull() {
		return garden.gardenFull();
	}
	
	// Shows the garden of each player
	public void showGarden() {
		System.out.println(garden.toString());
	}
}
