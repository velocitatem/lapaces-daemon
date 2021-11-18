package lade.shell.velo.main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static String prompt() {
		Scanner myObj = new Scanner(System.in);
		System.out.print("lade> ");
		return myObj.nextLine();
	}

	public static Module[] modules = { 
			new Module("physics", new Module[] {
					new Module("kinematics", new Function[] { 
							ModuleFunctions.averageSpeed(), 
							ModuleFunctions.deltaT() 
					}),
					new Module("vectors", new Function[] {
							ModuleFunctions.complexVectorMagnitude(),
							ModuleFunctions.complexVectorThetaDegrees(),
							ModuleFunctions.complexVectorfromParams()
					})
			}), 
			new Module("math", new Module[] { 
					new Module("calculus", new Function[] { 
						ModuleFunctions.limit(),
						ModuleFunctions.numericalDifferentiation(), 
						ModuleFunctions.tangentLine() 
					}),
					new Module("operations", new Function[] {
						ModuleFunctions.sysLin(),
						ModuleFunctions.factorial()
					})
			}),
			new Module("astronomy", new Module[] {
					new Module("navigation", new Function[] {
						ModuleFunctions.julianDay(),
						ModuleFunctions.julianDay1()
							
					})
			}),
			new Module("computing", new Module[] {
					new Module("cryptography", new Function[] {
						ModuleFunctions.hashFunctions() 	
					}),
					new Module("sorting", ModuleFunctions.sort())
			}),
			new Module("system", new Module[] {
					new Module("network", new Function[] {
						ModuleFunctions.portScan(),
						ModuleFunctions.deviceProbe(),
						ModuleFunctions.scanNetwork(),
						ModuleFunctions.ping(),
						ModuleFunctions.getLanIP(),
						ModuleFunctions.getPublicIP(),
						ModuleFunctions.getPrivateIP(),
						ModuleFunctions.urlIP()
					})
			})
			

	};

	private static String describeFunction(Function f) {
		return " " + f.getName() + " :: " + Arrays.toString(f.getParams()) ;
	}
	
	private static void say(Object msg) {
		System.out.println("\n\t" + msg + "\n");
	}

	private static void err(Object er) {
		say("Error: " + er);
	}
	
	private static Object eval(Object d) {
		try {
			d = Integer.valueOf((String) d);
		} catch (Exception e) {
			try {
				d = Double.valueOf((String) d);
			} catch (Exception ee) {
				try {
					String val = (String)d;							
					if(val.contains("arr")) {
						int is = val.indexOf("(")+1, ie = val.indexOf(")");
						String[] arr = val.substring(is, ie).split(",");	
						System.out.println(Arrays.toString(arr));
						return arr;
					}
				}catch (Exception eee) {
					// TODO: handle exception
				}
			}
		}
		return d;
	}
	
	static Module f = null;
	static int function = -1;
	static Object[] p = new Object[20];
	
	public static void forward(String in) {
		
		String[] inVec = in.split(" ");
		String cmd = inVec[0], pass = inVec.length > 1 ? inVec[1] : null;
		switch (cmd) {
		case "exit":
		case "bye":
			say("Goodbye, I will never forget this");
			System.exit(0);
			return;
		case "help":
		case "-h":
			System.out.println(Help.getHelp());
			break;
		case "show":
			if (pass != null) {
				switch (pass) {
				case "all":
					for (Module m : modules) {
						System.out.println("\t+ " + m.getName());
						for (Module mm : m.getSubs()) {
							System.out.println("\t \t+ " + mm.getName());
							if (mm.isLast()) {
								int ifd = 0;
								for(Function fl : mm.getFunctions()) {
									System.out.println("\t \t \t- [" + ifd + "] " + describeFunction(fl));
									ifd+=1;
								}
							} else {
								for (Module mmm : mm.getSubs()) {
									System.out.println("\t \t \t+ " + mmm.getName());
								}
							}
						}
					}
					break;
				default:
					if (pass.contains("/")) {

					} else {
						for (Module m : modules) {
							if (m.getName().equals(pass)) {
								say("Showing module " + pass);
								for (Module mm : m.getSubs()) {
									System.out.println("\t+ " + mm.getName());
									if(mm.isLast()) {
										int ifd = 0;
										for(Function fl : mm.getFunctions()) {
											System.out.println("\t \t- [" + ifd + "] " + fl.getName() + " :: " + Arrays.toString(fl.getParams()) );
											ifd+=1;
										}
									}
								}
							}
						}
					}

					break;
				}
			}
			break;
		case "run":
			if(pass==null) {
				Object result = f.getFunctions()[function].evaluate(p);
				Object o = f.getFunctions()[function].stringify(result);
				say("Output: " + o);
			}
			else {
				if(pass.contains("/")) {
					
					String module = "load " + pass;
					String fun = "set function " + Integer.valueOf(inVec[2]);
					
					forward(module);
					forward(fun);
					if(inVec.length>3) {
						String[] parrs = in.substring(in.indexOf(inVec[3])).split(" ");
						for(int i = 0 ;i < parrs.length ; i += 2) {
							String vn = parrs[i], vv = parrs[i+1];
							forward("set " + vn + " " + vv);
						}
					}
					
					forward("report");
					forward("run");					
				}
			}
			break;
		case "set":
			if (pass.equals("function")) {
				String fun = inVec[2];
				function = Integer.valueOf(fun);
			} else {
				if (function >= 0 && inVec[2] != null) {
					int i = 0;
					for (String param : f.getFunctions()[function].getParams()) {
						if (param.equals(pass)) {
							Object d = (String) inVec[2];
							d = eval(d);
							p[i] = d;
							say("set " + param + " ( " + p[i].getClass() + " ) " + " = " + p[i]);
						}
						i += 1;
					}
				} else {
					Object d = (String) inVec[2];
					d = eval(d);
					p[Integer.valueOf(pass)] = d;
					say("set " + pass + " ( " + d.getClass() + " ) " + " = " + d);
				}
			}
			break;
		case "report":
			say("Module:\t\t" + (f != null ? f.getName() : null));
			say("Function:\t" + function);
			ArrayList<Object> used = new ArrayList<Object>();
			for(Object o : p) {
				if(o!=null) {
					used.add(o);
				}
			}
			say("Variables:\t" + Arrays.toString(used.toArray()));
			break;
		case "functions":
		case "list":
			if (f != null && f.isLast()) {
				int i = 0;
				say("Functions contained in current module");
				for (Function fu : f.getFunctions()) {
					System.out.println(
							"\t [" + i + "]\t" + fu.getName() + " :: " + Arrays.toString(fu.getParams()));
					i += 1;
				}
				System.out.println();
			}
			break;
		case "use":
		case "load":
			String[] ms = pass.split("/");

			Module[] c = modules;
			for (String m : ms) {
				Module M1 = null;
				for (Module s : c) {
					if (s.getName().equals(m)) {
						M1 = s;
					}
				}
				if (M1 != null) {
					c = M1.getSubs();
					if (M1.isLast()) {
						f = M1;
						say("using module: " + String.join("==>", ms));
						break;
					}
				} else {
				}
			}

			break;
		default:
			if (in.length() > 0) {
				SystemCommand.run(in);
			}
			break;
		}
	}
	

	public static void main(String[] args) {


		while (true) {
			try {
				
				forward(prompt());
				
			} catch (Exception e) {
				err(e.getMessage());
				e.printStackTrace();
			}

		}
	}

}
