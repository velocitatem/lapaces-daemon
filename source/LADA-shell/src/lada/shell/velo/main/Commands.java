package lada.shell.velo.main;

import java.util.ArrayList;
import java.util.Arrays;

import velo.ladaalpha.misc.SystemCommand;

public class Commands {
	public static void say(Object msg) {
		System.out.println("\n\t" + msg + "\n");
	}

	public static void err(Object er) {
		say("Error: " + er);
	}
	
	public static void set(String[] inVec, String pass)  {
		if (pass.equals("function")) {
			String fun = inVec[2];
			Main.function = Integer.valueOf(fun);
		} else {
			if (Main.function >= 0 && inVec[2] != null) {
				int i = 0;
				for (String param : Main.f.getFunctions()[Main.function].getParams()) {
					if (param.equals(pass)) {
						Object d = (String) inVec[2];
						d = eval(d);
						Main.p[i] = d;
						Commands.say("set " + param + " ( " + Main.p[i].getClass() + " ) " + " = " + Main.p[i]);
					}
					i += 1;
				}
			} else {
				Object d = (String) inVec[2];
				d = eval(d);
				Main.p[Integer.valueOf(pass)] = d;
				Commands.say("set " + pass + " ( " + d.getClass() + " ) " + " = " + d);
			}
		}
	}
	public static void mode(String pass) {
		if(pass!=null) {
			switch(pass) {
			case "c":
				Main.mode = 1; 
				break;
			case "n":
				Main.mode = 0;
				break;
			}					
		}
		else {				
		}
	}
	public static void use(String pass) {
		String[] ms = pass.split("/");

		Module[] c = Modules.modules;
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
					Main.f = M1;
					Commands.say("using module: " + String.join("==>", ms));
					break;
				}
			} else {
			}
		}			
		
	
	}
	public static void list() {
		if (Main.f != null && Main.f.isLast()) {
			int i = 0;
			Commands.say("Functions contained in current module");
			for (Function fu : Main.f.getFunctions()) {
				System.out.println(
						"\t [" + i + "]\t" + fu.getName() + " :: " + Arrays.toString(fu.getParams()));
				i += 1;
			}
			System.out.println();
		}
	}
	public static void run(String[] inVec, String pass, String in) {
		if(pass==null) {
			Object result = Main.f.getFunctions()[Main.function].evaluate(Main.p);
			Object o = Main.f.getFunctions()[Main.function].stringify(result);
			Commands.say("Output: " + o);
		}
		else {
			if(pass.contains("/")) {
				
				String module = "load " + pass;
				String fun = "set function " + Integer.valueOf(inVec[2]);
				
				Main.forward(module);
				Main.forward(fun);
				if(inVec.length>3) {
					String[] parrs = in.substring(in.indexOf(inVec[3])).split(" ");
					for(int i = 0 ;i < parrs.length ; i += 2) {
						String vn = parrs[i], vv = parrs[i+1];
						Main.forward("set " + vn + " " + vv);
					}
				}
				
				Main.forward("report");
				Main.forward("run");					
			}
		}
	}
	
	public static void report() {
		Commands.say("Module:\t\t" + (Main.f != null ? Main.f.getName() : null));
		Commands.say("function:\t" + Main.function);
		ArrayList<Object> used = new ArrayList<Object>();
		for(Object o : Main.p) {
			if(o!=null) {
				used.add(o);
			}
		}
		Commands.say("Variables:\t" + Arrays.toString(used.toArray()));
	}
	public static void show( String pass) {
		if (pass != null) {
			switch (pass) {
			case "all":
				for (Module m : Modules.modules) {
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
					for (Module m : Modules.modules) {
						if (m.getName().equals(pass)) {
							say("Showing module " + pass);
							for (Module mm : m.getSubs()) {
								System.out.println("\t+ " + mm.getName());
								if(mm.isLast()) {
									int ifd = 0;
									for(Function fl : mm.getFunctions()) {
										System.out.println("\t \t- [" + ifd + "] " + describeFunction(fl));
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
	}
	public static Object eval(Object d) {
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

				}
			}
		}
		return d;
	}
	public static String describeFunction(Function f) {
		return " " + f.getName() + " :: " + Arrays.toString(f.getParams()) + (f.isDesc()?"\t("+f.getDescrition()+")":"") ;
	}
}
