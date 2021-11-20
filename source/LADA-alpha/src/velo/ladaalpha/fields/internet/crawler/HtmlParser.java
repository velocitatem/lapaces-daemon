package velo.ladaalpha.fields.internet.crawler;

import java.util.ArrayList;

public class HtmlParser {
	
	public static String regexForTag(String tag) {
		return "<"+tag+"\\s*.*>\\s*.*<\\/"+tag+">";
	}
	
	public static ArrayList<String> pull(String regex) {
		
		return null;
	}
	
	public static void parse_html(String input) {
		
	}
}
