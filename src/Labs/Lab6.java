package Labs;

import java.util.Scanner;

public class Lab6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] arr = new int[5];
		int num;
		int count = 0;
		
		System.out.println("Enter numbers below: ");
		
		do {
			
			num = in.nextInt();
			if(num % 4 != 0 || num < 0 ) {
				arr[count] = num;
				count++;
			}
		} while (count < 5);
		
		System.out.println();
		
		for(int i = 0; i<arr.length; i++) {
			if (i > 0)
				for (int j = 1; j <= i; j++)
					System.out.print("\t");
			
			for (int k = i; k < arr.length; k++)
				System.out.print(arr[k] + "\t");
			
			System.out.println();
		}

	}

}
