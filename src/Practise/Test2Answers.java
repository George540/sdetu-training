package Practise;

public class Test2Answers {

	public static void main(String[] args) {
		System.out.println("Q1:");
		//int big = 2147483648;
		//System.out.println(big);
		//System.out.println();
		
		System.out.println("Q2:");
		int x = 1, y = 2;
		int z = ((3*x*x)+(4*x*y)-(1/(2*x)))/3;
		System.out.println(z);
		
		System.out.println("Q3:");
		//a
		double a = 34.6;
		int b = (int) a;
		System.out.println(b);
		
		//b
		int c = 2;
		float d = 11/(float) c;
		System.out.println(d);
		
		//c
		double g = 8.0 + 3%2;
		System.out.println(g);
		System.out.println();
		
		// float w;
		// w = (double) (10%2); // syntax error
		
		double f;
		f = 10/3;
		System.out.println(f);
		// 3.0
		System.out.println();
		
		System.out.println("Q4:");
		int A = 2, B = 10, C = 5, D = 3; 
		D = D - B / C;
		C = C * B % C;
		A += (C+D);
		System.out.println(A);
		System.out.println();
		
		System.out.println("Q5:");
		char c1 = 'a', c2 = 'b', c3 = 'c';
		char c4 = '0';
		
		c4 = c1;
		c1 = c2;
		c2 = c3;
		c3 = c4;
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		
		System.out.println();
		
		System.out.println("Q6:");
		char init = 'M';
		System.out.print("init is \'" + init);
		System.out.println("\' " + "but \n ");
		System.out.print("10.0/3 is \n" + "10.0/3");
		System.out.println();
		
		System.out.println();
		System.out.println("Q7:");
		int v1 = 2;
		int v2 = 5;
		int res = 6;
		res = v1++ * v2--;
		System.out.println("v1: " + v1);
		System.out.println();
		System.out.println(" v2: " + v2 + " res: " + res);
		
		System.out.println();
		System.out.println("Q7:");
		double average;
		average = 1 + 1;

	}

}
