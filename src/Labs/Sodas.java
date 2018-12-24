package Labs;

import java.util.Arrays;

public class Sodas {

	public static void main(String[] args) {
		int[][] scores = { {1, 2, 3}, {1, 1, 1}, {3, 4, 5}, {10, 20, 30}};
		
		final int SODAS = scores.length;
		final int PEOPLE = scores[0].length;
		
		int[] sodaSum= new int[SODAS];
		int[] personSum= new int[PEOPLE];
		
		System.out.println(Arrays.toString(sodaSum));
		System.out.println(Arrays.toString(personSum));
		
		
		for (int soda=0; soda < SODAS; soda++)
			for (int person=0; person < PEOPLE; person++) {
				sodaSum[soda] += scores[soda][person];
				personSum[person] += scores[soda][person];
			}
		
		for (int soda=0; soda < SODAS; soda++)
			System.out.println("Soda #" + (soda+1) + ": " + sodaSum[soda]/PEOPLE);
		
		for (int person =0; person < PEOPLE; person++)
			System.out.println ("Person #"+ (person+1) +": "+ personSum[person]/SODAS);
			
	}

}
