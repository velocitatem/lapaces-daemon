package velo.ladealpha.main;

import java.util.Scanner;

import velo.ladealpha.fields.astronomy.celestial_systems.SystemAlpha;

public class Main {

	public static void main(String[] args) {
		System.out.println(
				" _        _    ____  _____\n" + 
				"| |      / \\  |  _ \\| ____|\n" + 
				"| |     / _ \\ | | | |  _|\n" + 
				"| |___ / ___ \\| |_| | |___\n" + 
				"|_____/_/   \\_|____/|_____|\n" + 
				"LApaces DEmon - Elementary Computational Inteligence by Daniel Rosel \n"
				);
	
		System.out.println("Please selct a module to load:");
		System.out.println(				
				"+----------------+\n" + 
				"|    Modules     |\n" + 
				"+----------------+\n" + 
				"| 1) Astronomy   |\n" + 
				"| 2) Psychology  |\n" + 
				"| 3) Economy     |\n" + 
				"| 4) Mathematics |\n" + 
				"| 5) Politics    |\n" + 
				"| 6) Physics     |\n" + 
				"+----------------+\n" + 
				"\n" + 
				""
				);
		Scanner myObj = new Scanner(System.in);
		System.out.print("\n > ");
		String choice = myObj.nextLine(); 
		
		System.out.println("Loading module "+ choice + "...");
		String[] moduleOptions = {				
				"+----------------------------------------------+\n" + 
				"|                  Astronomy                   |\n" + 
				"+----------------------------------------------+\n" + 
				"| 1) Radians of the moon relative to Full Moon |\n" + 
				"| 2) N orbits of moon after D days             |\n" + 
				"+----------------------------------------------+\n" 				
				,
				"\n" + 
				"+------------------------+\n" + 
				"|       Psychology       |\n" + 
				"+------------------------+\n" + 
				"| 1) Behavior Prediction |\n" + 
				"| 2) Behavior Analysis   |\n" + 
				"+------------------------+\n" 
			
		};
		System.out.println(moduleOptions[Integer.valueOf(choice)-1]);
		System.out.print("\n > ");
		String choice1 = myObj.nextLine();
		
		
	}
}
