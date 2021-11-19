package lada.shell.velo.main;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import velo.ladaalpha.misc.SystemCommand;
import velo.ladaalpha.misc.TerminalColors;

public class Main {

	public static String prompt() {
		Scanner myObj = new Scanner(System.in);
		System.out.print(TerminalColors.BLACK + TerminalColors.WHITE_BACKGROUND + "lade" + (mode == 1 ? " M:c " : "")
				+ ">" + TerminalColors.RESET + " ");
		return myObj.nextLine();
	}

	public static Module f = null;
	public static int function = -1;
	public static Object[] p = new Object[20];
	public static int mode = 0;

	public static void forward(String in) {

		String[] inVec = in.split(" ");
		String cmd = inVec[0], pass = inVec.length > 1 ? inVec[1] : null;

		switch (cmd) {
		case "exit":
		case "bye":
			Commands.say("Goodbye, I will never forget this");
			System.exit(0);
			return;
		case "help":
		case "-h":
			System.out.println(Help.getHelp());
			break;
		case "mode":
			Commands.mode(pass);
			break;
		case "show":
			Commands.show(pass);
			break;
		case "run":
			Commands.run(inVec, pass, in);
			break;
		case "set":
			Commands.set(inVec, pass);
			break;
		case "report":
			Commands.report();
			break;
		case "functions":
		case "list":
			Commands.list();
			break;
		case "use":
		case "load":
			Commands.use(pass);
			break;
		default:
			if (in.length() > 0) {
				SystemCommand.run(in);
			}
			break;
		}
	}
	
	public static String mod = null;
	public static int satPam = 0;
	
	
	public static void forwardC(String in) {
		String[] inVec = in.split(" ");
		String cmd = inVec[0];
		
		if(mod!=null) {
			switch(mod) {
			case "use":
				forward(mod + " " + cmd);				
				break;
			}
		}
		else {
			switch(cmd) {
			case "m":				
				Commands.show("all");
				mod = "use";				
				break;
			}
		}
	}

	public static void main(String[] args) {

		while (true) {
			try {
				switch (mode) {
				case 0:
					forward(prompt());
					break;
				case 1:
					forwardC(prompt());
					break;
				}

			} catch (Exception e) {
				Commands.err(e.getMessage());
				e.printStackTrace();
			}

		}
	}

}
