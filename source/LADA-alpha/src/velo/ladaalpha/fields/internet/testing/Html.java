package velo.ladaalpha.fields.internet.testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import velo.ladaalpha.fields.internet.crawler.HtmlParser;

public class Html {
	private String html;

	public Html(String html) {
		super();
		this.html = html;
	}

	public boolean ContainsElement(Element element) {
		String patternString = element.getRegex();	
		Pattern pattern = Pattern.compile(patternString);		
		Matcher matcher = pattern.matcher(this.html);
		
		return matcher.find();
		
	}
	
	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
}
