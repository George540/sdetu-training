package opp;

import java.util.Scanner;

public class MusicalDriver {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		MusicalNote note1 = new MusicalNote(1,6);
		MusicalNote note2 = new MusicalNote();
		MusicalNote note3 = new MusicalNote(2,2);
		MusicalNote note4 = new MusicalNote(3,3);
		
		for(int i = 15; i >=0; i--) {
			note1.shorten();
		}
		System.out.println(note1.getDuration());

		System.out.println(note1.toString());
		
		if (note1.getDuration() > note3.getDuration())
			System.out.println("Note1 has bigger duration.");
		else if (note1.getDuration() < note3.getDuration())
			System.out.println("Note3 has bigger duration.");
		else
			System.out.println("Note1 and note3 have same duration");
		
		if (note1.equals(note4))
			System.out.println("Note1 and not4 have same sylable and duration");
		else
			System.out.println("Notes not equal");
		
		MusicalNote[] myTune = new MusicalNote[600];
		
		for (int i = 0; i < myTune.length; i++) {
			System.out.print("Enter syllable: ");
			int s = keyboard.nextInt();
			
			System.out.print("Enter duration: ");
			int d = keyboard.nextInt();
			
			myTune[i] = new MusicalNote(s,d);
			System.out.println(myTune[i].toString());
		}	
	}

}
