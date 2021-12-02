package lada.shell.velo.main;

import java.io.Console;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import velo.ladaalpha.misc.SystemCommand;
import velo.ladaalpha.misc.TerminalColors;
import velo.q.structure.data.Credentials;

public class Main {

	public static String prompt() {
		Scanner myObj = new Scanner(System.in);
		System.out.print(TerminalColors.BLACK + TerminalColors.WHITE_BACKGROUND + "lada" + (mode == 1 ? " M:c " : "")
				+ ">" + TerminalColors.RESET + " ");
		start = System.currentTimeMillis();
		return myObj.nextLine();
		
	}

	public static Module f = null;
	public static int function = -1;
	public static Object[] p = new Object[200];
	public static int mode = 0;
	public static String[] curCom = {};
	
	public static void forward(String in) {
		ArrayList<String> vec = Commands.parseCommand(in);		
		String[] inVec = new String[vec.size()]; int i = 0;
		for(String s : vec) {if(!s.equals("")&&!s.equals(" ")) {inVec[i] = s;i+=1; }}
		curCom = inVec;
		String cmd = inVec[0], pass = inVec.length > 1 ? inVec[1] : null;
		if(cmd==null) return;
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
		case "tell":
			Commands.tell(pass, inVec);
			break;
		case "show":
			Commands.show(pass);
			break;
		case "run":
			Commands.run(inVec, pass, in);
			break;
		case "set":
			Commands.set(inVec);
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

	static long start = 0, end = 0;
	public static void main(String[] args) {
		File f = new File(args[0]);
		Credentials.path = f.getAbsolutePath();
		
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
				end = System.currentTimeMillis();
				System.out.println("\tRuntime: "+(end-start)*0.9);

			} catch (Exception e) {
				Commands.err(e.getMessage());
				e.printStackTrace();
			}

		}
	}

}
