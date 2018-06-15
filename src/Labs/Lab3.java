package Labs;

public class Lab3 {

	public static void main(String[] arr) {
		// Declare and Define an array:
		int[] grades = {75, 68, 81, 55, 92};
		System.out.println("The maximum grade of this list is: " + maxValue(grades));
		System.out.println("The minimum grade of this list is: " + minValue(grades));
		System.out.println("The average grade of this list is: " + avgValue(grades));
	}
		
	// Function for finding the maximum value from list
	public static int maxValue(int[] grades) {
		int max = grades[0];
	    for (int i = 0; i < grades.length; i++) {
	        if (grades[i] > max) {
	            max = grades[i];
	        }
	    }
	    return max;
	}
	
	// Function for finding the minimum value from list
	public static int minValue(int[] grades) {
		int min = grades[0];
	    for (int i = 0; i < grades.length; i++) {
	        if (grades[i] < min) {
	            min = grades[i];
	        }
	    }
	    return min;
	}
	
	// Function for finding the average number from list
	public static int avgValue(int[] grades) {
		int sum = 0;
	    for (int n = 0; n < grades.length; n++) {
	        sum = sum + grades[n];
	    }
	    return sum / grades.length;
	}
}
