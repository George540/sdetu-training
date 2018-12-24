package Practise;

import java.util.Scanner;

public class Lec2 {

	public static void main(String[] args) {
		
		int speed = 55;
		
		if (speed > 50)
			System.out.println("Too fast");
		if (speed > 30)
			System.out.println("Right speed");
		else
			System.out.println("Too slow");
		System.out.println();
		
		System.out.println("While Loop Ex1:");
		final int LIMIT = 5;
		int count = 1;
		
		while (count <= LIMIT)
		{
			System.out.println(count);
			count = count + 1;
	    }
		System.out.println("Done");
		
		System.out.println();
		System.out.println();
		
		System.out.println("While Loop Ex2:");
		int remainingStars = 5;
		
		while (remainingStars > 0)
		{
			System.out.println("*");
			remainingStars--;
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("While Loop Ex3: Goes on forever");
		/*int index = 1;
		
		while (index != 10)
		{
			System.out.println("Hello");
			index = index + 2;
		} */
		
		System.out.println();
		System.out.println();
		
		System.out.println("While Loop Ex4:");
		int loopCount = 0;
		
		while (loopCount < 9)
		{
			System.out.println(loopCount);
			loopCount++;
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("While Loop Ex5:");
		boolean finished = false;
		
		int firstInt = 3;
		int secondInt = 20;
		
		while (firstInt <= secondInt && !finished)
			if (secondInt / firstInt <= 2)
				finished = true;
			else
				firstInt++;
		    System.out.println(firstInt);
		// Reminder: It is int, therefore firstInt is rounded to integer
		    
		System.out.println();
		System.out.println();
		
		System.out.println("Do-While Loop Ex1:");
		int n = 0;
		while (n > 0)
		{
			System.out.println("*");
			n--;
		}
		System.out.println(n);
		System.out.println();
		
		int k = 0;
		do
		{
			System.out.println("*");
			k--;
		}
		while (k > 0);
		System.out.println(k);
		
		System.out.println();
		System.out.println();
		
		System.out.println("User-Controlled Do Loop:");
		String answer;
		do
		{
			// do the computation
			//...
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Do you wish to continue(yes/no)?");
			answer = keyboard.next();
		}
		while ((answer.toUpperCase()).compareTo("YES") == 0);
		
		System.out.println();
		System.out.println();
		
		System.out.println("Do Loop: Application1");
		int age;
		boolean valid;
		do
		{
			System.out.println("How old are you?");
			Scanner keyboard = new Scanner(System.in);
			age = keyboard.nextInt();
			valid = (age > 0) && (age < 125);
			if (!valid)
				System.out.println("error! try again!");
		}
		while (!valid);
		
		System.out.println();
		System.out.println();
		
		System.out.println("Do-While Loop with cases Ex:");
		int beta = 5;
		do
		{
			switch (beta)
			{
			case 1 : System.out.println('R');
			break;
			case 2 :
			case 4 : System.out.println('O');
			break;
			case 5 : System.out.println('L');
			}
			beta--;
		} while (beta > 1);
		System.out.println('X');
		
		System.out.println();
		System.out.println();
		
		System.out.println("For Loop Ex1:");
		
		int i;
		for (i = 1; i <= 10; i++)
			System.out.println(i);
		System.out.println(i);
		System.out.println(i);
		
		System.out.println();
		System.out.println();
		
		System.out.println("For Loop Ex2: if f<=0, infinite loop");
		for (int f=0; f < 0; f--)
			System.out.println("hello");
		System.out.println("DONE!");
		
		System.out.println();
		System.out.println();
		
		System.out.println("For Loop Ex3:");
		for (count = 1; count < 10; count++)
			System.out.println(count);
		// A, B = D
		
		System.out.println();
		System.out.println();
		
		System.out.println("For Loop Ex4:");
		int sum, p;
		//sum = 0;
		
		for (p=0 , sum=0; p < 10; sum += 1, p++)
			System.out.print(sum + "\t");
		
		System.out.println();
		System.out.println();
		
		System.out.println("For to While loop:");
		int u = 0;
		int r = 0;
		
		while (u <= 10)
		{
			System.out.println(u + " " + r);
			u++;
			r=2*u;
		}
		
		
	}
}
