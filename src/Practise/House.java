package Practise;

//George Mavroeidis (40065356), 13 November of 2018

// In this java program, fundamentals of Object-Oriented Programming are used to present a housing application that stores information of different houses.
// This project used methods to set different actions for different houses. Methods make actions using the variables initially declared.
// Constructors set the information for different houses. Getters and setters access and set new information provided.
// There are other methods such as methods for estimating price, which set interest for houses, depending their age and type.

public class House {
	
	private int age;
	private String type;
	private double cost;
	
	
	// Constructors (0,1,2,3 arguments)
	// Constructors that are accessed by classes. They set information for different objects.
	public House() {
		age = 50;
		type = "Attached";
		cost = 100000;
	}
	
	public House(int price) {
		age = 50;
		type = "Attached";
		cost = price;
	}
	
	public House(int lifespan, double price) {
		age = lifespan;
		type = "Attached";
		cost = price;
	}

	House(int lifespan, String category, double price) {
		age = lifespan;
		type = category;
		cost = price;
	}
	
	// Getters(Accessor): Age, Type, Cost
	// Accessors are methods that retrieve the value of a specific house.
	public int getAge() {
		return age;
	}
	
	public String getType() {
		return type;
	}
	
	public double getCost() {
		return cost;
	}
	
	// Setters(Mutator): Age, Type, Cost
	// Mutators modify/set the value of a specific house.
	public void setAge(int lifespan) {
		this.age = lifespan;
	}
	
	public void setType(String category) {
		this.type = category;
	}
	
	public void setCost(double price) {
		this.cost = price;
	}
	
	// Setters: 1) Method that sets all 3.
	
	public void setAll(int lifespan, String category, double price) {
		this.age = lifespan;
		this.type = category;
		this.cost = price;
	}
	
	// Setters: 2) Method that sets age and cost.
	public void setAgeAndCost (int lifespan, double price) {
		this.age = lifespan;
		this.cost = price;
	}
	
	// Method that estimates price depending on type and age
	// The calculation might indeed be wrong, since the interest is calculated only from the initial cost.
	// My professor, Nancy Acemian, stated that even if my calculation is wrong, but I follow the results of the sample for Q2,
	// it will be counted as correct, even if the sample for Q2 is wrong. A lot of students were confused as well.
	public double estimatePrice(int lifespan, String category, double price) {
		if (category.equalsIgnoreCase("Attached")) {
			price = 100000.0;
			if (lifespan <= 5)
				cost = price + lifespan*(0.01*(price));
			else if (lifespan > 5)
				cost = price + 5*(0.01*(price)) + (lifespan-5)*(0.02*(price));
		}
		else if (category.equalsIgnoreCase("Semi-detached")) {
			price =  150000.0;
			if (lifespan <= 5)
				cost = price + lifespan*(0.02*(price));
			else if (lifespan > 5)
				cost = price + 5*(0.02*(price)) + (lifespan-5)*(0.03*(price));
		}
		else if (category.equalsIgnoreCase("Detached")) {
			price = 200000.0;
			if (lifespan <= 5)
				cost = price + lifespan*(0.02*(cost));
			else if (lifespan > 5)
				cost = price + 5*(0.02*(price)) + (lifespan-5)*(0.02*(price));
		}
		return cost;
	}
	
	// ToString Method: printing method that lists and concatenates multiple variables.
	public String toString() {
		return ("This house is type " + type + ". Its age is " + age + " and costs $" + cost);
	}
	
	
	// Comparison Methods: compares houses by their age, cost and type.
	public boolean equals(House otherHouse) {
		return((age == otherHouse.age) && (type.equalsIgnoreCase(otherHouse.type)));
	}
	
	public boolean isLessThan(House otherHouse) {
		return((cost < otherHouse.cost));
	}
	
	public boolean isGreatterThan(House otherHouse) {
		return((cost > otherHouse.cost));
	}
}
