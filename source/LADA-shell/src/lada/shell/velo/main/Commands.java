package lada.shell.velo.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import velo.ladaalpha.misc.SystemCommand;
import velo.q.structure.DataPoint;
import velo.q.structure.Source;
import velo.q.structure.Sources;

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
			int fs = -1;
			int i = 0;
			for(Function ff : Main.f.getFunctions()) {
				if(ff.getName().equals(fun)) {
					fs = i;
				}
				i++;
			}
			if(fs==-1) {
				Main.function = Integer.valueOf(fun);				
			} else {
				Main.function = fs;
			}
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
	
	public static void tell(String pass, String[] inVec ) {
		DataPoint focus = null;
		for(Source s : Sources.getSoruces()) {
			for(DataPoint dp : s.getData()) {
				if(dp.getName().equals(pass)) focus=dp;
			}
		}
		Object[] oo = new Object[inVec.length-2];
		for(int i = 2; i < inVec.length ; i += 1) {
			oo[i-2] = inVec[i];
		}
		if(focus!=null) {
			Object o = focus.fetch(oo);
			System.out.println(focus.stringify(o));
		}
		else return;
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
				String fun = "set function " + inVec[2];
				
				Main.forward(module);
				Main.forward(fun);
				if(inVec.length>3) {
					String[] parrs = in.substring(in.indexOf(inVec[3])).split(" ");
					for(int i = 0 ;i < parrs.length ; i += 2) {
						if(!parrs[i].contains("s(")) {							
							String vn = parrs[i], vv = parrs[i+1];
							Main.forward("set " + vn + " " + vv);
						}
					}
				}
				
				Main.forward("report");
				Main.forward("run");
				Main.p = new Object[200];
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
	
	private static String describeDataPoint(DataPoint p) {
		return " " + p.getName() + " :: " + Arrays.toString(p.getQueryParams());
	}
	
	public static void show( String pass) {
		if (pass != null) {
			switch (pass) {
			case "tell":
				for(Source s : Sources.getSoruces()) {
					System.out.println("\t+ " + s.getName());
					for(DataPoint point : s.getData()) {
						System.out.println("\t\t- " + describeDataPoint(point) );
					}
				}
			break;
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
			d = Double.valueOf((String) d);
		} catch (Exception e) {
			try {
				d = Integer.valueOf((String) d);
			} catch (Exception ee) {
				try {
					String val = (String)d;							
					if(val.contains("arr(")) {
						int is = val.indexOf("(")+1, ie = val.indexOf(")");
						String[] arr = val.substring(is, ie).split(",");							
						return arr;
					}
					else if (val.contains("_")) {
						d = val.replaceAll("_", " ");
						System.out.println(d);
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
