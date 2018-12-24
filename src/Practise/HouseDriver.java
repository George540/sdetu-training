package Practise;

//George Mavroeidis (40065356), 13 November of 2018

// This is the driver for the class House. This driver tests out different methods and prints results from the class file.

public class HouseDriver {

	public static void main(String[] args) {
		// Welcoming banner
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|---------------------------- Welcome to the... -------------------------------|");
		System.out.println("|------------------------- HOUSING SIMULATOR 2018! ----------------------------|");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("|______________________________________________________________________________|");
		System.out.println();
		
		// Creating a new house profile (instantiating an object)
		House H1 = new House();
		House H2 = new House(10000);
		House H3 = new House(4, 100000);
		House H4 = new House(2, "detached", 200000);
		
		// Setting features for each house (giving particular local variables for each object)
		// It has been noted that the age fo H1 and H2 are supposed to be 50, and not 1950 as stated in the sample results.
		// This is to clear out any confusion, because we were instructed to set age to 50 for the first 2 constructors, while the sample result said 1950.
		System.out.println("House H1: This house is type " + H1.getType() + ". Its age is " + H1.getAge() + " and costs $" + H1.getCost());
		System.out.println("House H2: This house is type " + H2.getType() + ". Its age is " + H2.getAge() + " and costs $" + H2.getCost());
		System.out.println("House H3: This house is type " + H3.getType() + ". Its age is " + H3.getAge() + " and costs $" + H3.getCost());
		System.out.println("House H4: This house is type " + H4.getType() + ". Its age is " + H4.getAge() + " and costs $" + H4.getCost());
		
		// Setters Test (Acessors)
		System.out.println();
		System.out.println("Accessor Method: The housetype for house H4 is " + H4.getType() + ", its age is " + H4.getAge() + ", and it costs $" + H4.getCost());
		
		// Estimated Prices
		System.out.println();
		System.out.println("The estimated price of house H3 is $" + H3.estimatePrice(4, "attached", 120000));
		System.out.println("The estimated price of house H4 is $" + H4.estimatePrice(2, "detached", 220000));
		
		// Mutator Methods
		System.out.println();
		H3.setAge(5);
		System.out.println("Mutator Method: The new age for house H3 is " + H3.getAge());
		H3.setType("semi-detached");
		System.out.println("Mutator Method: The new housetype for house H3 is " + H3.getType());
		H3.setCost(240000);
		System.out.println("Mutator Method: The new cost for house H3 is " + H3.getCost());
		H3.setAgeAndCost(6, 245000);
		System.out.println("Mutator Method: The new house H3 age is " + H3.getAge() + " and its new cost is " + H3.getCost());
		H3.setAll(14, "semi-detached", 260000);
		System.out.println("Mutator Method: The new housetype for house H3 is " + H3.getType() + ", its new age is " + H3.getAge() + " and its cost is " + H3.getCost());
		
		// toString Method
		System.out.println();
		System.out.println("toString: " + H3.toString());
		
		// isEqual Method
		System.out.println();
		System.out.println("Houses H1 and H2 are equal is " + H1.equals(H2));
		System.out.println("Houses H1 and H4 are equal is " + H1.equals(H4));
		
		// isLessThan Method
		System.out.println();
		System.out.println("House H4 is less than H3 is " + H4.isLessThan(H3));
		
		//isGreaterThan Method
		System.out.println();
		System.out.println("House H1 is greater than H3 is " + H1.isGreatterThan(H3));
		
		// Closing Message
		System.out.println();
		System.out.println("|___________________________ Program is ending. Have a nice day! _____________________________|");
		
		
	}

}
