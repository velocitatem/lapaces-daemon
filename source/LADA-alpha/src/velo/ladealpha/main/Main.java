package velo.ladealpha.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import velo.ladaalpha.fields.astronomy.celestial_systems.SystemAlpha;
import velo.ladaalpha.fields.math.LinearFunction;


// TODO: Auto-generated Javadoc
class IModInterp {
	public static Object compute(IMod module, int method, Object[] pass) {
		switch(method) {
		case 1:
			return module.m1(pass);
		case 2:
			return module.m2(pass);
		default:
			return null;
		}
	}
}

/**
 * The Class Main.
 */
public class Main {

	/**
	 * Prompt.
	 *
	 * @return the string
	 */
	private static String prompt() {
		Scanner myObj = new Scanner(System.in);
		System.out.print("\n lade> ");
		String choice = myObj.nextLine();
		return choice;
	};
	 
	/**
	 * The Interface mthd.
	 */
	interface mthd {
		
		/**
		 * Res.
		 *
		 * @return the object
		 */
		Object res();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		
		
		System.out.println(
				" _        _    ____  _____\n" + 
				"| |      / \\  |  _ \\| ____|\n" + 
				"| |     / _ \\ | | | |  _|\n" + 
				"| |___ / ___ \\| |_| | |___\n" + 
				"|_____/_/   \\_|____/|_____|\n" + 
				"LApaces DEmon - Elementary Computational Inteligence by Daniel Rosel \n"
				);
	
		ArrayList<Object> varList = new ArrayList<Object>();
		
		Module[] modules = {
				new Module("astronomy", new Module[] {
					new Module("celestial-systems", new Module[] {
						
					})
				}),
				new Module("life", new Module[] {
						
				}),
				new Module("math", new Module[] {
					new Module("calculus", new Module[] {
						
					}),
					
				}),
				new Module("physics", new Module[] {
					
				})
		};

		
		ArrayList<String> moduleNames = new ArrayList<String>();
		for(int i = 0 ; i < modules.length ; i += 1) {
			moduleNames.add(modules[i].getName());
		}
		
		Object[] par = new Object[10];
		
		String moduleName = null;
		IMod module = null;
		int method = -1;
		
		while(true) {
			String res = prompt().toLowerCase();
			String[] resV = res.split(" ");
			String alpha = resV[0];
			switch(alpha) {
			case "show":
				if(resV[1].equals("all")) {
					for(Module m : modules) {
						System.out.println("\t -" + m.getName());
					}
				}
				else if (moduleNames.contains(resV[1])) {
					for(Module m : modules[moduleNames.indexOf(resV[1])].getSub()) {
						System.out.println("\t - " + m.getName());
					}
				}
				else if (resV[1].contains("/")) {
					String[] s = resV[1].split("/");
					
				}
				break;
			case "method":
				method = Integer.valueOf(resV[1]);
				break;
			case "use":				
				if (resV[1].contains("/")) {
					moduleName = resV[1];
					String[] s = resV[1].split("/");
					// check if exists					
					int index1 = moduleNames.indexOf(s[0]);
					// load module
					Module p = modules[index1];
					if(p!=null) {
						// load submodule
						System.out.println("*\t"+ p.getName() + " exists");
						Module cf = null;
						for(Module child : p.getSub()) {
							if(child.getName().equals(s[1])) {
								cf = child;
								
							}
						}
						if(cf != null ) {
							if(cf.getIsfinal()) {
								
							}
							else {
								System.out.println("*\t"+ cf.getName() + " exists");
								
								String clas = s[2];
								// load class								
								for(Module classe : cf.getSub()) {
									if(classe.getName().equals(clas)) {
										IMod m = classe.getCls();										
										System.out.println("\n \t Select a method \n");
										int index = 1;
										module = m;
										for(String methodI : classe.getMethods()) {
											System.out.println("\t ["+index+"] \t"+methodI);
											index += 1;
										}
										
									}
								}								
								
							}
							
						}
						else {
							System.out.println("**\t"+ s[1] + " does not exist");
						}
					}
					
				}
				break;
			case "set":
				int index = Integer.valueOf(resV[1]);
				if(index < 10) {
					Object val = (String)resV[2];
					try {
						val = Double.valueOf((String)val);
					}
					catch (Exception e) {
						try {
							val = Integer.valueOf((String) val);
						}
						catch (Exception e1) {
							
						}
					}
					System.out.println("\n set " + val + " - " + val.getClass() + " to index " + index);
					par[index] = val;
				}
				else {
					System.out.println("Error: Index out of bound");
				}
				break;
			case "report":
				System.out.println("\n \t Module: " + moduleName);
				System.out.println("\t Method: " + method);
				System.out.println("\t Variables: " + Arrays.toString(par));
				break;
			case "run":
				if(module == null) {
					System.out.println("Error: missing module");
					break;
				}
				if(method <= 0) {
					System.out.println("Error: missing method");
					break;
				}
				Object out = IModInterp.compute(module, method, par);
				System.out.println("\t Output: " + out);
				break;
			case "exit":
				return;				
			}
			
		}
		
	}
}
