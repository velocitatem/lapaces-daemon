package lada.shell.velo.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import velo.ladaalpha.fields.linguistics.LinguisticParser;
import velo.ladaalpha.misc.SystemCommand;
import velo.q.structure.DataPoint;
import velo.q.structure.Source;
import velo.q.structure.Sources;
import velo.q.structure.data.Credentials;

public class Commands {
	public static void say(Object msg) {
		System.out.println("\n\t" + msg + "\n");
	}

	public static void err(Object er) {
		say("Error: " + er);
	}

	public static ArrayList<String> parseCommand(String cmd) {
		ArrayList<String> r = new ArrayList<String>();
		if(!cmd.contains(" ")) {
			r.add(cmd); return r;
		}
		String[] s = cmd.split(""), ss = cmd.split(" ");
		boolean block = false;
		int blockI = 0;
		int i2 = 0;
		for (String sf : ss) {
			if (!block) {
				if (sf.contains("=")) {
					block = true;
					blockI = i2;
				} else {
					r.add(sf);
				}
			}
			i2 += 1;
		}
		ArrayList<String> pars = new ArrayList<String>();
		for (int g = blockI; g < ss.length; g += 1) {
			pars.add(ss[g]);
		}
		boolean isopen = false;
		int lastIndex = 0, i = 0;
		String build = "";
		for (String par : pars) {
			if (isopen) {
				build += " " + par;
				if (par.contains(")")) {
					isopen = false;
					r.add(build);
					build = "";
				} else {
				}
			} else {
				if (par.contains("(") && !par.contains(")")) {
					isopen = true;
					build += " " + par;
				} else if (par.contains("(") && par.contains("")) {
					r.add(par);
				} else {
					r.add(par);
				}
			}
		}
		for(int w = 0 ; w < r.size() ; w+=1) {
			r.set(w, r.get(w).trim());
		}
		return r;
	}

	public static void set(String[] inVec) {
		String[] sp = inVec[1].split("=");
		String pass = sp[0];
		if(sp[1].contains("(") || sp[1].contains(")")) {
			sp[1] = LinguisticParser.removeAll(sp[1], new String[] {"\\(", "\\)"}); 
		}
		if (pass.equals("function")) {
			String fun = sp[1];
			int fs = -1;
			int i = 0;
			for (Function ff : Main.f.getFunctions()) {
				if (ff.getName().equals(fun)) {
					fs = i;
				}
				i++;
			}
			if (fs == -1) {
				Main.function = Integer.valueOf(fun);
			} else {
				Main.function = fs;
			}
		} else {
			if (Main.function >= 0 && inVec[1] != null) {
				int i = 0;
				pass = sp[0];
				for (String param : Main.f.getFunctions()[Main.function].getParams()) {
					if (param.equals(pass)) {
						Object d = (String) sp[1];
						d = eval(d);
						Main.p[i] = d;
						Commands.say("set " + param + " ( " + Main.p[i].getClass() + " ) " + " = " + Main.p[i]);
					}
					i += 1;
				}
			} else {
				pass = sp[0];
				Object d = (String) sp[1];
				d = eval(d);
				Main.p[Integer.valueOf(pass)] = d;
				Commands.say("set " + pass + " ( " + d.getClass() + " ) " + " = " + d);
			}
		}
	}

	public static void mode(String pass) {
		if (pass != null) {
			switch (pass) {
			case "c":
				Main.mode = 1;
				break;
			case "n":
				Main.mode = 0;
				break;
			}
		} else {
		}
	}

	public static void tell(String pass, String[] inVec) {

		boolean initRes = false;
		if (!Credentials.inited) {
			initRes = Credentials.init();
			if (!initRes) {
				say("You need to add your credentials");
				return;
			}
		} else {

		}

		DataPoint focus = null;
		for (Source s : Sources.getSoruces()) {
			for (DataPoint dp : s.getData()) {
				if (dp.getName().equals(pass))
					focus = dp;
			}
		}
		Object[] oo = new Object[inVec.length - 2];
		for (int i = 2; i < inVec.length; i += 1) {
			oo[i - 2] = inVec[i];
		}
		if (focus != null) {
			Object o = focus.fetch(oo);
			if (Arrays.asList(inVec).contains("|")) {
				String pc = inVec[Arrays.asList(inVec).indexOf("|") + 1];
				switch (pc) {
				case "plot":
					focus.plot(o);
					break;
				}
			} else {
				System.out.println(focus.stringify(o));
			}
		} else
			return;
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
				System.out.println("\t [" + i + "]\t" + fu.getName() + " :: " + Arrays.toString(fu.getParams()));
				i += 1;
			}
			System.out.println();
		}
	}

	public static void run(String[] inVec, String pass, String in) {
		if (inVec.length<2) {
			Object result = Main.f.getFunctions()[Main.function].evaluate(Main.p);
			Object o = Main.f.getFunctions()[Main.function].stringify(result);
			Commands.say("Output: " + o);
		} else {
			if (pass.contains("/")) {

				String module = "load " + pass;
				String fun = "set function=" + inVec[2];

				Main.forward(module);
				Main.forward(fun);
				if (inVec.length > 3) {
					ArrayList<String> parrs = Commands.parseCommand(in.substring(in.indexOf(inVec[3])));
					for (int i = 0; i < parrs.size(); i += 2) {
						Main.forward("set " + parrs.get(i));
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
		for (Object o : Main.p) {
			if (o != null) {
				used.add(o);
			}
		}
		Commands.say("Variables:\t" + Arrays.toString(used.toArray()));
	}

	private static String describeDataPoint(DataPoint p) {
		return " " + p.getName() + " :: " + Arrays.toString(p.getQueryParams());
	}

	public static void show(String pass) {
		if (pass != null) {
			switch (pass) {
			case "tell":
				for (Source s : Sources.getSoruces()) {
					System.out.println("\t+ " + s.getName());
					for (DataPoint point : s.getData()) {
						System.out.println("\t\t- " + describeDataPoint(point));
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
							for (Function fl : mm.getFunctions()) {
								System.out.println("\t \t \t- [" + ifd + "] " + describeFunction(fl));
								ifd += 1;
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
								if (mm.isLast()) {
									int ifd = 0;
									for (Function fl : mm.getFunctions()) {
										System.out.println("\t \t- [" + ifd + "] " + describeFunction(fl));
										ifd += 1;
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
					String val = (String) d;
					if (val.contains("arr[")) {
						int is = val.indexOf("[") + 1, ie = val.indexOf("]");
						String[] arr = val.substring(is, ie).split(",");
						return arr;
					} 
				} catch (Exception eee) {

				}
			}
		}
		return d;
	}

	public static String describeFunction(Function f) {
		return " " + f.getName() + " :: " + Arrays.toString(f.getParams())
				+ (f.isDesc() ? "\t(" + f.getDescrition() + ")" : "");
	}
}
