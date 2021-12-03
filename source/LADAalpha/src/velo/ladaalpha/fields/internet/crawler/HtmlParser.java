package velo.ladaalpha.fields.internet.crawler;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class HtmlParser.
 */
public class HtmlParser {
	
	/**
	 * Regex for tag.
	 *
	 * @param tag the tag
	 * @return the string
	 */
	public static String regexForTag(String tag) {
		return "<"+tag+"\\s*.*>\\s*.*<\\/"+tag+">";
	}
	
	/**
	 * Pull.
	 *
	 * @param regex the regex
	 * @return the array list
	 */
	public static ArrayList<String> pull(String regex) {
		
		return null;
	}
	
	/**
	 * Parses the html.
	 *
	 * @param input the input
	 */
	public static void parse_html(String input) {
		
	}
}
