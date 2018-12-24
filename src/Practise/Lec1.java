package Practise;

import java.util.Scanner;


public class Lec1 {

	public static void main(String[] args) {
		
		// ex:
		int p=1, t=2;
		System.out.println("x+y=" +p+t);
		System.out.println();
		
		//ex: prints
		System.out.println("one\ntwo\nthree\n"); // no spaces required for \n
		System.out.println();
		
		// ex1:
		int num1 = 1, num2 = 0;
		int num3 = 2 * num1++ + --num2 * 5;
		System.out.println(num3);
		System.out.println();
		
		// ex1.5:
		System.out.println("Try for incrementation:");
		int nb=50;
		int w;
		w = ++nb;
		System.out.println(nb);
		System.out.println(w);
		System.out.println();
		
		// ex2:
		int x = 1, y = 10, z = 3;
		int q = ++x * y-- + z++;
		System.out.println(q);
		System.out.println();
		
		// ex3:
		int a = 1;
		int c = a++ + a--;
		System.out.print(a + " ");
		System.out.print(c);
		System.out.println();
		
		// ex4:
		int e = 1, f = 2;
		int g = e++ + e + 2*(--f) + 3/f--;
		System.out.println(g);
		System.out.println();
		
		double o;
		o = 2/4*1.0;
		System.out.println("o is: " + o);
		System.out.println();
		System.out.println();
		
		
		
		
		byte b1 = 1, b2 = 127, b3;
		// b3 = b1 + b2; // wrong (cannot convert int to byte due to interval)
		// b3 = 1 + b2; wrong
		// b3 = (byte)1 + b2;
		// b3 = 1 + b2;
		b3 = (byte)(1 + b2); // e is correct
		System.out.println(b3);
		System.out.println();
		
		
		String string1 = new String("This is a string");
		String string2 = ""; // null string
		String string3, string4, string5;
		
		System.out.println("Content of string1: \"" + string1 + "\"");
		System.out.println("Length of string1: " + string1.length());
		System.out.println("Content of string2: \"" + string2 + "\"");
		System.out.println("Length of string2: " + string2.length());
		System.out.println();
		
		string2 = string1.concat(" hello");
		string3 = string2.toUpperCase();
		string4 = string3.replace('E', 'X');
		string5 = string4.substring(3, 10);
		
		System.out.println(string2);
		System.out.println(string3);
		System.out.println(string4);
		System.out.println(string5);
		System.out.println();
		
		
		// If statements
		int speed = 55;
		if (speed > 50)
			System.out.println("Too fast!");
		
		if (speed > 30)
			System.out.println("fast");
		
		else
			System.out.println("slow");
		
		System.out.println();
		
		int num = 4;
		if (num > 5)
			System.out.println("A");
		else
			System.out.println("B");
		if (num < 10)
			System.out.println("C");
		System.out.println("D");
		System.out.println();
		
		int someInt = 10;
		if (someInt > 30)
			System.out.println("Moe ");
		System.out.print("Larry ");
		System.out.println("Curly ");
		

		int numr = 5 % 2;
		System.out.println(numr);
		System.out.println();
		System.out.println();
		
		
		int number = 4;
		if (number > 5)
			System.out.println("line A");
		else
			System.out.println("line B");
		if (num < 10)
			System.out.println("line C");
		System.out.println("line D");
		System.out.println();
		System.out.println();
		
		int anInt = 10;
		if (anInt == 30)
			System.out.println("Moe ");
		System.out.print("Larry ");
		System.out.print("Curly");
		System.out.println();
		System.out.println();
		
		String s1 = "Java isn't just for breakfast.";
		String s2 = "JAVA isn't just for breakfast.";
		
		if (s1.equals(s2))
			System.out.println("The two lines are equal.");
		else
			System.out.println("The two lines are not equal.");
		
		if (s1.equalsIgnoreCase(s2))
			System.out.println("But the lines are equal, " + "ignore case.");
		else
			System.out.println("Lines are not equal, " + " even ignoring case.");
		System.out.println();
		System.out.println();
		
		System.out.println('a' < 'b');
		System.out.println("aBcD".equals("abcd"));
		System.out.println("aBcD".equalsIgnoreCase("aBcD"));
		System.out.println("aBcD".compareTo("aBcD"));
		System.out.println("aBcD".compareTo("aBcC"));
		System.out.println("abc".compareTo("ab"));
		System.out.println("abc".compareTo("abcd"));
		System.out.println();
		System.out.println();
		
		// compile error
		// int what = 10;
		// int w = ++what++;
		// System.out.println(w);
		
		
		String ans = "I am George";
		System.out.println(ans.charAt(ans.length() - 1));
		System.out.println();
		
		
		int u = 0;
		if (u >= 10)
			if (a < 20)
				a = a +2;
			else
				a = a + 1;
		
		System.out.println("u is: " + u);
		System.out.println();
		System.out.println();
		
		
		
		int grade, category;
		System.out.println("Enter a grade (0 to 100):");
		
		
		
		
		// Strings work as well since Java 8.0
		/* Scanner keyboard = new Scanner(System.in);
		grade = keyboard.nextInt();
		category = grade / 10;
		
		switch (category) {
		
		case 10: case 9:
			System.out.println("excellent");
			break;
			
		case 8:
			System.out.println("nice job");
			break;
			
		case 7:
			System.out.println("average");
			break;
			
		case 6:
			System.out.println("below average");
			break;
			
		// like else
		default:
			System.out.println("problem");
		} */
	

		
		
	
		System.out.println();
		System.out.println();
		
		
		
		int larger = ((num1 > num2) ? 2 : 1);
		System.out.println("Larger: " + larger);
	
		System.out.println();
		System.out.println();
		
		int count = 10;
		System.out.println("Change is " + count +((count==1) ? " Dime" : " Dimes"));
		
		System.out.println();
		System.out.println();
		
		
		/* int year = keyboard.nextInt();
		if (year % 400 == 0)
			System.out.println("leap");
		else
			if(year % 100 == 0)
				System.out.println("not leap");
			else {
				if(year % 4 == 0)
					System.out.println("leap");
				else
					System.out.println("not leap");
			}
			
		*/
		
		System.out.println("Riot example");
		int riot = -1;
		
		if ((riot > 0) && (1/(riot+1) > 10))
			System.out.println(riot);
		System.out.println("not riot");
		
		
		
		
	}
}
