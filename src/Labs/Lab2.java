package Labs;

public class Lab2 {

	public static void main(String[] args) {
		// Factorial is the multiplication of an integer and its previous integers:
		// fact(0) = 0
		// fact(1) = 1
		// fact(2) = 2 * 1
		// fact(3) = 3 * 2 * 1
		// fact(4) = 4 * 3 * 2 * 1
		
		int num = 5;
		System.out.println("The factorial of " + num + " is: " + factorial(num));
	}
	public static int factorial(int n) {
		
	    if (n == 0) {
	        return 1;
	    }
	    else if (n == 1) {
	        return 1;
	    }
	    return factorial(n-1) * n;
	}

}
