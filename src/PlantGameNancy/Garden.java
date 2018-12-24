package PlantGameNancy;

// Used in the Driver LetsPlay and Class Player

public class Garden {
	
	//1 attribute: 2D array of characters which display the garden for each player	
	private char garden[][];
	
	// Default Constructor: sets the dimensions of the garden to 3x3 (default value of the game)
	public Garden() {
		garden = new char[3][3];
		initializeGarden();
	}
	
	// Constructor with 1 argument: sets the dimensions of the garden to size x size, where size is an input user variable at least 4
	public Garden(int size) {
		garden = new char[size][size];
		initializeGarden();
	}

	// Private method that initializes the garden array, where all dimensions are filled with the empty character '-'
	private void initializeGarden() {
		for (int row = 0; row < garden.length; row++) {
			for (int col = 0; col < garden.length; col++)
				garden[row][col] = '-';
		}
	}
	
	// Method that gets the location of a certain dimension within the garden array
	public char getInLocation(int r, int c) {
		return garden[r][c];
	}
	
	// Method that plants a 1x1 flower (character 'f') in the given dimensions of the garden
	public void plantFlower(int r, int c) {
		garden[r][c] = 'f';
	}
	
	// Method that plants a 2x2 tree (character 't') in the given dimensions of the garden
	public void plantTree(int r, int c) {
		garden[r][c] = 't';
		garden[r+1][c] = 't';
		garden[r][c+1] = 't';
		garden[r+1][c+1] = 't';
	}
	
	// Method that removes a plant 'f' or component of a 't' from the garden and replaces it with an empty character '-'
	public void removeFlower(int r, int c) {
		garden[r][c] = '-';
	}
	
	// Method that returns the amount of trees calculated by reiterating through the garden array
	public int countPossibleTrees() {
		int countTrees = 0;
		for(int row = 0; row < garden.length-1; row++) {
			for (int col = 0; col < garden[row].length-1; col++) {
				if (garden[row][col] == '-' && garden[row+1][col] == '-' && garden[row][col+1] == '-' && garden[row+1][col+1] == '-') {
					countTrees++;
				}
			}	
		}
		return countTrees++;
	}
	
	// Method that returns the amount of flowers calculated by reiterating through the garden array
	public int countPossibleFlowers() {
		int countFlowers = 0;
		for(int row = 0; row < garden.length; row++) {
			for (int col = 0; col < garden[row].length; col++) {
				if (garden[row][col] == '-'){
					countFlowers++;
				}
			}	
		}
		return countFlowers;
	}
	
	// Method that returns a boolean, stating if the garden is full or not. If no empties are found, garden is full
	public boolean gardenFull() {
		int countEmpty = 0;
		
		for(int row = 0; row < garden.length; row++) {
			for (int col = 0; col < garden[row].length; col++) {
				if (garden[row][col] == '-'){
					countEmpty++;
				}
			}
		}
		if (countEmpty > 0) {
			return false;
		}
		else
			return true;
	}
	
	// Method that returns the display of a garden in the form of a concatenated string
	public String toString() {
		  String str = "  | ";
		  
		  for (int row = 0; row < garden.length; row++) {
			  if (row == 0) {
				  for(int k = 0; k < garden.length; k++) {
					  str += k + "   ";
				  }
				  str += "\n\n";
			  }
			  str += row + " | ";
			  for (int col = 0; col <garden.length; col++) {
				  str += garden[row][col] + "   ";
			  }
			  str += "\n\n";
		  }
		  return str;  
	}
}
