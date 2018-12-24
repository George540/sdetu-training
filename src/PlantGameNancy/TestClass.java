package PlantGameNancy;

import java.util.Random;
import java.util.Arrays;

public class TestClass {

	public static void main(String[] args) {
		Garden[] many = new Garden[3];
		many[0] = new Garden(4);
		many[1] = new Garden(5);
		many[2] = new Garden();
		
		char c = 67;
		System.out.println(c);
		
		int result = 2;
		
		result = increment(result, increment(result, result));
		System.out.println(result);
	}
	
	static int face = 0;
	public static boolean isTail() {
		if (face == 1) 
			return true;
		else
			return false;
	}
	
	public static void what() {
		face = 2;
		return;
	}

	public static int increment(int x) {
		return x+1;
	}
	
	public static int increment(int x, int value) {
		return x+value;
	}
}