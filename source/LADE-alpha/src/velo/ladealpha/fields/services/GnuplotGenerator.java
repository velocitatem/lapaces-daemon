package velo.ladealpha.fields.services;

import java.util.ArrayList;
import java.util.Random;

import velo.ladealpha.fields.math.Equation;

public class GnuplotGenerator {
	public String generate(Equation[] set, String title) {
		String res = "set term png \n"
				+ "set output '" + title + ".png' \n"
						+ "set title '" + title + "' \n";
				
		ArrayList<String> used = new ArrayList<String>();
		int i = 0;
		for(Equation eq : set) {
			String str = eq.toString().toLowerCase();
			str = str.replaceAll("math.", "");
			Random rnd = new Random();
			char c = (char) ('a' + rnd.nextInt(26));
			String f = c+"(x)";
			res+=f+"= "+str+"\n";
			used.add(f);
			i+=1;
		}
		
		res += "plot " + String.join(", ", used);
		
		return res;
	}
}
