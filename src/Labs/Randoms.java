package Labs;

import java.util.Scanner;
import java.util.Arrays;

public class Randoms {

	public static void main(String[] args) {
//		int n = 20;
//		if(product_n(n) > 1000)
//			System.out.println("YES");
//		else
//			System.out.println("NO");
//			
//	}
//	public static int product_n(int n) {
//		if (n > 0) {
//			int product = 1;
//			for(int i = 1; i <= n; i++) {
//				product *= i;
//			}
//			return product;
//		}
//		else return 0;
		
		String str1 = "What";
		String str2 = "What";
//	}
		double[] a1 = {1.0, 2.0, 3.0, -4.0, -5.0, -6.0}; 
		double[] a2 = {5.0, 1.5, 2.0, 2.5, 3.0, 3.5};
		
		innerProduct();
		System.out.println((int)innerProduct());

		
	}
	
	public static double innerProduct() {
		double[] a1 = {1.0, 2.0, 3.0, -4.0, -5.0, -6.0}; 
		double[] a2 = {5.0, 1.5, 2.0, 2.5, 3.0, 3.5};
		
		double sum = 0;
		for (int i = 0; i < a1.length; i++) {
			sum += (a1[i] * a2[i]);
		}
		return sum;
	}
}