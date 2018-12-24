package Practise;

import java.util.Arrays;

public class Chapter6Arrays {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("Arrays Ex1:");
		//A. False: double myDoubles[double] = {0.0, 1.0};
		//B. doublemyDoubles[5] new double(0.0, 1.0);
		int[] myInts = {0, 1, 2, 3, 4};
		System.out.println(Arrays.toString(myInts));
		//C. Correct
		
		System.out.println();
		System.out.println();
		
		System.out.println("Arrays Ex2:");
		int[] alpha = new int[75];
		System.out.println(Arrays.toString(alpha));
		// Prints 0-74 -> B is correct
		
		System.out.println();
		System.out.println();
		
		System.out.println("Arrays: Access to an element:");
		double[] scores = new double[10];
		scores[2] = 55.5;
		scores[0] =  scores[2] + 2;
		double mean = (scores[0] + scores[2])/2;
		System.out.println(Arrays.toString(scores));
		System.out.println("Mean: " + mean);
		
		System.out.println();
		System.out.println();
		
		/* System.out.println("Arrays: One by one");
		final int LIMIT = 5;
		int[] list = new int[LIMIT];
		System.out.println(Arrays.toString(list));
		for (int i = 0; i < LIMIT; i++);
		//		list[i] = (i+1)*10;
		System.out.println(Arrays.toString(list));
		*/
		
		System.out.println();
		System.out.println();
		
		System.out.println("Arrays Ex3: ");
		int[] myArray = new int[6];
		System.out.println(Arrays.toString(myArray));
		
		myArray[0] = 7;
		myArray[1] = 9;
		myArray[2] = -3;
		myArray[3] = 6;
		myArray[4] = 1;
		myArray[5] = -1;
		// myArray[myArray[1] - myArray[0]];
		// 9 - 7 = 2
		System.out.println(Arrays.toString(myArray));
		
		System.out.println();
		System.out.println();
		
		System.out.println("Arrays Ex4: Using loops:");
		int[] status = new int[10];
		int i;
		
		for (i = 0; i < 10; i++)
			status[i] = 1;
		System.out.println("Array named status: " + Arrays.toString(status));
		System.out.println("Status Length: " + status.length);
		
		System.out.println();
		System.out.println();
		
		System.out.println("Multidimensional Arrays:");
		double costofGoods[] [] []= new double [8] [2] [7];
		System.out.println(Arrays.toString(costofGoods));
		
		System.out.println();
		System.out.println();
		
		System.out.println("Multidimensional Arrays: Length");
		
		int[][] table = new int[5][10];
		
		for (int row=0; row < table.length; row++)
			for (int col=0; col < table[row].length; col++)
				table[row][col] = row * 10 + col;
		
		for (int row=0; row < table.length; row++) {
			for (int col=0; col < table[row].length; col++)
				System.out.print (table[row][col] + "\t");
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Multidimensional Arrays: Scores");
		
		int[][] score = { {1, 2, 3}, {1, 1, 1}, {3, 4, 5}, {10, 20, 30}};
		
		final int SODAS = score.length;
		final int PEOPLE = score[0].length;
		
		int[] sodaSum= new int[SODAS];
		int[] personSum= new int[PEOPLE];
		
		for (int soda=0; soda < SODAS; soda++)
			for (int person=0; person < PEOPLE; person++) {
				sodaSum[soda] += score [soda][person];
				personSum[person] += score [soda][person];
			}
			
		
		
		
	}
}
